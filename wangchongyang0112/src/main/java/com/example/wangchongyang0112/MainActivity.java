package com.example.wangchongyang0112;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.wangchongyang0112.adapter.MyBaseAdapter;
import com.example.wangchongyang0112.bean.DataBean;
import com.example.wangchongyang0112.bean.ResuletBean;
import com.example.wangchongyang0112.net.NetUtil;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private XListView  xlist;
    private int page=1;
    private MyBaseAdapter myBaseAdapter;
    private ArrayList<ResuletBean>list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getData(page);
        xlist = findViewById(R.id.xlist);
        xlist.setPullRefreshEnable(true);
        xlist.setPullLoadEnable(true);
        initListener();

    }
    private void initListener() {
    xlist.setXListViewListener(new XListView.IXListViewListener() {
        @Override
        public void onRefresh() {
            page=1;
            list.clear();
            getData(page);
            xlist.stopRefresh();
            Toast.makeText(MainActivity.this, "刷新", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onLoadMore() {
            page++;
            getData(page);
            xlist.stopLoadMore();
            Toast.makeText(MainActivity.this, "加载", Toast.LENGTH_SHORT).show();
        }
    });
    }


    private void getData(int page) {
        String path="http://blog.zhaoliang5156.cn/baweiapi/news?page="+page+"&pageSize=20";

        NetUtil.getInstance().doGet(path, new NetUtil.CallBack() {
            @Override
            public void oncheng(String json) {
                Gson gson = new Gson();
                DataBean dataBean = gson.fromJson(json, DataBean.class);

                List<ResuletBean> result = dataBean.getResult();
                Log.d("xx", "oncheng: "+result);
                //分页
                list.addAll(result);
                myBaseAdapter = new MyBaseAdapter(MainActivity.this,list);
                xlist.setAdapter(myBaseAdapter);
            }

            @Override
            public void onbai(String msg) {

            }
        });
    }
}
