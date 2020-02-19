package com.bawei.wangchongyang20200218.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wangchongyang20200218.R;
import com.bawei.wangchongyang20200218.bean.ResultBean;
import com.bawei.wangchongyang20200218.net.NetUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/2/18
 */
public class MyBaseAdapter extends BaseAdapter {
    private List<ResultBean> list = new ArrayList<>();
    private Context context;

    public MyBaseAdapter(List<ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //获取条目类型
    @Override
    public int getItemViewType(int position) {
        int type = list.get(position).getType();
        if (type==1) {
            return 0;
        }else {
            return 1;
        }

    }

    //获取条目类型总数
    @Override
    public int getViewTypeCount() {
        return 2;
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
 //多条目优化
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        int type = getItemViewType(position);
        if (convertView ==null) {
            switch (type){
                case 0:
                    convertView = View.inflate(context, R.layout.xlist_iten_one,null);
                    holder = new Holder();
                    holder.img = convertView.findViewById(R.id.img);
                    holder.tex = convertView.findViewById(R.id.tex);
                    convertView.setTag(holder);
                    break;
                case 1:
                    convertView = View.inflate(context, R.layout.xlist_iten_two,null);
                    holder = new Holder();
                    holder.img = convertView.findViewById(R.id.img);
                    holder.tex = convertView.findViewById(R.id.tex);
                    convertView.setTag(holder);
                    break;
            }
        }else {
                    holder = (Holder) convertView.getTag();

        }
        ResultBean listDataBean = list.get(position);
        String content = listDataBean.getContent();
        String avatar = listDataBean.getAvatar();
        holder.tex.setText(content);
        NetUtil.getInstance().imagedoGet(avatar,holder.img);
        return convertView;
    }class Holder{
        TextView tex;
        ImageView img;
    }
}
