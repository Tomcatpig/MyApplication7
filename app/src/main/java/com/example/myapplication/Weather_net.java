package com.example.myapplication;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.base.BaseActivity;
import com.example.com.example.bean.Weather;
import com.google.gson.Gson;

import java.util.List;

public class Weather_net extends BaseActivity {
    private TextView weather_current_temp, weather_current_weather, weather_high_low, weather_week;
    private Weather weatherInfo;
    private ListView weather_list_forecast;
    private List<Weather.DataBean.ForecastBean> forecastBean;

    @Override
    protected void addContentView() {
        setContentView(R.layout.activity_weather_net);
    }

    @Override
    protected void initContentView() {
        setTitleBarName("天气");
        setTitleBarBackgroundColor(0xffffffff);
        setTitleBarNameColor(0xff000000);

        weather_current_temp = findViewById(R.id.weather_current_temp);
        weather_current_weather = findViewById(R.id.weather_current_weather);
        weather_high_low = findViewById(R.id.weather_high_low);
        weather_week = findViewById(R.id.weather_week);
        weather_list_forecast = findViewById(R.id.weather_list_forecast);


        getWeatherInfo();

    }

    public void getWeatherInfo() {
        String url = "http://t.weather.sojson.com/api/weather/city/101250801";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("response", response);
                weatherInfo = new Gson().fromJson(response, Weather.class);
                forecastBean = weatherInfo.getData().getForecast();
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
        Weather.DataBean.ForecastBean forecastBean = weatherInfo.getData().getForecast().get(0);
        weather_current_weather.setText(forecastBean.getType());
        weather_high_low.setText(forecastBean.getLow() + "/" + forecastBean.getHigh());
        weather_week.setText(forecastBean.getWeek());
        weather_list_forecast.setAdapter(new WeatherListAdapter());

    }

    @Override
    protected boolean initTitleBar() {
        return true;
    }

    @Override
    protected boolean backBtnShow() {
        return true;
    }

    class WeatherListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return forecastBean.size();
        }

        @Override
        public Object getItem(int position) {
            return forecastBean.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(Weather_net.this, R.layout.weather_list_item, null);
            TextView weather_list_data = view.findViewById(R.id.weather_list_data);
            TextView weather_list_tempHigh = view.findViewById(R.id.weather_list_tempHigh);
            TextView weather_list_tempLow = view.findViewById(R.id.weather_list_tempLow);
            TextView weather_list_weatherNow = view.findViewById(R.id.weather_list_weatherNow);
            Weather.DataBean.ForecastBean forecast = forecastBean.get(position);
            weather_list_data.setText(weather_list_data.getText()+forecast.getDate());
            weather_list_tempHigh.setText(forecast.getHigh());
            weather_list_tempLow.setText(forecast.getLow());
            weather_list_weatherNow.setText(weather_list_weatherNow.getText()+forecast.getType());

            return view;
        }
    }
}
