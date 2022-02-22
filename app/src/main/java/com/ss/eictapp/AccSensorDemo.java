package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AccSensorDemo extends AppCompatActivity {
    SensorManager sm;
    TextView tv;
    Sensor s;
    SensorEventListener sel=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x=event.values[0];
            float y=event.values[1];
            float z=event.values[2];
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv.setText("AZIMUTH: "+x+"\nPITCH: "+y+"\nROLL: "+z);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        tv=findViewById(R.id.sensors);
        sm= (SensorManager) getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(sel, s, SensorManager.SENSOR_DELAY_NORMAL);
    }
}