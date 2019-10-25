package com.example.app6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.example.service.WeatherService;
import com.example.info.WeatherInfo;

import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView  city,wind,temp,pm,weather;

    private List<WeatherInfo> weatherInfoList=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city = findViewById(R.id.city);
        wind = findViewById(R.id.wind);
        temp = findViewById(R.id.temp);
        pm = findViewById(R.id.pm);
        weather = findViewById(R.id.weather);

        try {

            weatherInfoList = WeatherService.getWeatherInfos(MainActivity.class
                    .getClassLoader().getResourceAsStream("weather.xml"));

        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(this, "解析失败", Toast.LENGTH_LONG).show();
        }


    }

    private void updateWeather(WeatherInfo weatherInfo){
      city.setText(weatherInfo.getName());
      wind.setText(weatherInfo.getWind());
      weather.setText(weatherInfo.getWeather());
      pm.setText(weatherInfo.getPm());
      temp.setText(weatherInfo.getTemp());

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.city1:
                updateWeather(weatherInfoList.get(0));
                break;
            case R.id.city2:
                updateWeather(weatherInfoList.get(1));
                break;
            case R.id.city3:
                updateWeather(weatherInfoList.get(2));
                break;
                default:
                    break;
        }

    }
}
