package com.example.isaac.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class MainActivity extends AppCompatActivity {

    private Spinner locationSpinner;
    private String[] locations = {"Mexico  City", "Paris", "Madrid", "Caracas", "London"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewObjects();
        setupLocationSpinner();
    }

    private void initViewObjects () {
        locationSpinner = (Spinner) findViewById(R.id.locationSpinner);
    }

    private void setupLocationSpinner () {
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, locations);

        locationSpinner.setAdapter(spinnerAdapter);

        locationSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
