package com.example.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.adapter.MybaseAdapter;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.bean.DataBean;
import com.example.myapplication.bean.ResultBean;
import com.example.myapplication.net.NetUtil;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private XListView xlist;
    private MybaseAdapter mybaseAdapter;
    private ArrayList<ResultBean> list = new ArrayList<>();
    private int page = 1;




    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        xlist = findViewById(R.id.xlist);
        xlist.setPullLoadEnable(true);
        xlist.setPullRefreshEnable(true);

    }

    @Override
    protected void initListener() {
        xlist.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                page=1;
                getData(page);
                xlist.stopRefresh();
            }

            @Override
            public void onLoadMore() {
                page++;
                getData(page);
                xlist.stopLoadMore();

            }


        });

    }


    @Override
    protected void initData() {
        getData(page);

    }
    private void getData(int page) {

        String path="http://172.17.8.100/movieApi/movie/v1/findHotMovieList?page="+page+"&count=10";

        NetUtil.getInstance().doGet(path, new NetUtil.CallBack() {
            @Override
            public void oncheng(String json) {
                Gson gson = new Gson();
                DataBean dataBean = gson.fromJson(json, DataBean.class);
                List<ResultBean> result = dataBean.getResult();
                //分页
                list.addAll(result);
                mybaseAdapter = new MybaseAdapter(MainActivity.this,list);
                xlist.setAdapter(mybaseAdapter);
            }

            @Override
            public void onbai(String msg) {

            }
        });


    }
}
