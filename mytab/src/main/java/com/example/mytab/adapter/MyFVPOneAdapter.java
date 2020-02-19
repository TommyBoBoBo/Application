package com.example.mytab.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.PopupMenu;

import com.example.mytab.bean.ResultBean;
import com.example.mytab.bean.SecondCategoryVoBean;
import com.example.mytab.fragment.FragmentOne;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/1/8
 */
public class MyFVPOneAdapter extends FragmentPagerAdapter {
    private List<Fragment>fragmentList = new ArrayList<>();
    private List<ResultBean>list = new ArrayList<>();

    public MyFVPOneAdapter(@NonNull FragmentManager fm, List<ResultBean>list) {
        super(fm);
      this.list.addAll(list);
        for (int i = 0; i < list.size() ; i++) {

            FragmentOne fragmentOne = new FragmentOne();
            /*ResultBean resultBean = list.get(i);
            List<SecondCategoryVoBean> secondCategoryVo = resultBean.getSecondCategoryVo();
            */
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
        String name = list.get(position).getName();
        return name;
    }
}
