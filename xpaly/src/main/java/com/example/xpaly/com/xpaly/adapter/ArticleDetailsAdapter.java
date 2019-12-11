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
import com.example.xpaly.com.xpaly.pojo.ArticlDetailsBean;
import com.example.xpaly.com.xpaly.utils.RoundedCornersTransformation2;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/11
 * @描述 文章详情页面
 */
public class ArticleDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ArticlDetailsBean> articlDetailsBeanList = new ArrayList<>();
    private Context mContext;

    public void setArticlDetailsBeanList(List<ArticlDetailsBean> articlDetailsBeanList) {
        this.articlDetailsBeanList = articlDetailsBeanList;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == ArticlDetailsBean.TYPE_CENTENCE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_article_details_rv_item2, parent, false);
            return new ViewHolderTextView(view);
        } else if (viewType == ArticlDetailsBean.TYPE_IMAGE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_article_details_rv_item, parent, false);
            return new ViewHolderImageView(view);
        } else {
            return null;
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolderTextView) {
            setDataText((ViewHolderTextView) holder, position);
        } else if (holder instanceof ViewHolderImageView) {
            setDataImage((ViewHolderImageView) holder, position);
        }

    }

    private void setDataImage(ViewHolderImageView holder, int position) {
        RequestOptions options = RequestOptions.bitmapTransform(new RoundedCornersTransformation2(5, 0, RoundedCornersTransformation2.CornerType.ALL, RoundedCornersTransformation2.ScaleType.CENTER_CROP));

        holder.imageView.setVisibility(View.VISIBLE);
        Glide.with(mContext)
                .asBitmap()
                .thumbnail(0.3f)
                .load(articlDetailsBeanList.get(position).getWord())
                .apply(options)
                .into(holder.imageView);
    }

    private void setDataText(ViewHolderTextView holder, int position) {

        holder.textView.setText(articlDetailsBeanList.get(position).getWord());
    }


    @Override
    public int getItemCount() {
        return articlDetailsBeanList.size();
    }

    static class ViewHolderTextView extends RecyclerView.ViewHolder {
        TextView textView;

        private ViewHolderTextView(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.activity_article_details_rv_item_singleLine);
        }
    }

    static class ViewHolderImageView extends RecyclerView.ViewHolder {
        ImageView imageView;

        private ViewHolderImageView(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.activity_article_details_rv_item_image);

        }
    }
}
