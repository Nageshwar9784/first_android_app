package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ss.eictapp.service.MyBoundedService;

public class BoundedServiceDemo extends AppCompatActivity implements View.OnClickListener {
    Button generate;
    MyBoundedService boundedService;
    boolean isbound=false;
    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBoundedService.Mybinder binder= (MyBoundedService.Mybinder) service;
            boundedService=binder.getService();
            isbound=true;
            Toast.makeText(boundedService, "Service Connected", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isbound=false;
            boundedService=null;
            Toast.makeText(boundedService, "Service Disconnected", Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bounded_service_demo);
        generate=findViewById(R.id.generate);
        generate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this, MyBoundedService.class);
        startService(intent);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                Toast.makeText(boundedService, String.valueOf(boundedService.generateNumber()), Toast.LENGTH_SHORT).show();
            }
        };
        Handler handler=new Handler();
        handler.postDelayed(runnable, 1000);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isbound)
        {
            unbindService(serviceConnection);
            isbound=false;
        }
    }
}