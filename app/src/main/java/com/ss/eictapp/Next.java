package com.ss.eictapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Next extends AppCompatActivity {
    EditText msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        msg=findViewById(R.id.msg);
    }
    public void previous(View v)
    {
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();
        final Intent intent=new Intent();
        String m=msg.getText().toString();
        intent.putExtra("msg", m);
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Select Your Choice");
        ad.setMessage("Go to Previous?");
        ad.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setResult(1111, intent);
                finish();
            }
        });
        ad.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Next.this, "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });
        ad.show();
    }
}