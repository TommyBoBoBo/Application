package com.example.wangchongyang0112.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wangchongyang0112.R;
import com.example.wangchongyang0112.bean.ResuletBean;
import com.example.wangchongyang0112.net.NetUtil;

import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/1/12
 */
public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<ResuletBean> list;

    public MyBaseAdapter(Context context, List<ResuletBean> list) {
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
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        int type = list.get(position).getType();
        if (type==1) {
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case 0:
                    convertView = View.inflate(context, R.layout.xlist_item, null);
                    holder = new Holder();
                    holder.img = convertView.findViewById(R.id.img1);
                    holder.tex = convertView.findViewById(R.id.tex1);
                    convertView.setTag(holder);
                    break;
                case 1:
                    convertView = View.inflate(context, R.layout.xlist_item2, null);
                    holder = new Holder();
                    holder.img = convertView.findViewById(R.id.img2);
                    holder.tex = convertView.findViewById(R.id.tex2);
                    convertView.setTag(holder);
                    break;
            }
        } else {
            holder = (Holder) convertView.getTag();
        }
        ResuletBean resuletBean = list.get(position);
        String title = resuletBean.getTitle();
        String imgsrc = resuletBean.getImgsrc();

        holder.tex.setText(title);
        NetUtil.getInstance().imagedoGet(imgsrc, holder.img);
    return convertView;
    }
    class Holder{
        ImageView img;
        TextView tex;
    }
}
