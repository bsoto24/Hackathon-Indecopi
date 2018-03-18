package com.openlab.consumidor.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.openlab.consumidor.R;

public class SplashActivity extends AppCompatActivity {

    private final Handler waitHandler = new Handler();
    private final Runnable waitCallback = () -> {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        waitHandler.postDelayed(waitCallback, 2000);

    }

    @Override
    protected void onDestroy() {
        waitHandler.removeCallbacks(waitCallback);
        super.onDestroy();
    }

}
