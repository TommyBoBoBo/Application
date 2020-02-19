package com.example.myzy.adapter;

import android.content.Context;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder.ImageInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myzy.R;
import com.example.myzy.bean.DataBean;
import com.example.myzy.bean.ResuletBean;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/1/15
 */
public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    List<ResuletBean> resulet;
    private List<DataBean>list = new ArrayList<>();

    public MyBaseAdapter(Context context, List<ResuletBean> resulet, List<DataBean> list) {
        this.context = context;
        this.resulet = resulet;
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
    public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = null;
        if (convertView==null) {
            convertView = View.inflate(context, R.layout.list_item,null);
            holder  = new Holder();
            holder.xb = convertView.findViewById(R.id.xb);
            holder.tex = convertView.findViewById(R.id.tex);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        //获取数据
        ResuletBean resuletBean = resulet.get(position);
        String desc = resuletBean.getDesc();
        holder.tex.setText(desc);
        List<String> images =resuletBean.getImages();
        //判空
        if (images!=null) {
            for (int i = 0; i < images.size() ; i++) {
                String s = images.get(i);
             new DataBean(s);

            }

        }



        return null;
    }class  Holder{
        private XBanner xb;
        private TextView tex;

    }
}
