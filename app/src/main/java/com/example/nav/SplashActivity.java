package com.example.nav;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;// Splash time out kestab 4 sekundit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){ // Ei tea
            @Override
            public void run(){ // Meetod läheb tööle
                Intent mainIntent = new Intent(SplashActivity.this,
                        MainActivity.class); // Muudab Activitit
                startActivity(mainIntent); // Käivitab Intenti mis vahetab activitit
                finish(); // Lõpetab meetodi
            }
        },SPLASH_TIME_OUT); // Time out kestab 4 sekundit
    }
}
