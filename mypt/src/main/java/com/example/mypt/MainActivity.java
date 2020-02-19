package com.example.mypt;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mypt.base.BaseActivity;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class MainActivity extends BaseActivity {
    private PullToRefreshListView ptl;



    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
    ptl = findViewById(R.id.ptl);
    }

    @Override
    public void initListener() {
    ptl.setPullToRefreshOverScrollEnabled(true);

    ptl.setMode(PullToRefreshBase.Mode.BOTH);




    }

    @Override
    public void initData() {

    }
}
