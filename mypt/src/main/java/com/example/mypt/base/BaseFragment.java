package com.example.mypt.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author: 王重阳
 * @date: 2020/1/9
 */
public abstract class BaseFragment extends Fragment {
    public View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = initLayoutId();
        rootView = View.inflate(getContext(),layoutId,null);
        return rootView;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initListener();
        initData();

    }

    public abstract int initLayoutId();
    public  abstract void initView();
    public  abstract void initListener();
    public  abstract void initData();

}
