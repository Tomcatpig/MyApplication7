package com.example.connect.com.example.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.connect.R;

/**
 * @创建者 tw
 * @创建时间 2019/12/23
 * @描述
 */
public class ItemSetting extends ConstraintLayout {
    private Drawable imageSrc;
    private String textLeftStr;
    private String textRightStr;
    private boolean isShowDividingLine;
    private View view;


    //第一步 定义接口
    public interface OnItemClickListener {
        void onClick();
    }

    private ItemSetting.OnItemClickListener mListener;

    public void setmListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public ItemSetting(Context context, AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.item_setting, this);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.settingItem);
        imageSrc = typedArray.getDrawable(R.styleable.settingItem_imageSrc);
        textLeftStr = typedArray.getString(R.styleable.settingItem_textLeft);
        textRightStr = typedArray.getString(R.styleable.settingItem_textRight);
        isShowDividingLine = typedArray.getBoolean(R.styleable.settingItem_isShowDividingLine, true);
        typedArray.recycle();
        initView();
    }

    public void initView() {
        ImageView imageView = view.findViewById(R.id.item_setting_left_icon);
        TextView leftText = view.findViewById(R.id.item_setting_left_text);
        TextView rightText = view.findViewById(R.id.item_setting_right_text);

        View dividing = view.findViewById(R.id.item_setting_dividing);
        dividing.setVisibility(isShowDividingLine?VISIBLE:INVISIBLE);
        imageView.setImageDrawable(imageSrc);
        Log.e("test", textLeftStr + ":" + textRightStr);
        leftText.setText(textLeftStr);
        rightText.setText(textRightStr);
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClick();
                }
            }
        });

    }
}
