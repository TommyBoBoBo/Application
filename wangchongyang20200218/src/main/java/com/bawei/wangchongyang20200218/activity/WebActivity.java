package com.bawei.wangchongyang20200218.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;


import com.bawei.wangchongyang20200218.R;
import com.bawei.wangchongyang20200218.base.BaseActivity;

public class WebActivity extends BaseActivity {


    private android.webkit.WebView web;

    @Override
    public int initLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void initView() {

        web = (WebView) findViewById(R.id.web);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        //webview网页
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        web.loadUrl("https://www.baidu.com");

    }
}
