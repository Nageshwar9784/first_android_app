package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.ss.eictapp.broadcast.BluetoothBroadcastReceiver;

public class BluetoothDemo extends AppCompatActivity {
    Switch s;
    BluetoothAdapter ba;
    BroadcastReceiver br;
    IntentFilter ifr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_demo);
        s=findViewById(R.id.bluetooth);
        ba=BluetoothAdapter.getDefaultAdapter();
        if(ba!=null)
        {
            s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                    {
                        if(!ba.isEnabled())
                        {
                            Toast.makeText(BluetoothDemo.this, "Turning ON Bluetooth ..", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                            startActivity(intent);
                        }
                        ba.startDiscovery();
                    }
                    else
                    {
                        if(ba.isEnabled())
                        {
                            ba.disable();
                        }
                    }
                }
            });
        }
        else
        {
            Toast.makeText(this, "No Bluetooth Hardware Found", Toast.LENGTH_SHORT).show();
        }
        br=new BluetoothBroadcastReceiver();
        ifr=new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(br, ifr);
        ba.startDiscovery();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ba.startDiscovery();
    }
}