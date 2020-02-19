package com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.bean.ResultBean;

import java.util.List;

public class MybaseAdapter extends BaseAdapter {
    private Context context;
    private List<ResultBean> list;

    public MybaseAdapter(Context context, List<ResultBean> list) {
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
    public int getItemViewType(int position) {
        int type = list.get(position).getType();
        if (type==1) {
            return 0;
        }else if (type==2) {
            return 1;
        }else {
            return 2;
        }
    }



    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        int type = getItemViewType(position);
            switch (position){
                case 0:
                    if (convertView ==null) {
                        holder = new Holder();
                        convertView = View.inflate(context, R.layout.xlist_item,null);
                        holder.img = convertView.findViewById(R.id.img);
                        holder.tex = convertView.findViewById(R.id.tex);
                        convertView.setTag(holder);
                    }else {
                        holder = (Holder) convertView.getTag();
                    }
                case 1:
                    if (convertView ==null) {
                        holder = new Holder();
                        convertView = View.inflate(context, R.layout.xlist_item2,null);
                        holder.img = convertView.findViewById(R.id.img);
                        holder.tex = convertView.findViewById(R.id.tex);
                        convertView.setTag(holder);
                    }else {
                        holder = (Holder) convertView.getTag();
                    }
                case 2:
                    if (convertView ==null) {
                        holder = new Holder();
                        convertView = View.inflate(context, R.layout.xlist_item3,null);
                        holder.img = convertView.findViewById(R.id.img);
                        holder.tex = convertView.findViewById(R.id.tex);
                        convertView.setTag(holder);
                    }else {
                        holder = (Holder) convertView.getTag();
                    }
                    ResultBean resultBean = list.get(position);
                    String name = resultBean.getName();
                    String imageUrl = resultBean.getImageUrl();
                    holder.tex.setText(name);
            }
        return convertView;
    }class Holder{
        TextView tex;
        ImageView img;

    }

}
