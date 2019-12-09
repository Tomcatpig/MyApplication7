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
import com.example.xpaly.com.xpaly.pojo.HotMovieBean;

import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/8
 * @描述
 */
public class HotMovieAdapter extends RecyclerView.Adapter<HotMovieAdapter.ViewHolder> {
    private List<HotMovieBean.DataBean> hotMovieBeanList;
    private Context context;

    public HotMovieAdapter(List<HotMovieBean.DataBean> hotMovieBeanList, Context context) {
        this.hotMovieBeanList = hotMovieBeanList;
        this.context = context;
    }

    public void setHotMovieBeanList(List<HotMovieBean.DataBean> hotMovieBeanList) {
        this.hotMovieBeanList = hotMovieBeanList;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public HotMovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hottvprogram_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(hotMovieBeanList.get(position).getCover()).into(holder.imageView_cover);
        holder.textView_title.setText(hotMovieBeanList.get(position).getTitle());
        holder.textView_rate.setText("评分"+hotMovieBeanList.get(position).getRate());
    }


    @Override
    public int getItemCount() {
        return hotMovieBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_cover;
        TextView textView_title;
        TextView textView_rate;

        private ViewHolder(View view) {
            super(view);
            imageView_cover = view.findViewById(R.id.hotTvProgram_fragment_recyclerView_cover);
            textView_rate = view.findViewById(R.id.hotTvProgram_fragment_recyclerView_rate);
            textView_title = view.findViewById(R.id.hotTvProgram_fragment_recyclerView_title);
        }
    }
}
