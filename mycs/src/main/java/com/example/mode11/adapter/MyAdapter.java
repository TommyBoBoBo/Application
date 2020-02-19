package com.example.mode11.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mode11.R;
import com.example.mode11.bean.MyBean;
import com.example.mode11.util.NetUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: My Application
 * @Package: com.example.mode11.adapter
 * @ClassName: MyAdapter
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/1/3 14:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/3 14:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<MyBean.ResultBean> list ;

    public MyAdapter(Context context, List<MyBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        MyBean.ResultBean resultBean = list.get(position);
        int type = resultBean.getType();
        if (type==1){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        int type = getItemViewType(i);
        if (view==null){
            switch (type){
                case 0:
                    view = View.inflate(context, R.layout.zi_xlist1,null);
                    holder = new ViewHolder();
                    holder.zi_image = view.findViewById(R.id.zi_image1);
                    holder.zi_text = view.findViewById(R.id.zi_text1);
                    view.setTag(holder);
                    break;
                case 1:
                    view = View.inflate(context, R.layout.zi_xlist2,null);
                    holder = new ViewHolder();
                    holder.zi_image = view.findViewById(R.id.zi_image2);
                    holder.zi_text = view.findViewById(R.id.zi_text2);
                    view.setTag(holder);
                    break;
            }
        }else {
            holder = (ViewHolder) view.getTag();
        }
        MyBean.ResultBean resultBean = list.get(i);
        String name = resultBean.getName();
        holder.zi_text.setText(name);
        String imageUrl = resultBean.getImageUrl();
        NetUtil.getInstance().TuPian(imageUrl,holder.zi_image);
        return view;
    }
    class ViewHolder{
        ImageView zi_image;
        TextView zi_text;
    }
}
