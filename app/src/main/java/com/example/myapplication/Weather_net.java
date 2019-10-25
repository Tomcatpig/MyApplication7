package com.example.myapplication;

import android.util.Log;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.base.BaseActivity;
import com.example.com.example.bean.Weather;
import com.google.gson.Gson;

public class Weather_net extends BaseActivity {
    private TextView weather_city, weather_time, weather_temp, weather_current;
    private Weather weatherInfo;

    @Override
    protected void addContentView() {
        setContentView(R.layout.activity_weather_net);
    }

    @Override
    protected void initContentView() {
        setTitleBarName("天气");
        setTitleBarBackgroundColor(0xffffffff);
        setTitleBarNameColor(0xff000000);


        weather_city = findViewById(R.id.weather_city);
        weather_current = findViewById(R.id.weather_current);
        weather_temp = findViewById(R.id.weather_temp);
        weather_time = findViewById(R.id.weather_time);
        getWeatherInfo();

    }

    public void getWeatherInfo(){
    String url = "http://t.weather.sojson.com/api/weather/city/101010100";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("response",response);
                weatherInfo = new Gson().fromJson(response,Weather.class);
                setWeatherInfo();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.start();
        requestQueue.add(request);

    }


    public void setWeatherInfo() {
        weather_city.setText(weather_city.getText()+weatherInfo.getCityInfo().getCity());
        weather_time.setText(weather_time.getText()+weatherInfo.getTime());
        weather_temp.setText(weather_temp.getText()+weatherInfo.getData().getYesterday().getHigh());
        weather_current.setText(weather_current.getText()+weatherInfo.getData().getYesterday().getType());
    }

    @Override
    protected boolean initTitleBar() {
        return true;
    }

    @Override
    protected boolean backBtnShow() {
        return true;
    }
}
