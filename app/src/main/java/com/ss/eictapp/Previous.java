package com.ss.eictapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Previous extends AppCompatActivity {
    TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous);
        msg=findViewById(R.id.msg);
    }
    public void next(View v)
    {
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, Next.class);
        startActivityForResult(intent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1000 && resultCode==1111 && data!=null)
        {
            Bundle b=data.getExtras();
            msg.setText(b.getString("msg"));
        }
    }
}