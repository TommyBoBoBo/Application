package com.example.my210zyy.base;

import android.app.Application;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author: 王重阳
 * @date: 2020/2/11
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int i = initLayoutId();
        setContentView(i);
        initView();
        initListener();
        initData();
    }

    protected abstract int initLayoutId();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void initListener();

}
