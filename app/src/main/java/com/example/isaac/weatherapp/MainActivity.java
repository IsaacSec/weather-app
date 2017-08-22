package com.example.isaac.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner locationSpinner = (Spinner) findViewById(R.id.locationSpinner);
    private String[] locations = {"Mexico  City", "Paris", "Madrid", "Caracas", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
