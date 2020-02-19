package com.example.mode11;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mode11.adapter.MyAdapter;
import com.example.mode11.bean.MyBean;
import com.example.mode11.util.NetUtil;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private XListView xlistview;
    int page = 1;
    private ArrayList<MyBean.ResultBean> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xlistview = findViewById(R.id.xlistview);
        getServiseJson(page);
        xlistview.setPullRefreshEnable(true);
        xlistview.setPullLoadEnable(true);
        xlistview.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                list.clear();
                page = 1;
                getServiseJson(page);
                xlistview.stopRefresh();
            }

            @Override
            public void onLoadMore() {
                page++;
                getServiseJson(page);
                xlistview.stopLoadMore();
            }
        });
    }
    public void getServiseJson(int page){
        NetUtil instance = NetUtil.getInstance();
        String path = "http://172.17.8.100/movieApi/movie/v1/findHotMovieList?page="+page+"&count=10";
        instance.doGet(path, new NetUtil.CallBack() {
            @Override
            public void onCg(String json) {
                Gson gson = new Gson();
                MyBean myBean = gson.fromJson(json, MyBean.class);
                List<MyBean.ResultBean> result = myBean.getResult();
                list.addAll(result);
                MyAdapter myAdapter = new MyAdapter(MainActivity.this,list);
                xlistview.setAdapter(myAdapter);
            }

            @Override
            public void onSb(String msg) {

            }
        });
    }
}
