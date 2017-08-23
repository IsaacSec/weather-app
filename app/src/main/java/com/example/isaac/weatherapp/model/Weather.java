package com.example.isaac.weatherapp.model;

/**
 * Created by isaac on 8/22/17.
 */

import org.json.JSONException;
import org.json.JSONObject;

public class Weather {
    private String city;
    private String temperature;
    private String iconCode;

    public Weather(String jsonString) {
        try {
            JSONObject json = new JSONObject(jsonString);
            city = json.getString("name");
            temperature = json.getJSONObject("main").getString("temp");
            float celcious = (float)(Float.parseFloat(temperature) - 273.15d);
            celcious = Math.round(celcious*10);
            celcious = celcious / 10;
            temperature = celcious +"°C";
            iconCode = json.getJSONArray("weather").get(0).toString();
            iconCode = new JSONObject(iconCode).getString("icon");
        } catch (JSONException e) {
            e.printStackTrace();
            city = "--";
            temperature = "--";
            iconCode = "error.png";
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getIconCode() {
        return iconCode;
    }

    public void setIconCode(String iconCode) {
        this.iconCode = iconCode;
    }
}
