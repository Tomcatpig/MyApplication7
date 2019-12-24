package com.example.xpaly.com.xpaly.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.xpaly.R;
import com.example.xpaly.com.xpaly.pojo.HotVarietyShowBean;

import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/8
 * @描述 综艺列表的适配器
 */
public class HotVarietyShowAdapter extends RecyclerView.Adapter<HotVarietyShowAdapter.ViewHolder> {
    //第一步 定义接口
    public interface OnItemClickListener {
        void onClick(int position);
    }

    private HotVarietyShowAdapter.OnItemClickListener mListener;

    //第二步， 写一个公共的方法
    public void setOnItemClickListener(HotVarietyShowAdapter.OnItemClickListener listener) {
        this.mListener = listener;
    }

    private List<HotVarietyShowBean.DataBean> hotVarietyShowBeanList;
    private Context context;

    public HotVarietyShowAdapter(List<HotVarietyShowBean.DataBean> hotVarietyShowBeanList, Context context) {
        this.hotVarietyShowBeanList = hotVarietyShowBeanList;
        this.context = context;
    }

    public void setHotVarietyShowBeanList(List<HotVarietyShowBean.DataBean> hotVarietyShowBeanList) {
        this.hotVarietyShowBeanList = hotVarietyShowBeanList;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public HotVarietyShowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hottvprogram_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotVarietyShowAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(hotVarietyShowBeanList.get(position).getCover()).into(holder.imageView_cover);
        holder.textView_title.setText(hotVarietyShowBeanList.get(position).getTitle());
        holder.textView_rate.setText("评分"+hotVarietyShowBeanList.get(position).getRate());
        if (mListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return hotVarietyShowBeanList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_cover;
        TextView textView_title;
        TextView textView_rate;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_cover = itemView.findViewById(R.id.hotTvProgram_fragment_recyclerView_cover);
            textView_rate = itemView.findViewById(R.id.hotTvProgram_fragment_recyclerView_rate);
            textView_title = itemView.findViewById(R.id.hotTvProgram_fragment_recyclerView_title);
        }
    }
}
