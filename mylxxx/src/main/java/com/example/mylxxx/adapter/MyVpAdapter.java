package com.example.mylxxx.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mylxxx.bean.ResuletBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/1/10
 */
public class MyVpAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<ResuletBean> list = new ArrayList<>();



    public MyVpAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return super.getPageTitle(position);
    }
}
