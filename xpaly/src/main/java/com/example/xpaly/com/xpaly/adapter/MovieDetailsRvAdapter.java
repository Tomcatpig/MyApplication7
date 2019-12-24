package com.example.xpaly.com.xpaly.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xpaly.R;
import com.example.xpaly.com.xpaly.pojo.SearchResultBean;

import java.util.ArrayList;
import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;

/**
 * @创建者 tw
 * @创建时间 2019/12/15
 * @描述 电影详情 recyclerView 适配器
 */
public class MovieDetailsRvAdapter extends RecyclerView.Adapter<MovieDetailsRvAdapter.ViewHolder> {

    //第一步 定义接口
    public interface OnItemClickListener {
        void onClick(int position);
    }

    private MovieDetailsRvAdapter.OnItemClickListener mListener;

    //第二步， 写一个公共的方法
    public void setOnItemClickListener(MovieDetailsRvAdapter.OnItemClickListener listener) {
        this.mListener = listener;
    }
    List<SearchResultBean> resultBeanList = new ArrayList<>();

    public void setResultBeanList(List<SearchResultBean> resultBeanList) {
        this.resultBeanList = resultBeanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_movie_details_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.button.setText(resultBeanList.get(position).getMovieName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener!=null){
                    mListener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView button;//剧集label

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.activity_movie_details_rv_item_label);
        }
    }
}
