package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ss.eictapp.model.StudentHelper;

public class Registration extends AppCompatActivity implements View.OnClickListener {
    EditText id, name, age, add, branch;
    Button register;
    StudentHelper sh;
    SQLiteDatabase sd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name=findViewById(R.id.name);
        id=findViewById(R.id.id);
        add=findViewById(R.id.address);
        age=findViewById(R.id.age);
        branch=findViewById(R.id.branch);
        register=findViewById(R.id.register);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String sname=name.getText().toString();
        String address=add.getText().toString();
        String sbranch=branch.getText().toString();
        int sage= Integer.parseInt(age.getText().toString().trim());
        int sid= Integer.parseInt(id.getText().toString().trim());
        sh=new StudentHelper(this);
        sd=sh.getWritableDatabase();
        sh.addStudent(sd, sid, sname, sage, address, sbranch);
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();

    }
}