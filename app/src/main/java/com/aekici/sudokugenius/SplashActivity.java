package com.aekici.sudokugenius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.util.DisplayMetrics;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView imageView = findViewById(R.id.GfG_full_logo);

        // Get the screen width
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;

        // Get the desired width based on percentage defined in dimensions.xml
        float widthPercentage = getResources().getFraction(R.fraction.splash_icon_width_fraction, 1, 1);
        float heightPercentage = getResources().getFraction(R.fraction.splash_icon_height_fraction, 1, 1);
        int desiredWidth = (int) (screenWidth * widthPercentage);
        int desiredHeight = (int) (screenWidth * heightPercentage); // assuming you want the height to be based on the width

        // Set the width and height of the ImageView
        imageView.getLayoutParams().width = desiredWidth;
        imageView.getLayoutParams().height = desiredHeight;



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //Create an intent that will start the main activity.
                Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                SplashActivity.this.startActivity(mainIntent);

                //Finish splash activity so user cant go back to it.
                SplashActivity.this.finish();

                //Apply splash exit (fade out) and main entry (fade in) animation transitions.
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        }, 3000);

    }


}
