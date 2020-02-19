package com.example.wangchongyang20200109.adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wangchongyang20200109.NetUtil;
import com.example.wangchongyang20200109.R;
import com.example.wangchongyang20200109.bean.ResultBean;

import java.util.List;

/**
 * @author: 王重阳
 * @date: 2020/1/9
 */
public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<ResultBean>list;

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
        return 0;
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
        Holder holder;
        int type = getItemViewType(position);
        switch (type){
            case 0:
            if (convertView==null) {
                convertView = View.inflate(context, R.layout.list_item,null);
                holder = new Holder();
                holder.img = convertView.findViewById(R.id.img);
                holder.tex = convertView.findViewById(R.id.tex);
                convertView.setTag(holder);

            }else {
                holder = (Holder) convertView.getTag();
            }
            case 1:
                if (convertView==null) {
                    convertView = View.inflate(context, R.layout.list_item2,null);
                    holder = new Holder();
                    holder.img = convertView.findViewById(R.id.img);
                    holder.tex = convertView.findViewById(R.id.tex);
                    convertView.setTag(holder);

                }else {
                    holder = (Holder) convertView.getTag();
                }

                ResultBean resultBean = list.get(position);
                String title = resultBean.getTitle();
                String imgsrc = resultBean.getImgsrc();
                holder.tex.setText(title);
                NetUtil.getInstance().imagedoGet(imgsrc,holder.img);

        }
        return convertView;
    }class Holder{
            TextView tex;
            ImageView img;
    }
}
