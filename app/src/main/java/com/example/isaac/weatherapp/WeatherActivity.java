package com.example.isaac.weatherapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isaac.weatherapp.info.InfoSupport;
import com.example.isaac.weatherapp.model.Weather;
import com.example.isaac.weatherapp.webapi.HttpClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

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
        Weather weather = new Weather(response);

        cityLabel.setText(weather.getCity());
        tempLabel.setText(weather.getTemperature());

        //int id = getResources().getIdentifier("drawable/" + "a02n.png", null, null);
        //icon.setImageResource(id);
        icon.setImageResource(getIdIcon(weather.getIconCode()));
    }

    private void initViewObjects () {
        cityLabel = (TextView) findViewById(R.id.locationLabel);
        tempLabel = (TextView) findViewById(R.id.temperatureLabel);
        icon = (ImageView) findViewById(R.id.weatherIcon);
    }

    private int getIdIcon(String code) {
        switch (code) {
            case "01d": return R.drawable.a01d;
            case "01n": return R.drawable.a01n;
            case "02d": return R.drawable.a02d;
            case "02n": return R.drawable.a02n;
            case "03d": return R.drawable.a03d;
            case "03n": return R.drawable.a03n;
            case "04d": return R.drawable.a04d;
            case "04n": return R.drawable.a04n;
            case "09d": return R.drawable.a09d;
            case "09n": return R.drawable.a09n;
            case "10d": return R.drawable.a10d;
            case "10n": return R.drawable.a10n;
            case "11d": return R.drawable.a11d;
            case "11n": return R.drawable.a11n;
            case "13d": return R.drawable.a13d;
            case "13n": return R.drawable.a13n;
            case "50d": return R.drawable.a50d;
            case "50n": return R.drawable.a50n;
        }
        return 0;
    }
}
