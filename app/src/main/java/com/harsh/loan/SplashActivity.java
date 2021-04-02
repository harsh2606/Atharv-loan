package com.harsh.loan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private static int splash_timeout = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView img = findViewById(R.id.img);
        TextView text = findViewById(R.id.text);

        Animation top= AnimationUtils.loadAnimation(this,R.anim.top);
        Animation bottom= AnimationUtils.loadAnimation(this,R.anim.bottom);

        img.setAnimation(top);
        text.setAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },splash_timeout);
    }
}
