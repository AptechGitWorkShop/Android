package com.example.md_lottie_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    //TextView textView;
    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,(WindowManager.LayoutParams.FLAG_FULLSCREEN));
        setContentView(R.layout.activity_main);
      //  textView = findViewById(R.id.appname);
        lottieAnimationView = findViewById(R.id.logo_travel);

        //textView.animate().translationY(-1400).setDuration(3700).setStartDelay(0) ;
        lottieAnimationView.animate().translationX(2000).setDuration(3000).setStartDelay(2900) ;




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent  intent = new Intent(MainActivity.this,Welcome.class);
                 startActivity(intent);
            }
        },3000);
    }
}