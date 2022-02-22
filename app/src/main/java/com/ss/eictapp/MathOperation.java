package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MathOperation extends AppCompatActivity implements View.OnClickListener {
    TextView result;
    EditText n1, n2;
    Button a, s, m, d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_operation);
        result=findViewById(R.id.res);
        n1=findViewById(R.id.num1);
        n2=findViewById(R.id.num2);
        a=findViewById(R.id.add);
        s=findViewById(R.id.sub);
        m=findViewById(R.id.mul);
        d=findViewById(R.id.div);
        a.setOnClickListener(this);
        s.setOnClickListener(this);
        m.setOnClickListener(this);
        d.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double numb1 = Double.parseDouble(n1.getText().toString());
        double numb2 = Double.parseDouble(n2.getText().toString());
        switch (v.getId()){
            case R.id.add:
            result.setText(String.valueOf(numb1+numb2));
            break;
            case R.id.sub:
                result.setText(String.valueOf(numb1-numb2));
                break;
            case R.id.mul:
                result.setText(String.valueOf(numb1*numb2));
                break;
            case R.id.div:
                result.setText(String.valueOf(numb1/numb2));
                break;
        }

    }
}