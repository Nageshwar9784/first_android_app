package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class QuizResult extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        tv=findViewById(R.id.result);
        Bundle b=getIntent().getExtras();
        tv.setText("RESULT: "+b.getString("result"));
    }
}