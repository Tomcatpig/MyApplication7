package com.example.xpaly.com.xpaly.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xpaly.R;
import com.example.xpaly.com.xpaly.pojo.SearchResultBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/14
 * @描述 搜索结果recyclerView 的适配器
 */
public class SearchMovieRvAdapter extends RecyclerView.Adapter<SearchMovieRvAdapter.ViewHolder> {


    //第一步 定义接口
    public interface OnItemClickListener {
        void onClick(int position);
    }

    private DiscoveryAdapter.OnItemClickListener mListener;

    //第二步， 写一个公共的方法

    List<SearchResultBean> resultBeanList = new ArrayList<>();

    public SearchMovieRvAdapter(List<SearchResultBean> resultBeanList) {
        this.resultBeanList = resultBeanList;
    }

    public SearchMovieRvAdapter() {
    }

    public void setResultBeanList(List<SearchResultBean> resultBeanList) {
        this.resultBeanList = resultBeanList;
    }

    public void setmListener(DiscoveryAdapter.OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_search_movie_rv_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.movieName.setText(resultBeanList.get(position).getMovieName());
        holder.movieUrl.setText(resultBeanList.get(position).getMoviewUrl());
        //设置监听跳转
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClick(position);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return resultBeanList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView movieName;//电影名
        TextView movieUrl;//电影连接

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.activity_search_movie_rv_item_movieName);
            movieUrl = itemView.findViewById(R.id.activity_search_movie_rv_item_movieUrl);
        }
    }
}
