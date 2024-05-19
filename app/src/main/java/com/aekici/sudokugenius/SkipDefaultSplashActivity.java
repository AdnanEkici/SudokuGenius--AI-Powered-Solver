package com.aekici.sudokugenius;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

@SuppressLint("CustomSplashScreen")
public class SkipDefaultSplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_default_splash);


        Intent mainIntent = new Intent(SkipDefaultSplashActivity.this, SplashActivity.class);
        SkipDefaultSplashActivity.this.startActivity(mainIntent);
        SkipDefaultSplashActivity.this.finish();


    }
}