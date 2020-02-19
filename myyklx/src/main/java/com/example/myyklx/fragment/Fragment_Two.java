package com.example.myyklx.fragment;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myyklx.R;
import com.example.myyklx.base.BaseFragment;

/**
 * @author: 王重阳
 * @date: 2020/2/15
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
