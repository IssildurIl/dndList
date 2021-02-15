package com.example.dndlist.utils;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dndlist.MainActivity;
import com.example.dndlist.R;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenLayout extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EasySplashScreen config = new EasySplashScreen(SplashScreenLayout.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(1000)
                .withBackgroundResource(R.drawable.efimov);
        View easySplashScreen = config.create();
        setContentView(easySplashScreen);
    }
}
