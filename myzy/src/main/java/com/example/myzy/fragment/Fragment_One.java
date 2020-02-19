package com.example.myzy.fragment;

import android.widget.TextView;

import com.example.myzy.R;
import com.example.myzy.base.BaseFragment;

/**
 * @author: 王重阳
 * @date: 2020/1/15
 */
public class Fragment_One extends BaseFragment {
    private com.handmark.pulltorefresh.library.PullToRefreshListView lists;


    @Override
    public int initLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    public void initView() {

       lists = rootView.findViewById(R.id.lists);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }
}
