package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ss.eictapp.adapter.SongAdapter;

import java.util.ArrayList;
import java.util.List;

public class SongList extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Cursor c;
    SongAdapter sa;
    ListView songlist;
    ArrayList<String> data=new ArrayList<String>();
    ArrayList<String> song=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        checkAndRequestPermission();
        songlist=findViewById(R.id.songlist);
        c=getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        sa=new SongAdapter(this, c, 10);
        songlist.setAdapter(sa);
        songlist.setOnItemClickListener(this);
        while(c.moveToNext())
        {
            data.add(c.getString(c.getColumnIndex(MediaStore.Audio.Media.DATA)));
            song.add(c.getString(c.getColumnIndex(MediaStore.Audio.Media.TITLE)));
        }
    }


    public boolean checkAndRequestPermission()
    {
        int read= ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int write= ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        List<String> l=new ArrayList();
        if(read!= PackageManager.PERMISSION_GRANTED)
        {
            l.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if(write!=PackageManager.PERMISSION_GRANTED)
        {
            l.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if(l.size()>0)
        {
            ActivityCompat.requestPermissions(this, l.toArray(new String[l.size()]), 2000);
            return false;
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(SongList.this, MusicPlayer.class);
        intent.putExtra("song", song.get(position));
        intent.putExtra("data", data.get(position));
        startActivity(intent);

    }
}