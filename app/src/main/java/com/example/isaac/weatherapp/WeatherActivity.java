package com.example.isaac.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isaac.weatherapp.info.InfoSupport;
import com.example.isaac.weatherapp.webapi.HttpClient;

public class WeatherActivity extends AppCompatActivity {

    private String location;

    private TextView cityLabel;
    private TextView tempLabel;
    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        location = this.getIntent().getStringExtra("location");

        initViewObjects();

        HttpClient client = new HttpClient();
        String cityCode = InfoSupport.getCodeFromLocation(location);
        String response = client.requestWeather(cityCode);


    }

    private void initViewObjects () {
        cityLabel = (TextView) findViewById(R.id.locationLabel);
        tempLabel = (TextView) findViewById(R.id.temperatureLabel);
        icon = (ImageView) findViewById(R.id.weatherIcon);
    }
}
