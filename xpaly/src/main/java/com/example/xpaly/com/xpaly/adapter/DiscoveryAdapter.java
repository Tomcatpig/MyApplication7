package com.example.xpaly.com.xpaly.adapter;

import android.content.Context;
import android.util.Log;
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
import com.example.xpaly.com.xpaly.pojo.RecommendMovieBean;
import com.example.xpaly.com.xpaly.utils.MStringUtils;
import com.example.xpaly.com.xpaly.utils.RoundedCornersTransformation2;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/9
 * @描述   发现页面recyclerView适配器
 */
public class DiscoveryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //第一步 定义接口
    public interface OnItemClickListener {
        void onClick(int position);
    }

    private OnItemClickListener mListener;

    //第二步， 写一个公共的方法
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    private transient List<RecommendMovieBean.DataBean.ArrayBean> recommendMovieList = new ArrayList<>();
    //private List<String> test = new ArrayList<>();
    private Context context;

    public DiscoveryAdapter(List<RecommendMovieBean.DataBean.ArrayBean> recommendMovieList, Context context) {
        this.recommendMovieList = recommendMovieList;
        this.context = context;
    }

    public void setRecommendMovieList(List<RecommendMovieBean.DataBean.ArrayBean> recommendMovieList) {
        this.recommendMovieList = recommendMovieList;
    }

    /**
     * 获取需要的布局类型
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        int size = recommendMovieList.get(position).getCinecism().getImage_list().size();
        RecommendMovieBean.DataBean.ArrayBean.MediaInfoBean movie = recommendMovieList.get(position).getMedia_info();
        if (position % 5 == 0 || size == 1 || size == 2 || size == 0 || movie == null) {
           // Log.e("type", "getItemViewType: " + 1);
            return 1;
        } else if (size == 3 && position % 3 == 0) {
           // Log.e("type", "getItemViewType: " + 2);
            return 2;
        } else {
            return 3;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case 1:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_discovery_recyclerview_item2, parent, false);
                return new ViewHolderFirst(view);
            case 2:
                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_discovery_recyclerview_item, parent, false);
                return new ViewHolderSecond(view2);
            case 3:
                View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_discovery_recyclerview_item3, parent, false);
                return new ViewHolderThird(view3);
            default:
                return null;
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        //判断holder为哪种类型
        if (holder instanceof ViewHolderFirst) {
            setDataFirst((ViewHolderFirst) holder, position);
        } else if (holder instanceof ViewHolderSecond) {
            setDataSecond((ViewHolderSecond) holder, position);
        } else if (holder instanceof ViewHolderThird) {
            setDataThird((ViewHolderThird) holder, position);
        }
        //给视图设置点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {//判断监听对象是否为空
                    mListener.onClick(position);
                }
            }
        });
    }

    private void setDataThird(ViewHolderThird holder, int position) {
        RequestOptions options = RequestOptions.bitmapTransform(new RoundedCornersTransformation2(5, 0, RoundedCornersTransformation2.CornerType.ALL, RoundedCornersTransformation2.ScaleType.CENTER_CROP));
        Glide.with(context)
                .asBitmap()
                .thumbnail(0.3f)
                .load(recommendMovieList.get(position).getCinecism().getImage_list().get(0))
                .transform(new RoundedCornersTransformation2(5, 0, RoundedCornersTransformation2.CornerType.ALL, RoundedCornersTransformation2.ScaleType.CENTER_CROP))
                .into(holder.imageView1);
        Glide.with(context)
                .asBitmap()
                .thumbnail(0.3f)
                .load(recommendMovieList.get(position).getMedia_info().getVertical_cover_url())
                .apply(options)
                .into(holder.imageView2);
        holder.textView_title.setText(recommendMovieList.get(position).getCinecism().getTitle());
        holder.textView_movieName.setText(recommendMovieList.get(position).getMedia_info().getName());
        holder.textView_movieTime.setText("上映:" + recommendMovieList.get(position).getMedia_info().getRelease_time());
        holder.textView_like.setText( MStringUtils.intChange2Str(recommendMovieList.get(position).getCinecism().getFav_count()));
        holder.textView_watch.setText(MStringUtils.intChange2Str(recommendMovieList.get(position).getCinecism().getShow_count()));
    }


    private void setDataFirst(ViewHolderFirst holderFirst, int position) {

        RequestOptions options = RequestOptions.bitmapTransform(new RoundedCornersTransformation2(5, 0, RoundedCornersTransformation2.CornerType.ALL, RoundedCornersTransformation2.ScaleType.CENTER_CROP));
        try {
            if (recommendMovieList.get(position).getCinecism().getImage_list().size() == 0) {
                Glide.with(context)
                        .load(recommendMovieList.get(position).getCinecism().getCover_url())
                        .apply(options)
                        .into(holderFirst.imageView1);
            } else {
                Glide.with(context)
                        .load(recommendMovieList.get(position).getCinecism().getImage_list().get(0))
                        .apply(options)
                        .into(holderFirst.imageView1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("错误：", recommendMovieList.get(position).getCinecism().getTitle() + position);
        }


        holderFirst.textView_title.setText(recommendMovieList.get(position).getCinecism().getTitle());
        holderFirst.textView_description.setText(recommendMovieList.get(position).getCinecism().getSummary());
        holderFirst.textView_like.setText( MStringUtils.intChange2Str(recommendMovieList.get(position).getCinecism().getFav_count()));
        holderFirst.textView_watch.setText(MStringUtils.intChange2Str(recommendMovieList.get(position).getCinecism().getShow_count()));
    }

    private void setDataSecond(ViewHolderSecond holderSecond, int position) {

        RequestOptions options = RequestOptions.bitmapTransform(new RoundedCornersTransformation2(5, 0, RoundedCornersTransformation2.CornerType.ALL, RoundedCornersTransformation2.ScaleType.CENTER_CROP));
        Glide.with(context)
                .load(recommendMovieList.get(position).getCinecism().getImage_list().get(0))
                .transform(new RoundedCornersTransformation2(5, 0, RoundedCornersTransformation2.CornerType.ALL, RoundedCornersTransformation2.ScaleType.CENTER_CROP))
                .into(holderSecond.imageView1);
        Glide.with(context)
                .load(recommendMovieList.get(position).getCinecism().getImage_list().get(1))
                .apply(options)
                .into(holderSecond.imageView2);
        Glide.with(context)
                .load(recommendMovieList.get(position).getCinecism().getImage_list().get(2))
                .apply(options)
                .into(holderSecond.imageView3);
        holderSecond.textView_title.setText(recommendMovieList.get(position).getCinecism().getTitle());
        holderSecond.textView_description.setText(recommendMovieList.get(position).getCinecism().getSummary());
        holderSecond.textView_like.setText( MStringUtils.intChange2Str(recommendMovieList.get(position).getCinecism().getFav_count()));
        holderSecond.textView_watch.setText(MStringUtils.intChange2Str(recommendMovieList.get(position).getCinecism().getShow_count()));

    }


    @Override
    public int getItemCount() {
        return recommendMovieList.size();
    }

    class ViewHolderSecond extends RecyclerView.ViewHolder {
        ImageView imageView1;
        ImageView imageView2;
        ImageView imageView3;
        TextView textView_title;
        TextView textView_description;
        TextView textView_like;
        TextView textView_watch;

        private ViewHolderSecond(View view) {
            super(view);
            imageView1 = view.findViewById(R.id.fragment_discovery_recyclerview_image1);
            imageView2 = view.findViewById(R.id.fragment_discovery_recyclerview_image2);
            imageView3 = view.findViewById(R.id.fragment_discovery_recyclerview_image3);
            textView_title = view.findViewById(R.id.fragment_discovery_recyclerview_title);
            textView_description = view.findViewById(R.id.fragment_discovery_recyclerview_description);
            textView_like = view.findViewById(R.id.fragment_discovery_recyclerview_like);
            textView_watch = view.findViewById(R.id.fragment_discovery_recyclerview_watch);
        }
    }

    class ViewHolderFirst extends RecyclerView.ViewHolder {
        ImageView imageView1;
        TextView textView_title;
        TextView textView_description;
        TextView textView_like;
        TextView textView_watch;

        private ViewHolderFirst(View view) {
            super(view);
            imageView1 = view.findViewById(R.id.fragment_discovery_recyclerview_image1);
            textView_title = view.findViewById(R.id.fragment_discovery_recyclerview_title);
            textView_description = view.findViewById(R.id.fragment_discovery_recyclerview_description);
            textView_like = view.findViewById(R.id.fragment_discovery_recyclerview_like);
            textView_watch = view.findViewById(R.id.fragment_discovery_recyclerview_watch);
        }
    }

    private class ViewHolderThird extends RecyclerView.ViewHolder {
        ImageView imageView1;
        ImageView imageView2;
        TextView textView_title;
        TextView textView_movieName;
        TextView textView_movieTime;
        TextView textView_like;
        TextView textView_watch;

        private ViewHolderThird(View view) {
            super(view);
            imageView1 = view.findViewById(R.id.fragment_discovery_recyclerview_image1);
            imageView2 = view.findViewById(R.id.fragment_discovery_recyclerview_image2);
            textView_title = view.findViewById(R.id.fragment_discovery_recyclerview_title);
            textView_movieName = view.findViewById(R.id.fragment_discovery_recycsasalerview_movieTitle);
            textView_movieTime = view.findViewById(R.id.fragment_discovery_recyclerview_movieTime);
            textView_like = view.findViewById(R.id.fragment_discovery_recyclerview_like);
            textView_watch = view.findViewById(R.id.fragment_discovery_recyclerview_watch);
        }
    }
}
