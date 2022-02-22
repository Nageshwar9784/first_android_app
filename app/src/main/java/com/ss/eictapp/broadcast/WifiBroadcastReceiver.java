package com.ss.eictapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.widget.Toast;

import java.util.List;

public class WifiBroadcastReceiver extends BroadcastReceiver {
    WifiManager wm;
    @Override
    public void onReceive(Context context, Intent intent) {
        wm= (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        List<ScanResult> results=wm.getScanResults();
        for(ScanResult s:results)
        {
            Toast.makeText(context, s.BSSID+"\t"+s.SSID+"\t"+s.level, Toast.LENGTH_SHORT).show();
        }
    }
}
