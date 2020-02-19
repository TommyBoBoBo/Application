package com.example.wangchongyang20200110.fragment;

import android.widget.ImageView;

import com.example.wangchongyang20200110.BaseFragment;
import com.example.wangchongyang20200110.NetUtil;
import com.example.wangchongyang20200110.R;

/**
 * @author: 王重阳
 * @date: 2020/1/10
 */
public class FragmentOne extends BaseFragment {

    String paths="http://blog.zhaoliang5156.cn/api/images/home.png";
    private ImageView img;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initView() {

        img = (ImageView)rootView.findViewById(R.id.img);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        NetUtil.getInstance().imagedoGet(paths,img);



    }


}
