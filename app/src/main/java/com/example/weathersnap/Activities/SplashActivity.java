package com.example.weathersnap.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.weathersnap.R;

public class SplashActivity extends AppCompatActivity {
    private static final long SPLASH_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(()->{
            Intent splashIntent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(splashIntent);
            finish();
        }, SPLASH_DELAY);
    }
}