package com.ss.eictapp.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.ss.eictapp.R;

public class MyMusicService extends Service implements MediaPlayer.OnCompletionListener {
    MediaPlayer mp;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp=MediaPlayer.create(this, R.raw.music);
        mp.setOnCompletionListener(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!mp.isPlaying())
            mp.start();
        return START_STICKY;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        stopSelf();

    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Music Stopped", Toast.LENGTH_SHORT).show();
        mp.stop();
        mp.release();
        super.onDestroy();
    }
}
