package com.ss.eictapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.ss.eictapp.R;

public class TicTacToe extends AppCompatActivity implements View.OnClickListener {
    int chance = 0;
    TextView turn, win;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        turn=findViewById(R.id.turn);
        win=findViewById(R.id.win);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        reset=findViewById(R.id.reset);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                if (chance == 0) {
                    chance = 1;
                    btn1.setText("O");
                    turn.setText("TURN: X");
                    result();
                } else {
                    chance = 0;
                    btn1.setText("X");
                    turn.setText("TURN: O");
                    result();
                }
                btn1.setEnabled(false);
                break;
            case R.id.btn2:
                if (chance == 0) {
                    chance = 1;
                    btn2.setText("O");
                    turn.setText("TURN: X");
                    result();
                } else {
                    chance = 0;
                    btn2.setText("X");
                    turn.setText("TURN: O");
                    result();
                }
                btn2.setEnabled(false);
                break;
            case R.id.btn3:
                if (chance == 0) {
                    chance = 1;
                    btn3.setText("O");
                    turn.setText("TURN: X");
                    result();
                } else {
                    chance = 0;
                    btn3.setText("X");
                    turn.setText("TURN: O");
                    result();
                }
                btn3.setEnabled(false);
                break;
            case R.id.btn4:
                if (chance == 0) {
                    chance = 1;
                    btn4.setText("O");
                    turn.setText("TURN: X");
                    result();
                } else {
                    chance = 0;
                    btn4.setText("X");
                    turn.setText("TURN: O");
                    result();
                }
                btn4.setEnabled(false);
                break;
            case R.id.btn5:
                if (chance == 0) {
                    chance = 1;
                    btn5.setText("O");
                    turn.setText("TURN: X");
                    result();
                } else {
                    chance = 0;
                    btn5.setText("X");
                    turn.setText("TURN: O");
                    result();
                }
                btn5.setEnabled(false);
                break;
            case R.id.btn6:
                if (chance == 0) {
                    chance = 1;
                    btn6.setText("O");
                    turn.setText("TURN: X");
                    result();
                } else {
                    chance = 0;
                    btn6.setText("X");
                    turn.setText("TURN: O");
                    result();
                }
                btn6.setEnabled(false);
                break;
            case R.id.btn7:
                if (chance == 0) {
                    chance = 1;
                    btn7.setText("O");
                    turn.setText("TURN: X");
                    result();
                } else {
                    chance = 0;
                    btn7.setText("X");
                    turn.setText("TURN: O");
                    result();
                }
                btn7.setEnabled(false);
                break;
            case R.id.btn8:
                if (chance == 0) {
                    chance = 1;
                    btn8.setText("O");
                    turn.setText("TURN: X");
                    result();
                } else {
                    chance = 0;
                    btn8.setText("X");
                    turn.setText("TURN: O");
                    result();
                }
                btn8.setEnabled(false);
                break;
            case R.id.btn9:
                if (chance == 0) {
                    chance = 1;
                    btn9.setText("O");
                    turn.setText("TURN: X");
                    result();
                } else {
                    chance = 0;
                    btn9.setText("X");
                    turn.setText("TURN: O");
                    result();
                }
                btn9.setEnabled(false);
                break;
            case R.id.reset:
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                turn.setText("TURN: O");
                chance = 0;
                win.setText("");
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
                btn9.setEnabled(true);
        }
    }


    public void result() {
        if (btn1.getText().toString().equals("X") && btn2.getText().toString().equals("X") && btn3.getText().toString().equals("X")) {
            win.setText("X WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if (btn4.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn6.getText().toString().equals("X")) {
            win.setText("X WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if (btn7.getText().toString().equals("X") && btn8.getText().toString().equals("X") && btn9.getText().toString().equals("X")) {
            win.setText("X WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if (btn1.getText().toString().equals("O") && btn2.getText().toString().equals("O") && btn3.getText().toString().equals("O")) {
            win.setText("O WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if (btn4.getText().toString().equals("O") && btn5.getText().toString().equals("O") && btn6.getText().toString().equals("O")) {
            win.setText("O WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if (btn7.getText().toString().equals("O") && btn8.getText().toString().equals("O") && btn9.getText().toString().equals("O")) {
            win.setText("O WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if (btn1.getText().toString().equals("X") && btn4.getText().toString().equals("X") && btn7.getText().toString().equals("X")) {
            win.setText("X WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if (btn2.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn8.getText().toString().equals("X")) {
            win.setText("X WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if (btn3.getText().toString().equals("X") && btn6.getText().toString().equals("X") && btn9.getText().toString().equals("X")) {
            win.setText("X WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if (btn1.getText().toString().equals("O") && btn4.getText().toString().equals("O") && btn7.getText().toString().equals("O")) {
            win.setText("O WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if (btn2.getText().toString().equals("O") && btn5.getText().toString().equals("O") && btn8.getText().toString().equals("O")) {
            win.setText("O WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if (btn3.getText().toString().equals("O") && btn6.getText().toString().equals("O") && btn9.getText().toString().equals("O")) {
            win.setText("O WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if (btn1.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn9.getText().toString().equals("X")) {
            win.setText("X WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if (btn3.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn7.getText().toString().equals("X")) {
            win.setText("X WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if (btn1.getText().toString().equals("O") && btn5.getText().toString().equals("O") && btn9.getText().toString().equals("O")) {
            win.setText("O WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if (btn3.getText().toString().equals("O") && btn5.getText().toString().equals("O") && btn7.getText().toString().equals("O")) {
            win.setText("O WINS !!");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        else if((btn1.getText().toString().contains("O") || btn1.getText().toString().contains("X")) &&
                (btn2.getText().toString().contains("O") || btn2.getText().toString().contains("X")) &&
                (btn3.getText().toString().contains("O") || btn3.getText().toString().contains("X")) &&
                (btn4.getText().toString().contains("O") || btn4.getText().toString().contains("X")) &&
                (btn5.getText().toString().contains("O") || btn5.getText().toString().contains("X")) &&
                (btn6.getText().toString().contains("O") || btn6.getText().toString().contains("X")) &&
                (btn7.getText().toString().contains("O") || btn7.getText().toString().contains("X")) &&
                (btn8.getText().toString().contains("O") || btn8.getText().toString().contains("X")) &&
                (btn9.getText().toString().contains("O") || btn9.getText().toString().contains("X"))) {
            win.setText("DRAW");
            turn.setText("");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
    }
}