package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Quiz extends AppCompatActivity implements View.OnClickListener {
    String que[]={"___________ is the first woman to head a public sector bank.", "World Tourism Day is celebrated on _______.",
            "When is the International Yoga Day celebrated?", "Line of blood is a book written by whom?"};
    String op1[]={"Arundhati Bhattacharya", "September 12", "June 21", "Bairaj Khanna"};
    String op2[]={"Shikha Sharma", "September 25", "March 21", "Ursula Vernon"};
    String op3[]={"Chanda Kochar", "September 27", "April 22", "Amal EI-Mohtar"};
    String op4[]={"Usha Ananthasubramanyan", "September 29", "May 31", "Diksha Basu"};
    String answers[]={"Arundhati Bhattacharya", "September 27", "June 21", "Bairaj Khanna"};
    RadioButton r1, r2, r3, r4;
    RadioGroup rg;
    Button next;
    TextView ques;
    int i=0;
    int result=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        r1=findViewById(R.id.btn1);
        r2=findViewById(R.id.btn2);
        r3=findViewById(R.id.btn3);
        r4=findViewById(R.id.btn4);
        rg=findViewById(R.id.rg);
        next=findViewById(R.id.finish);
        ques=findViewById(R.id.que);
        setQuestion();
        next.setOnClickListener(this);
    }

    public void setQuestion() {
        ques.setText(que[i]);
        r1.setText(op1[i]);
        r2.setText(op2[i]);
        r3.setText(op3[i]);
        r4.setText(op4[i]);
    }

    @Override
    public void onClick(View v) {
        if(i<=3)
        {
            RadioButton r=findViewById(rg.getCheckedRadioButtonId());
            if(r!=null)
            {
                if(r.getText().toString().equals(answers[i]))
                {
                    result+=10;
                    rg.clearCheck();
                }
            }
        }
        if(i==3)
        {
            hideView();
            //Toast.makeText(this, ""+String.valueOf(result), Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Quiz.this, QuizResult.class);
            intent.putExtra("result", String.valueOf(result));
            startActivity(intent);
        }
        if(i<3)
        {
            i++;
            setQuestion();
        }

    }

    public void hideView() {
        ques.setVisibility(View.GONE);
        r1.setVisibility(View.GONE);
        r2.setVisibility(View.GONE);
        r3.setVisibility(View.GONE);
        r4.setVisibility(View.GONE);
        rg.setVisibility(View.GONE);
        next.setVisibility(View.GONE);
    }
}