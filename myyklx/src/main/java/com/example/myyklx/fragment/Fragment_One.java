package com.example.myyklx.fragment;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.myyklx.R;
import com.example.myyklx.activity.Main2Activity;
import com.example.myyklx.adapter.MyBaseAdapter;
import com.example.myyklx.app.App;
import com.example.myyklx.base.BaseFragment;
import com.example.myyklx.bean.DataBean;
import com.example.myyklx.bean.ResultBean;
import com.example.myyklx.net.NetUtil;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/2/15
 */
public class Fragment_One extends BaseFragment {
    private com.qy.xlistview.XListView xlists;
    private int page =1;
    private ArrayList<ResultBean>list = new ArrayList<>();

    @Override
    public int initLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    public void initView() {

        xlists = (XListView)rootView. findViewById(R.id.xlists);
        xlists.setPullLoadEnable(true);
        xlists.setPullRefreshEnable(true);

    }

    @Override
    public void initListener() {

        xlists.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                page=1;
                list.clear();
                getData(page);
                xlists.stopRefresh();
                Toast.makeText(getContext(), "刷新", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLoadMore() {
                page++;
                getData(page);
                xlists.stopLoadMore();
                Toast.makeText(getContext(), "加载", Toast.LENGTH_SHORT).show();

            }

        });
        xlists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getContext(), Main2Activity.class);
                startActivity(intent);
            }
        });
        getData(page);


    }

 private MyBaseAdapter myBaseAdapter;


    protected void getData(int page) {
        String path ="http://blog.zhaoliang5156.cn/baweiapi/news?page="+page+"&pageSize=10";
        NetUtil.getInstance().doGet(path, new NetUtil.CallBack() {
            @Override
            public void oncheng(String json) {
                Gson gson = new Gson();
                DataBean dataBean = gson.fromJson(json, DataBean.class);
                List<ResultBean> result = dataBean.getResult();
                Log.d("xxx", "oncheng: "+result);
                //分页
               list.addAll(result);
               myBaseAdapter = new MyBaseAdapter(list,getContext());
               xlists.setAdapter(myBaseAdapter);

            }

            @Override
            public void onbai(String msg) {

            }
        });

    }
    @Override
    public void initData() {



    }
}
