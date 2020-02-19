package com.example.my210zyy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my210zyy.net.NetUtil;
import com.example.my210zyy.R;
import com.example.my210zyy.bean.ResultBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/2/13
 */
public class MyBaseAdapter extends BaseAdapter {
    Context context;
    private List<ResultBean> list = new ArrayList<>();

    public MyBaseAdapter(Context context, List<ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Holder holder;
        if (view == null) {
            view = View.inflate(context, R.layout.list_item,null);
            holder = new Holder();
            holder.img = view.findViewById(R.id.img);
            holder.tex = view.findViewById(R.id.tex);
            view.setTag(holder);
        }else {
            holder = (Holder) view.getTag();
            ResultBean resultBean = list.get(position);
            String title = resultBean.getTitle();
            holder.tex.setText(title);
            String imgsrc = resultBean.getImgsrc();
            NetUtil.getInstance().TuPian(imgsrc,holder.img);

        }

        return view;


    }class Holder{
        TextView tex;
        ImageView img;

    }


}
