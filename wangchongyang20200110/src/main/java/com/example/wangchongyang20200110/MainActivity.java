package com.example.wangchongyang20200110;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.example.wangchongyang20200110.bean.DataBean;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager vp;
    private MyVpAdapter myVpAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = findViewById(R.id.vp);
        tab = findViewById(R.id.tab);


        String path="http://47.94.132.125/baweiapi/ElevenTwo";

        NetUtil.getInstance().doGet(path, new NetUtil.CallBack() {
            @Override
            public void oncheng(String json) {
                Gson gson = new Gson();
                DataBean dataBean = gson.fromJson(json, DataBean.class);
                tab.setupWithViewPager(vp);
                myVpAdapter = new MyVpAdapter(getSupportFragmentManager(), (List<DataBean>) dataBean);
                vp.setAdapter(myVpAdapter);
            }

            @Override
            public void obai(String msg) {

            }
        });

    }





}
