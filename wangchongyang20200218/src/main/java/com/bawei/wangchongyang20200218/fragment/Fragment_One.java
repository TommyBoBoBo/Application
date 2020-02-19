package com.bawei.wangchongyang20200218.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.bawei.wangchongyang20200218.R;
import com.bawei.wangchongyang20200218.activity.WebActivity;
import com.bawei.wangchongyang20200218.adapter.MyBaseAdapter;
import com.bawei.wangchongyang20200218.base.BaseFragment;
import com.bawei.wangchongyang20200218.bean.DataBean;
import com.bawei.wangchongyang20200218.bean.ResultBean;
import com.bawei.wangchongyang20200218.net.NetUtil;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/2/18
 */
public class Fragment_One extends BaseFragment {
    private XListView xlists;
    private int n=2;
    private ArrayList<ResultBean>list = new ArrayList<>();

    @Override
    public int initLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    public void initView() {

        xlists =rootView.findViewById(R.id.xlists);
        //开启上下拉刷新加载
        xlists.setPullRefreshEnable(true);
        xlists.setPullLoadEnable(true);
        getData(n);
    }

    @Override
    public void initListener() {


        xlists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), WebActivity.class);
                startActivity(intent);
            }
        });


        xlists.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                n=2;
                //清空列表
                list.clear();
                getData(n);
                //关闭刷新动作
                xlists.stopRefresh();
                Toast.makeText(getContext(), "刷新", Toast.LENGTH_SHORT).show();


            }


            @Override
            public void onLoadMore() {
                n=3;
                getData(n);
                //关闭加载动作
                xlists.stopLoadMore();
                Toast.makeText(getContext(), "加载", Toast.LENGTH_SHORT).show();
            }


        });

    }

    private MyBaseAdapter myBaseAdapter;


    private void getData(int n) {
        String path = "http://blog.zhaoliang5156.cn/api/news/lawyer"+n+".json";
        NetUtil.getInstance().doGet(path, new NetUtil.CallBack() {
            @Override
            public void oncheng(String json) {

                //解析
                Gson gson = new Gson();
                DataBean dataBean = gson.fromJson(json, DataBean.class);
                List<ResultBean> listdata = dataBean.getListdata();
                Log.d("xxx", "oncheng: "+listdata);
                //分页
                list.addAll(listdata);
                //添加适配器
                myBaseAdapter = new MyBaseAdapter(list,getContext());
                xlists.setAdapter(myBaseAdapter);

            }

            @Override
            public void onbai(String msg) {

            }
        });

    }
    @Override
    public void initData() {

    }
}
