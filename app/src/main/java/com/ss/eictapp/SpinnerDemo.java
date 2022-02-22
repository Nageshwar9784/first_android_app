package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class SpinnerDemo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ConstraintLayout cl;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);
        cl = findViewById(R.id.cl);
        sp = findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (sp.getSelectedItem().toString()) {
            case "Default": {
                cl.setBackgroundColor(Color.WHITE);
                break;
            }
            case "Red": {
                cl.setBackgroundColor(Color.RED);
                break;
            }
            case "Green": {
                cl.setBackgroundColor(Color.GREEN);
                break;
            }
            case "Blue": {
                cl.setBackgroundColor(Color.BLUE);
                break;
            }
            case "Yellow": {
                cl.setBackgroundColor(Color.YELLOW);
                break;
            }
            case "Grey": {
                cl.setBackgroundColor(Color.GRAY);
                break;
            }

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}