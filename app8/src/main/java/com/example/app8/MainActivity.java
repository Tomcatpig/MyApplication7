package com.example.app8;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.music.Music;


public class MainActivity extends AppCompatActivity {
    private static Music music = new Music();
    private TextView music_count;
    private ImageView music_photo;
    private ImageButton music_previous;
    private ImageButton music_next;
    private ImageButton music_play_or_pause;
    private SeekBar music_time;
    private Handler handler;
    private Thread musicProgressThread;
    private static final int UPDATE = 0x01;
    private boolean seekBarChange = true;
    private TextView music_current_time;
    private TextView music_duration_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取读取存储的权限
        if (!hasPermission()) {
            requestPermission();

        }

        //初始化歌曲控件
        musicInit();

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what == UPDATE) {
                    music_time.setProgress(msg.arg1);
                    music_current_time.setText(music.getFormatMusicTime(msg.arg2));
                    music_duration_time.setText(music.getFormatMusicTime(music.getDuration()));
                }
            }
        };


        //创建子线程
        musicProgressThread = new Thread(new musicRun());
        //启动子线程
        musicProgressThread.start();
    }

    //更新线程内部类
    class musicRun implements Runnable {

        @Override
        public void run() {
            while (!musicProgressThread.currentThread().isInterrupted()){

                if (!music.isNull()&&music.isPlaying()&&seekBarChange){
                  int  position = music.getCrruentProgress();//当前秒数
                  int  mMax = music.getDuration();
                  int  seekBar = position*200/mMax;
                  Message message = handler.obtainMessage();
                  message.arg1=seekBar;
                  message.arg2=position;
                  message.what=UPDATE;
                  //Log.i("MUSIC_TIME",position+":"+mMax+":"+seekBar);//测试打印时间
                  handler.sendMessage(message);
                  try {
                      musicProgressThread.sleep(1000);
                  }catch (Exception e){
                      e.printStackTrace();
                      Log.i("MUSIC_THREAD","更新进度异常!");
                  }
                }
            }
          /*
            for (int i=0;i<100;i++){
                try {
                    handler.sendEmptyMessage(0x01);
                    musicProgressUpdate.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("MUSIC_TIME", "更新进度异常");
                }
                Log.i("run!!!!","progress");
            }
           */

        }
    }

    //初始化歌曲控件
    public void musicInit() {

        //初始化控件
        music_previous = findViewById(R.id.music_previous);
        music_next = findViewById(R.id.music_next);
        music_play_or_pause = findViewById(R.id.play_or_pause);
        music_count = findViewById(R.id.song_count);
        music_photo = findViewById(R.id.music_photo);
        music_time = findViewById(R.id.music_time);
        music_current_time  =findViewById(R.id.music_current_time);
        music_duration_time =findViewById(R.id.music_duration_time);


        //给button添加监听
        music_play_or_pause.setOnClickListener(new MusicCtrl());
        music_next.setOnClickListener(new MusicCtrl());
        music_previous.setOnClickListener(new MusicCtrl());
        music_count.setText("当前歌曲: " + music.getSongName(0) + "—" + "当前播放位置：" + music.getSongNum());
        music_time.setOnSeekBarChangeListener(new musicSeekBarCtrl());
    }

  /*
  按钮监听
   */

    class MusicCtrl implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.play_or_pause:
                    if (music.isPlaying()) {
                        //提示暂停
                        Toast.makeText(MainActivity.this, "暂停", Toast.LENGTH_SHORT).show();
                        music.pause();//暂停播放
                        //清除动画
                        clearViewAnimation(music_photo);
                        //设置点击动画
                        setViewAnimation(music_play_or_pause, R.anim.img_btn_click);
                        //设置暂停播放图标
                        setViewImage(music_play_or_pause, R.drawable.zanting);

                    } else {


                        music.goPlay();//继续播放
                        //设置点击动画
                        setViewAnimation(music_play_or_pause, R.anim.img_btn_click);
                        //设置播放图标
                        setViewImage(music_play_or_pause, R.drawable.bofang);
                        //设置播放动画
                        setViewAnimation(music_photo, R.anim.img_xz);

                        //提示播放
                        Toast.makeText(MainActivity.this, "播放", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.music_previous:

                    music.previous();
                    //设置播放图标，判断歌曲是否在播放
                    if (music.isPlaying()) {
                        setViewImage(music_play_or_pause, R.drawable.bofang);
                    }
                    //设置播放信息
                    music_count.setText("当前歌曲: " + music.getSongName(music.getSongNum()) + "—" + "当前播放位置：" + music.getSongNum());
                    //设置点击动画
                    setViewAnimation(music_previous, R.anim.img_btn_click);
                    break;
                case R.id.music_next:

                    music.next();
                    //设置播放图标,判断歌曲是否在播放
                    if (music.isPlaying()) {
                        setViewImage(music_play_or_pause, R.drawable.bofang);
                    }
                    //设置播放信息
                    music_count.setText("当前歌曲: " + music.getSongName(music.getSongNum()) + "—" + "当前播放位置：" + music.getSongNum());
                    //设置点击动画
                    setViewAnimation(music_next, R.anim.img_btn_click);

                    break;


            }
        }
    }

    /*
    seekBar监听类
     */
    class musicSeekBarCtrl implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
         seekBarChange = false;
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            int progress = music_time.getProgress();
            int position = progress*music.getDuration()/200;
            music.seekTo(position);
            seekBarChange = true;
        }
    }

    /*
     **判断是否有读取存储的权限
     */
    private boolean hasPermission() {
        Log.i("TAG", "hasPermission:判断是否有权限");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            return checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

        } else {

            return true;
        }

    }

    /*
    请求权限
     */

    private void requestPermission() {
        Log.i("requestPermission", "请求权限");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {

                Log.i("TAG", "requestPermission:请求权限");
            }
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
    }

    /*
    设置播放动画
    setViewAnimation
     */
    public void setViewAnimation(ImageView imageView, Integer animResource) {
        Animation animation = AnimationUtils.loadAnimation(this, animResource);
        LinearInterpolator lin = new LinearInterpolator();
        animation.setInterpolator(lin);
        imageView.startAnimation(animation);

    }

    //设置图标
    public void setViewImage(ImageButton imageButton, Integer imageResource) {
        imageButton.setBackgroundResource(imageResource);

    }

    /*
    清除播放动画
    clearViewAnimation
     */
    public void clearViewAnimation(ImageView imageView) {
        imageView.clearAnimation();
    }
}
