package com.example.xpaly.com.xpaly.adapter;

import android.content.Context;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.xpaly.R;
import com.example.xpaly.com.xpaly.pojo.PianDan;
import com.example.xpaly.com.xpaly.pojo.User;
import com.example.xpaly.com.xpaly.utils.MStringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/6
 * @描述
 */
public class PianDanAdapter extends RecyclerView.Adapter<PianDanAdapter.ViewHolder> {

    private List<PianDan.DataBean.ListBean> pianDanList;
    private Context mContext = null;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater.from(Context).inflate(layoutId,null)不使用margin属性失效
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.paindan_recycleview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext).load(pianDanList.get(position).getCover_url1()).into(holder.imageView);
        holder.textView_title.setText(pianDanList.get(position).getName());
        holder.textView_description.setText(pianDanList.get(position).getDescription().trim());
        holder.textView_time.setText(MStringUtils.dateFormat(1, pianDanList.get(position).getCreated_on()/1000000));
        //

    }

    @Override
    public int getItemCount() {
        return pianDanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView_title;
        TextView textView_description;
        TextView textView_time;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.piandan_recyclerViewItem_image);
            textView_title = view.findViewById(R.id.piandan_recyclerViewItem_title);
            textView_description = view.findViewById(R.id.piandan_recyclerViewItem_description);
            textView_time = view.findViewById(R.id.piandan_recyclerViewItem_updateTime);
        }
    }

    public PianDanAdapter(List<PianDan.DataBean.ListBean> pianDanList, Context context) {
        this.pianDanList = pianDanList;
        this.mContext = context;
    }

    public void setPianDanList(List<PianDan.DataBean.ListBean> pianDanList) {
        this.pianDanList = pianDanList;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }
}