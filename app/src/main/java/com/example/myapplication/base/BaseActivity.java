package com.example.myapplication.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


/**
 * @author: 王重阳
 * @date: 2020/1/7
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        int layoutId = initLayoutId();
        setContentView(layoutId);

        initView();
        initListener();
        initData();

    }

    protected abstract int initLayoutId();
    protected abstract void initView();
    protected abstract void initListener();
    protected abstract void initData();
}
