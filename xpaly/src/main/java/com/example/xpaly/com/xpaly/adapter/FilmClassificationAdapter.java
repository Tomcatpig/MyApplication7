package com.example.xpaly.com.xpaly.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xpaly.R;


import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;

/**
 * @创建者 tw
 * @创建时间 2019/12/8
 * @描述 电影分类 recyclerView 适配器
 */
public class FilmClassificationAdapter extends RecyclerView.Adapter<FilmClassificationAdapter.ViewHolder> {
    private String[] movieForm = new String[]{"全部形式", "电影", "电视", "剧综艺", "动漫", "纪录片", "短片"};
    private String[] movieType = new String[]{"全部类型", "剧情", "喜剧", "动作", "爱情", "科幻", "动画", "悬疑", "惊悚",
            "恐怖", "犯罪", "同性", "音乐", "歌舞", "传记", "历史", "战争", "西部", "奇幻", "冒险", "灾难", "武侠", "情色"};
    private String[] movieArea = new String[]{"全部地区", "中国大陆", "美国", "中国香港", "中国台湾", "日本", "韩国", "英国", "法国",
            "德国", "意大利", "西班牙", "印度", "泰国", "俄罗斯", "伊朗", "加拿大", "澳大利", "亚爱尔兰", "瑞典", "巴西", "丹麦"};
    private String[] movieTime = new String[]{"全部年代", "2019", "2018", "2010年代", "2000年代", "90年代", "80年代", "70年代", " 60年代", " 更早"};
    private String[] datas;
    private List<String> label;
    private int type = 0;//分类的类型
    private int tag = 0;//判断选择的是哪一个标签

    public FilmClassificationAdapter(int dataType) {
        this.type=dataType;
        if (type == 0) {
            datas = movieForm;
        } else if (type == 1) {
            datas = movieType;
        } else if (type == 2) {
            datas = movieArea;
        } else if (type == 3) {
            datas = movieTime;
        }

    }

    public void setTag(int tag) {
        tag = tag;
    }

    public int getTag() {
        return tag;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_classification_recyclerview_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (tag == position) {
            holder.fancyButton.setBackgroundColor(Color.parseColor("#03A9F4"));
            holder.fancyButton.setTextColor(Color.parseColor("#FFFFFF"));
        }
        holder.fancyButton.setText(datas[position]);
    }

    @Override
    public int getItemCount() {
        return datas.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        FancyButton fancyButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fancyButton = itemView.findViewById(R.id.film_classification_recyclerView_button);

        }
    }
}
