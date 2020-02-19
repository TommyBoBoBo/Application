package com.example.mytab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.example.mytab.adapter.MyFVPOneAdapter;
import com.example.mytab.base.BaseActivity;
import com.example.mytab.bean.DataBean;
import com.example.mytab.bean.ResultBean;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity {
     private TabLayout tabOne;
     private MyFVPOneAdapter myFVPOneAdapter;
    private ViewPager vpOne;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        vpOne = (ViewPager) findViewById(R.id.viewPager);
        tabOne = findViewById(R.id.tabLayout);
    }

    @Override
    protected void initListener() {

    }

    String path ="http://172.17.8.100/small/commodity/v1/findCategory";
    @Override
    protected void initData() {

        NetUtil.getInstance().doGet(path, new NetUtil.CallBack() {
            @Override
            public void onCg(String json) {
                Gson gson = new Gson();
                DataBean dataBean = gson.fromJson(json, DataBean.class);
                List<ResultBean> result = dataBean.getResult();
                tabOne.setupWithViewPager(vpOne);
                myFVPOneAdapter = new MyFVPOneAdapter(getSupportFragmentManager(),result);
                vpOne.setAdapter(myFVPOneAdapter);
                Log.d("tag",json);
            }

            @Override
            public void onSb(String msg) {
                Log.d("tag",msg);
            }

        });



    }
}
