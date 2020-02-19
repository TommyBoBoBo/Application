package com.example.myyklx.activity;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.myyklx.R;
import com.example.myyklx.adapter.MyFragmntVpAdaptere;
import com.example.myyklx.base.BaseActivity;
import com.qy.xlistview.XListView;

public class MainActivity extends BaseActivity {


    private android.support.design.widget.TabLayout tab;
    private android.support.v4.view.ViewPager vp;

    @Override
    protected int initLayoutid() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
    }

    @Override
    protected void initListener() {

    }
 private MyFragmntVpAdaptere myFragmntVpAdaptere;
    @Override
    protected void initData() {

    //添加适配器
        myFragmntVpAdaptere = new MyFragmntVpAdaptere(getSupportFragmentManager());
        vp.setAdapter(myFragmntVpAdaptere);
        tab.setupWithViewPager(vp);

    }
}
