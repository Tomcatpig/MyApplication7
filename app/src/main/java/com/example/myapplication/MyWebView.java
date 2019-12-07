package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_view);
        //获得控件
        WebView webView = findViewById(R.id.web_view);
        //获取焦点
        webView.requestFocus();
        //响应网页的弹窗事件
        webView.setWebChromeClient(new WebChromeClient());
        //获取网页设置对象
        WebSettings webSettings = webView.getSettings();
        //使用javascript
        webSettings.setJavaScriptEnabled(true);
        //设置能播放媒体文件
        webSettings.setMediaPlaybackRequiresUserGesture(true);
        //设置适应Html5 重点是这个设置
        webSettings.setDomStorageEnabled(true);
        //设置缓存
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //http和https混合使用
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        }

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {

                handler.proceed();
            }
        });

        //访问网页
        webView.loadUrl("https://music.163.com/m/");
        //返回之前的页面
        webView.goBack();
        //系统默认会通过手机浏览器打开网页，为了能够直接通过WebView显示网页，则必须设置
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用WebView加载显示url
                view.loadUrl(url);
                //返回true
                return true;
            }
        });
    }
}
