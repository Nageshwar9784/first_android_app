package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText id, password;
    Button login;
    SharedPreferences sp;
    SharedPreferences.Editor se;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        id=findViewById(R.id.userid);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        login.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        String uid=id.getText().toString();
        String pass=password.getText().toString();
        if(uid.equals(pass))
        {
            sp=getSharedPreferences("eictAppPref", MODE_PRIVATE);
            se=sp.edit();
            se.putBoolean("isLogin", true);
            se.commit();
            Intent intent=new Intent(Login.this, MenuActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "INVALID USER", Toast.LENGTH_SHORT).show();
        }
    }
}