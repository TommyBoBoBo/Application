package com.example.myyklx.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myyklx.R;
import com.example.myyklx.base.BaseActivity;

public class Main2Activity extends BaseActivity {


    private android.webkit.WebView web;

    @Override
    protected int initLayoutid() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {

        web = (WebView) findViewById(R.id.web);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        web.loadUrl("http://www.baidu.com");


        web.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url);
                return true;
            }
        });


    }
}
