package com.example.wangchongyang20200110;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.example.wangchongyang20200110.bean.DataBean;
import com.example.wangchongyang20200110.fragment.FragmentOne;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/1/10
 */
public class MyVpAdapter extends FragmentPagerAdapter {
    private List<Fragment>fragmentList = new ArrayList<>();
    private  List<DataBean>list = new ArrayList<>();
    public MyVpAdapter(@NonNull FragmentManager fm, List<DataBean>list) {
        super(fm);
        this.list.addAll(list);
        for (int i = 0; i <5 ; i++) {
            FragmentOne fragmentOne = new FragmentOne();
            fragmentList.add(fragmentOne);
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = list.get(position).getTitle();
        return title;
    }
}
