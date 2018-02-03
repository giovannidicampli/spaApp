package com.vanni.spaApp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;


public class SplashActivity extends AppCompatActivity {

    int timeout = 2000;
    ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        this.logo = findViewById(R.id.villaSalus);
        logo.setImageResource(R.drawable.logo);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent main = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(main);
                finish();
            }
        }, timeout);
    }
}
