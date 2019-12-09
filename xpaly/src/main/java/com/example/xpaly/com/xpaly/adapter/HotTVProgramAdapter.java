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
import com.example.xpaly.com.xpaly.pojo.HotTVProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/7
 * @描述
 */
public class HotTVProgramAdapter extends RecyclerView.Adapter<HotTVProgramAdapter.ViewHolder> {
    private List<HotTVProgram.DataBean> hotTVProgramList = new ArrayList<>();
    private Context context;


    public HotTVProgramAdapter(Context context, List<HotTVProgram.DataBean> hotTVProgramList) {
        this.context = context;
        this.hotTVProgramList = hotTVProgramList;
    }

    public void setHotTVProgramList(List<HotTVProgram.DataBean> hotTVProgramList) {
        this.hotTVProgramList = hotTVProgramList;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hottvprogram_recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(hotTVProgramList.get(position).getCover()).into(holder.imageView_cover);
        holder.textView_title.setText(hotTVProgramList.get(position).getTitle());
        holder.textView_rate.setText("评分"+hotTVProgramList.get(position).getRate());

    }

    @Override
    public int getItemCount() {
        return hotTVProgramList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_cover;
        TextView textView_title;
        TextView textView_rate;

        public ViewHolder(View view) {
            super(view);
            imageView_cover = view.findViewById(R.id.hotTvProgram_fragment_recyclerView_cover);
            textView_rate = view.findViewById(R.id.hotTvProgram_fragment_recyclerView_rate);
            textView_title = view.findViewById(R.id.hotTvProgram_fragment_recyclerView_title);
        }
    }
}
