package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.ss.eictapp.broadcast.WifiBroadcastReceiver;

import java.util.ArrayList;
import java.util.List;

public class WifiDemo extends AppCompatActivity {
    Switch s;
    WifiManager wm;
    BroadcastReceiver br;
    IntentFilter ifr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_demo);
        wm= (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        s=findViewById(R.id.wifi);
        checkAndRequestPermission();
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    if(!wm.isWifiEnabled())
                    {
                        wm.setWifiEnabled(true);
                    }
                    wm.startScan();
                }
                else
                {
                    if(wm.isWifiEnabled())
                    {
                        wm.setWifiEnabled(false);
                    }
                }
            }
        });
        br=new WifiBroadcastReceiver();
        ifr=new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        registerReceiver(br, ifr);
        wm.startScan();
    }
    public boolean checkAndRequestPermission()
    {
        int access= ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_WIFI_STATE);
        int change= ContextCompat.checkSelfPermission(this, Manifest.permission.CHANGE_WIFI_STATE);
        int fineloc= ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        List<String> l=new ArrayList();
        if(access!= PackageManager.PERMISSION_GRANTED)
        {
            l.add(Manifest.permission.ACCESS_WIFI_STATE);
        }
        if(change!=PackageManager.PERMISSION_GRANTED)
        {
            l.add(Manifest.permission.CHANGE_WIFI_STATE);
        }
        if(fineloc!= PackageManager.PERMISSION_GRANTED)
        {
            l.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if(l.size()>0)
        {
            ActivityCompat.requestPermissions(this, l.toArray(new String[l.size()]), 2000);
            return false;
        }
        return true;
    }
}