package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ss.eictapp.service.MyMusicService;

public class MusicService extends AppCompatActivity implements View.OnClickListener {
    Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_service);
        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this, MyMusicService.class);
        switch (v.getId())
        {
            case R.id.start:
                startService(intent);
                break;
            case R.id.stop:
                stopService(intent);
                break;
        }

    }
}