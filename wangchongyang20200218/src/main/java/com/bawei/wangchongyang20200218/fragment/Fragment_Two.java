package com.bawei.wangchongyang20200218.fragment;

import android.webkit.WebSettings;
import android.webkit.WebView;

import com.bawei.wangchongyang20200218.R;
import com.bawei.wangchongyang20200218.base.BaseFragment;

/**
 * @author: 王重阳
 * @date: 2020/2/18
 */
public class Fragment_Two extends BaseFragment {
    private android.webkit.WebView web;

    @Override
    public int initLayoutId() {
        return R.layout.fragment_two;
    }

    @Override
    public void initView() {

        web = (WebView)rootView. findViewById(R.id.web);
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
