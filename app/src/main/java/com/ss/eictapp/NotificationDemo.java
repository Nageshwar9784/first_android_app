package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationDemo extends AppCompatActivity implements View.OnClickListener {
    NotificationManager nm;
    NotificationChannel nc;
    NotificationCompat.Builder nb;
    Button notification;
    final public static String CHANNEL_ID="eict";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);
        notification=findViewById(R.id.notificaton);
        notification.setOnClickListener(this);
        nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public void onClick(View v) {
        nb=new NotificationCompat.Builder(this, CHANNEL_ID);
        nb.setSmallIcon(android.R.drawable.sym_def_app_icon);
        nb.setContentText("NOTIFICATION");
        nb.setContentText("You Have a Notification");
        nb.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        createNotificationChannel();
        Intent intent=new Intent(this, NotifyResult.class);
        PendingIntent pi=PendingIntent.getActivity(this, 0, intent, 0);
        nb.setContentIntent(pi);
        nb.setAutoCancel(true);
        NotificationManagerCompat nmc=NotificationManagerCompat.from(this);
        nmc.notify(0,nb.build());
    }
    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            CharSequence name=getString(R.string.channel_name);
            String desc=getString(R.string.channel_disc);
            int imp=NotificationManager.IMPORTANCE_DEFAULT;
            nc=new NotificationChannel(CHANNEL_ID, name, imp);
            nc.setDescription(desc);
            nm.createNotificationChannel(nc);
        }
    }
}