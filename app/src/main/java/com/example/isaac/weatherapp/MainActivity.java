package com.example.isaac.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class MainActivity extends AppCompatActivity {

    private Spinner locationSpinner;
    private boolean hasChanged = false;
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
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, locations);

        locationSpinner.setAdapter(spinnerAdapter);

        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                System.out.println();
                if (!hasChanged) {
                    hasChanged = true;
                    return;
                }

                Intent weatherActivity = new Intent(MainActivity.this, WeatherActivity.class);
                String selected = (String) adapterView.getItemAtPosition(pos);
                weatherActivity.putExtra("location", selected);
                startActivity(weatherActivity);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Nothing
            }
        });

    }
}
