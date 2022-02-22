package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {
    //ProgressBar pb;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sp=getSharedPreferences("eictAppPref", MODE_PRIVATE);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sp.getBoolean("isLogin", false))
                {
                    Intent intent=new Intent(Splash.this, MenuActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finishAffinity();
                }
                else
                {
                    Intent intent=new Intent(Splash.this, Login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finishAffinity();
                }
            }
        }, 0);
       /* pb = findViewById(R.id.pb);
        new Thread()
        {
            @Override
            public void run() {
                try {
                    for (int i = 0; i <= 25; i++)
                    {
                        pb.setProgress(4 * i);
                        Thread.sleep(150);
                    }
                    Intent intent = new Intent(Splash.this, MenuActivity.class);
                    startActivity(intent);
                }
                catch (Exception e)
                {

                }
            }
        }.start();*/
    }
}
