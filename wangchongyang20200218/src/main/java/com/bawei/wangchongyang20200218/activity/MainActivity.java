package com.bawei.wangchongyang20200218.activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.bawei.wangchongyang20200218.R;
import com.bawei.wangchongyang20200218.adapter.MyFrgmentVpAdapter;
import com.bawei.wangchongyang20200218.base.BaseActivity;
import com.bumptech.glide.Glide;

public class MainActivity extends BaseActivity {


    private android.support.design.widget.TabLayout tab;
    private android.support.v4.view.ViewPager vp;
    private android.widget.ImageView imags;

    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        imags = (ImageView) findViewById(R.id.imags);
    }

    @Override
    public void initListener() {

        imags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐式跳转到相册
                Intent intent = new Intent(Intent.ACTION_PICK);

                intent.setType("image/*");
                startActivityForResult(intent, 100);

            }
        });

    }
    private MyFrgmentVpAdapter myFrgmentVpAdapter;
    @Override
    public void initData() {

        myFrgmentVpAdapter = new MyFrgmentVpAdapter(getSupportFragmentManager());
        tab.setupWithViewPager(vp);
        vp.setAdapter(myFrgmentVpAdapter);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100&&resultCode==RESULT_OK){
            Uri uri = data.getData();
            //获取相册图片需要添加sd权限
            Glide.with(this).load(uri).into(imags);
            }
    }
}
