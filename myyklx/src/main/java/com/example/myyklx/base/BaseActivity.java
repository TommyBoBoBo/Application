package com.example.myyklx.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author: 王重阳
 * @date: 2020/2/15
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layoutid = initLayoutid();
        setContentView(layoutid);

        initView();
        initListener();
        initData();
    }

    protected abstract int initLayoutid();
    protected abstract void initView();
    protected abstract void initListener();
    protected abstract void initData();


}
