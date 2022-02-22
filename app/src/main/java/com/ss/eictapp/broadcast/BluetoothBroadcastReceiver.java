package com.ss.eictapp.broadcast;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BluetoothBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if(action.equals(BluetoothDevice.ACTION_FOUND))
        {
            Bundle bundle=intent.getExtras();
            BluetoothDevice bd=bundle.getParcelable(BluetoothDevice.EXTRA_DEVICE);
            Toast.makeText(context, ""+bd.getName()+"||"+bd.getAddress(), Toast.LENGTH_SHORT).show();
        }
    }
}
