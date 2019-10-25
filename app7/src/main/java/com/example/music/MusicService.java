package com.example.music;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class MusicService {


    private static final File PATH = Environment.getExternalStorageDirectory();
    private List<String> musicList;
    private int songNum;
    private String songName;
    private MediaPlayer player;

    public MusicService() {
        super();
        player = new MediaPlayer();
        musicList = new ArrayList<>();
        try{
            File music_path =new File(PATH,"music");
            if (music_path.listFiles(new MusicFilter()).length>0){

                for (File file :music_path.listFiles(new MusicFilter())){
                    musicList.add(file.getAbsolutePath());
                }
            }

        }
        catch (Exception e){
            Log.i("TAG","获取文件异常！");
        }
    }

    public void setPlayName(String dataSource){
        File file = new File(dataSource);
        String name = file.getName();
        int index  = name.lastIndexOf(".");
        songName = name.substring(0,index);
    }
    public void play() {
        try {
            player.reset(); //重置多媒体
            String dataSource = musicList.get(songNum);//得到当前播放音乐的路径
            setPlayName(dataSource);//截取歌名
            // 指定参数为音频文件
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(dataSource);//为多媒体对象设置播放路径
            player.prepare();//准备播放
            player.start();//开始播放
            //setOnCompletionListener 当当前多媒体对象播放完成时发生的事件
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer arg0) {
                    next();//如果当前歌曲播放完毕,自动播放下一首.
                }
            });

        } catch (Exception e) {
            Log.v("MusicService", e.getMessage());
        }
    }


    //继续播放
    public  void goPlay(){
        int position = getCurrentProgress();
        player.seekTo(position);//设置当前MediaPlayer的播放位置，单位是毫秒。
        try {
            player.prepare();//  同步的方式装载流媒体文件。
        } catch (Exception e) {
            e.printStackTrace();
        }
        player.start();
    }
    // 获取当前进度
    public int getCurrentProgress() {
        if (player != null & player.isPlaying()) {
            return player.getCurrentPosition();
        } else if (player != null & (!player.isPlaying())) {
            return player.getCurrentPosition();
        }
        return 0;
    }

    public void next() {
        songNum = songNum == musicList.size() - 1 ? 0 : songNum + 1;
        play();
    }

    public void last() {
        songNum = songNum == 0 ? musicList.size() - 1 : songNum - 1;
        play();
    }
    // 暂停播放
    public void pause() {
        if (player != null && player.isPlaying()){
            player.pause();
        }
    }

    public void stop() {
        if (player != null && player.isPlaying()) {
            player.stop();
            player.reset();
        }
    }

    class MusicFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            return (name.endsWith(".mp3"));
        }
    }
}
