package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class ColorPicker extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    SeekBar r, g, b;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);
        r=findViewById(R.id.r);
        g=findViewById(R.id.g);
        b=findViewById(R.id.b);
        layout=findViewById(R.id.layout);
        layout.setBackgroundColor(Color.rgb(r.getProgress(), g.getProgress(), b.getProgress()));
        r.setOnSeekBarChangeListener(this);
        g.setOnSeekBarChangeListener(this);
        b.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        layout.setBackgroundColor(Color.rgb(r.getProgress(), g.getProgress(), b.getProgress()));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}