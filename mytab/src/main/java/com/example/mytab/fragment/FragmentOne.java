package com.example.mytab.fragment;



import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.mytab.R;
import com.example.mytab.base.BaseFragment;


/**
 * @author: 王重阳
 * @date: 2020/1/8
 */
public class FragmentOne<ViewPager> extends BaseFragment {

    private TabLayout tabTwo;
    private ViewPager vpTwo;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
