package com.example.firebasetaxiapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.firebasetaxiapp.R;

public class ChooseModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode);
    }

    public void goToPassenger(View view) {
        startActivity(new Intent(ChooseModeActivity.this,
                PassengerSingInActivity.class));
    }

    public void goToDriver(View view) {
        startActivity(new Intent(ChooseModeActivity.this,
                DriverSingInActivity.class));
    }
}