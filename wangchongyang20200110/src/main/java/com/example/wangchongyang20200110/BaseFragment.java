package com.example.wangchongyang20200110;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * @author: 王重阳
 * @date: 2020/1/10
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

    protected abstract int initLayoutId();
    protected abstract void initView();
    protected abstract void initListener();
    protected abstract void initData();



}
