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
import com.example.xpaly.com.xpaly.pojo.HotAnimeBean;
import com.example.xpaly.com.xpaly.pojo.HotMovieBean;

import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/8
 * @描述
 */
public class HotAnimeAdapter extends RecyclerView.Adapter<HotAnimeAdapter.ViewHolder> {
    private List<HotAnimeBean.DataBean> hotAnimeBeanList;
    private Context context;

    public HotAnimeAdapter(List<HotAnimeBean.DataBean> hotAnimeBeanList, Context context) {
        this.hotAnimeBeanList = hotAnimeBeanList;
        this.context = context;
    }

    public void setHotAnimeBeanList(List<HotAnimeBean.DataBean> hotAnimeBeanList) {
        this.hotAnimeBeanList = hotAnimeBeanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hottvprogram_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(hotAnimeBeanList.get(position).getCover()).into(holder.imageView_cover);
        holder.textView_title.setText(hotAnimeBeanList.get(position).getTitle());
        holder.textView_rate.setText("评分"+hotAnimeBeanList.get(position).getRate());
    }

    @Override
    public int getItemCount() {
        return hotAnimeBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
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
