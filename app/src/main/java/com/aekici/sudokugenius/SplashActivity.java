package com.aekici.sudokugenius;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import com.aekici.sudokugenius.utilities.ViewUtils;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity
{

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView splashScreenLogoImageView = findViewById(R.id.SplashScreenLogoImageViewId);

        ViewUtils.setViewSizeBasedOnScreenPercentage(splashScreenLogoImageView, R.fraction.splash_icon_width_fraction, R.fraction.splash_icon_height_fraction, this);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {

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
