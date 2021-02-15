package com.example.dndlist;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenLayout extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EasySplashScreen config = new EasySplashScreen(SplashScreenLayout.this)
                .withFullScreen()
                .withTargetActivity(Authorization.class)
                .withSplashTimeOut(1000)
                .withBackgroundResource(R.drawable.efimov);
        View easySplashScreen = config.create();
        setContentView(easySplashScreen);
    }
}
