package com.example.wangchongyang20200109;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.wangchongyang20200109.adpter.MyBaseAdapter;
import com.example.wangchongyang20200109.bean.DataBean;
import com.example.wangchongyang20200109.bean.ResultBean;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyBaseAdapter myBaseAdapter;
    private ListView lists;
    private ArrayList<ResultBean>list = new ArrayList<>();
    private XBanner xbanner;
    String paths="http://img.zcool.cn/community/01730258214e02a84a0d304f58f3a2.jpg@1280w_1l_2o_100sh.jpg,http://img.zcool.cn/community/014fed57f4701ea84a0d304f1b79fb.jpg@1280w_1l_2o_100sh.jpg,http://img.zcool.cn/community/01d56b5542d8bc0000019ae98da289.jpg@1280w_1l_2o_100sh.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();
        lists = findViewById(R.id.lists);
        xbanner = findViewById(R.id.xbanner);

    }

    String path="http://blog.zhaoliang5156.cn/baweiapi/news?page=1&pageSize=10";
    private void getData() {
    NetUtil.getInstance().doGet(path, new NetUtil.CallBack() {
        @Override
        public void oncheng(String json) {
            Gson gson = new Gson();
            DataBean dataBean = gson.fromJson(json, DataBean.class);
            List<ResultBean> result = dataBean.getResult();
            Log.d("xxx", "oncheng: "+result);
            myBaseAdapter = new MyBaseAdapter(MainActivity.this,result);
            lists.setAdapter(myBaseAdapter);
        }

        @Override
        public void onbai(String msg) {

        }
    });

    }


}
