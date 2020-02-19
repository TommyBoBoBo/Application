package com.example.myzy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author: 王重阳
 * @date: 2020/1/9
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = initLayoutId();
        setContentView(layoutId);

        initView();
        initListener();
        initData();

    }

    public abstract int initLayoutId();
    public  abstract void initView();
    public  abstract void initListener();
    public  abstract void initData();

}
