package com.aekici.sudokugenius;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.aekici.sudokugenius.utilities.DebugUtils;
import com.aekici.sudokugenius.utilities.ViewUtils;

public class LoginActivity extends AppCompatActivity
{

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView loginScreenLogoImageView = findViewById(R.id.LoginScreenLogoImageViewId);

        ViewUtils.setViewSizeBasedOnScreenPercentage(loginScreenLogoImageView, R.fraction.login_logo_width_fraction, R.fraction.login_logo_height_fraction, this);
        ViewUtils.setMarginsBasedOnScreenPercentage(
                loginScreenLogoImageView,
                this,
                null,
                R.fraction.margin_top_login_logo_fraction, // Top margin
                R.fraction.default_margin_end_fraction, // Bottom margin margin_top_login_logo_fraction
                R.fraction.default_margin_end_fraction, // Left/Start margin
                R.fraction.default_margin_end_fraction // Right/End margin
                );
    }


    /*
    On Click Actions.
    */


    // Continue without login option.
    public void onClickContinue(View view)
    {
        DebugUtils.printScreenShort(this, "Continue without login clicked.");
    }


}