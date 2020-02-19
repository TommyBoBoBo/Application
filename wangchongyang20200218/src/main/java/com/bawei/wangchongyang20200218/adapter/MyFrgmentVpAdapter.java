package com.bawei.wangchongyang20200218.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bawei.wangchongyang20200218.fragment.Fragment_One;
import com.bawei.wangchongyang20200218.fragment.Fragment_Two;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/2/18
 */
public class MyFrgmentVpAdapter  extends FragmentPagerAdapter {
    private int y = 1;
    private ArrayList<Fragment> fragmentlist = new ArrayList<>();
    

    public MyFrgmentVpAdapter(FragmentManager fm) {
        super(fm);

        for (int i = 0; i <1 ; i++) {
            Fragment_One fragment_one = new Fragment_One();
            fragmentlist.add(fragment_one);
        }
        for (int i = 0; i <4 ; i++) {
            Fragment_Two fragment_two = new Fragment_Two();
            fragmentlist.add(fragment_two);
        }
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentlist.get(i);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "第"+y+++"页";
    }
}
