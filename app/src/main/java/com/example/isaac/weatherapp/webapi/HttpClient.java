package com.example.isaac.weatherapp.webapi;

import android.os.StrictMode;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by isaac on 8/22/17.
 */

public class HttpClient {
    private String API_URL = "http://api.openweathermap.org/data/2.5/weather?";
    private String API_KEY = "f727bfff0a07f01698799cd08693e17a";

    private OkHttpClient client;

    public HttpClient(){
        client = new OkHttpClient();
    }

    public String requestWeather (String cityCode) {
        try {
            String url = API_URL + "id=" + cityCode + "&APPID=" + API_KEY;
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String response = run(url);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"Error\":\"Failed in request\"}";
        }
    }

    private String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
