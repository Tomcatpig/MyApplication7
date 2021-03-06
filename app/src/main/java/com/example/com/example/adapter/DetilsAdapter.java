package com.example.com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.com.example.bean.Detils;
import com.example.com.example.bean.UUU;
import com.example.myapplication.R;

import java.util.List;

public class DetilsAdapter extends BaseAdapter {
    private List<UUU.SongListBean> resultBeanList;
    private Context context;
    private LayoutInflater layoutInflater;

    public DetilsAdapter(List<UUU.SongListBean> resultBeanList, Context context) {
        this.resultBeanList = resultBeanList;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return resultBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return resultBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            holder = new ViewHolder();
            convertView= layoutInflater.inflate(R.layout.detils_list_item,null);
            holder.show_pic = convertView.findViewById(R.id.show_pic);
            holder.show_title = convertView.findViewById(R.id.show_title);
            holder.show_description = convertView.findViewById(R.id.show_description);
            holder.show_teacher = convertView.findViewById(R.id.show_teacher);
            convertView.setTag(holder);
        }else {

            holder = (ViewHolder) convertView.getTag();
        }
        UUU.SongListBean resultBean = resultBeanList.get(position);
        holder.show_title.setText(resultBean.getTitle());
        holder.show_description.setText(resultBean.getAuthor());
        holder.show_teacher.setText(resultBean.getArtist_name());
        Glide.with(context).load(resultBean.getPic_small()).into(holder.show_pic);
        return convertView;
    }

    class ViewHolder{
        ImageView show_pic;
        TextView show_title,show_description,show_teacher;

    }
}
