package com.example.myyklx.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.myyklx.bean.ResultBean;
import com.example.myyklx.fragment.Fragment_One;
import com.example.myyklx.fragment.Fragment_Two;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/2/15
 */
public class MyFragmntVpAdaptere extends FragmentPagerAdapter {
    private int bq = 1;
    private ArrayList<Fragment>fragmentList = new ArrayList<>();


    public MyFragmntVpAdaptere(FragmentManager fm) {
        super(fm);

        for (int i = 0; i < 3 ; i++) {
            Fragment_One fragment_one = new Fragment_One();
            fragmentList.add(fragment_one);
            Fragment_Two fragment_two = new Fragment_Two();
            fragmentList.add(fragment_two);

        }



    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "第"+bq+++"页";
    }
}
