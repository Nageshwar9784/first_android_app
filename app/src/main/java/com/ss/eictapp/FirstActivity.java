package com.ss.eictapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;

import com.ss.eictapp.broadcast.MyBroadast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class FirstActivity extends Activity {
    DatePicker datePicker;
    Button getdate, reg;
    TextView date;
    private int d, m, y, h, min, s;
    DatePickerDialog dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        date=findViewById(R.id.date);
        //datePicker=findViewById(R.id.datepicker);
        getdate=findViewById(R.id.getdate);
        getdate=findViewById(R.id.getdate);
        reg=findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(FirstActivity.this);
                dialog.setContentView(R.layout.activity_registration);
                dialog.show();
                Button r=dialog.findViewById(R.id.register);
                r.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //date.setText("Date: "+getDate());
        getdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                y=c.get(Calendar.YEAR);
                m=c.get(Calendar.MONTH);
                d=c.get(Calendar.DAY_OF_MONTH);
                h=c.get(Calendar.HOUR_OF_DAY);
                min=c.get(Calendar.MINUTE);
                s=c.get(Calendar.SECOND);
                /*dialog=new DatePickerDialog(FirstActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth+"/"+(month+1)+"/"+year);

                    }
                },y, m, d);
                dialog.show();*/
                TimePickerDialog time=new TimePickerDialog(FirstActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        date.setText(hourOfDay+":"+minute+" ");

                    }
                }, h, min, false);
                time.show();

               // date.setText("Date: "+getDate());
            }
        });
    }

   /* private String getDate() {
        String s="";
        s=s+datePicker.getDayOfMonth()+"/"+(datePicker.getMonth()+1)+"/"+datePicker.getYear();
        return s;
    }*/

    public void generateBroadcast(View view) {
        Intent intent = new Intent(FirstActivity.this, MyBroadast.class);
        sendBroadcast(intent);
    }
}
