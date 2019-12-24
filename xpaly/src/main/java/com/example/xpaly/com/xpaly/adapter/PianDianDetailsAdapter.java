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
import com.bumptech.glide.request.RequestOptions;
import com.example.xpaly.R;
import com.example.xpaly.com.xpaly.pojo.PianDianSingleDetails;
import com.example.xpaly.com.xpaly.utils.MStringUtils;
import com.example.xpaly.com.xpaly.utils.RoundedCornersTransformation2;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/12
 * @描述 片单详情 recyclerView 的适配器
 */
public class PianDianDetailsAdapter extends RecyclerView.Adapter<PianDianDetailsAdapter.ViewHolder> {
    //第一步 定义接口
    public interface OnItemClickListener {
        void onClick(int position);
    }

    private PianDianDetailsAdapter.OnItemClickListener mListener;

    //第二步， 写一个公共的方法
    public void setOnItemClickListener(PianDianDetailsAdapter.OnItemClickListener listener) {
        this.mListener = listener;
    }

    private Context context;
    private List<PianDianSingleDetails.DataBean.ListBean> pianDanDetailsList = new ArrayList<>();

    public PianDianDetailsAdapter(Context context) {
        this.context = context;
    }

    public PianDianDetailsAdapter(Context context, List<PianDianSingleDetails.DataBean.ListBean> pianDanDetailsList) {
        this.context = context;
        this.pianDanDetailsList = pianDanDetailsList;
    }

    public void setPianDanDetailsList(List<PianDianSingleDetails.DataBean.ListBean> pianDanDetailsList) {
        this.pianDanDetailsList = pianDanDetailsList;
    }

    @NonNull
    @Override

    public PianDianDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pian_dian_details_rv_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        RequestOptions options = RequestOptions.bitmapTransform(new RoundedCornersTransformation2(5, 0, RoundedCornersTransformation2.CornerType.ALL, RoundedCornersTransformation2.ScaleType.CENTER_CROP));
        Glide.with(context)
                .asBitmap()
                .thumbnail(0.3f)
                .load(pianDanDetailsList.get(position).getVertical_cover_url())
                .apply(options)
                .into(holder.movieCover);

        holder.movieName.setText(pianDanDetailsList.get(position).getName());
        holder.movieReleaseTime.setText(MStringUtils.dateFormat(1, pianDanDetailsList.get(position).getCreated_on() / 1000000));
        holder.movieAreas.setText(pianDanDetailsList.get(position).getAreas());
        holder.movieActors.setText(pianDanDetailsList.get(position).getActors());
        holder.movieCategories.setText(pianDanDetailsList.get(position).getCategories());
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
        return pianDanDetailsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView movieCover;//电影封面
        TextView movieName;//电影名字
        TextView movieCategories;//电影类型
        TextView movieActors;//电影演员
        TextView movieAreas;//地区
        TextView movieReleaseTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieCover = itemView.findViewById(R.id.activity_pian_dian_details_rv_item_movieCover);
            movieActors = itemView.findViewById(R.id.activity_pian_dian_details_rv_item_movieActors);
            movieAreas = itemView.findViewById(R.id.activity_pian_dian_details_rv_item_movieAreas);
            movieName = itemView.findViewById(R.id.activity_pian_dian_details_rv_item_movieName);
            movieCategories = itemView.findViewById(R.id.activity_pian_dian_details_rv_item_movieCategories);
            movieReleaseTime = itemView.findViewById(R.id.activity_pian_dian_details_rv_item_movieRelease_time);
        }
    }
}
