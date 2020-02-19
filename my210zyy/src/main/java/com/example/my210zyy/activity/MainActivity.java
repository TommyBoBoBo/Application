package com.example.my210zyy.activity;


import android.util.Log;
import android.widget.ListView;

import com.example.my210zyy.net.NetUtil;
import com.example.my210zyy.R;
import com.example.my210zyy.adapter.MyBaseAdapter;
import com.example.my210zyy.base.BaseActivity;
import com.example.my210zyy.bean.NetBean;
import com.example.my210zyy.bean.ResultBean;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity {
    private MyBaseAdapter myBaseAdapter;
    private ListView lists;



    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        lists = findViewById(R.id.lists);

    }

    @Override
    protected void initData() {
        NetUtil instance = NetUtil.getInstance();
        String path="http://blog.zhaoliang5156.cn/baweiapi/news?page=1&pageSize=10";
        instance.doGet(path, new NetUtil.CallBack() {
            @Override
            public void onCg(String json) {
                Log.d("xxx", "onCg: "+json);
                Gson gson = new Gson();
                NetBean netBean = gson.fromJson(json, NetBean.class);
                List<ResultBean> result = netBean.getResult();
                myBaseAdapter = new MyBaseAdapter(getApplicationContext(),result);
                lists.setAdapter(myBaseAdapter);



            }

            @Override
            public void onSb(String msg) {

            }
        });




    }

    @Override
    protected void initListener() {



    }
}
