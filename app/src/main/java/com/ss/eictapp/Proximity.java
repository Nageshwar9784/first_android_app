package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Proximity extends AppCompatActivity {
    SensorManager sm;
    Sensor s;
    TextView tv;
    SensorEventListener sel= new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x=event.values[0];
            tv.setText(String.valueOf(x));
            if(x<s.getMaximumRange())
            {
                tv.setText("NEAR");
            }
            else
            {
                tv.setText("FAR");
            }
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
        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        sm= (SensorManager) getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(sel, s, SensorManager.SENSOR_DELAY_NORMAL);
    }
}