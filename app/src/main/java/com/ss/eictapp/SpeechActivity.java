package com.ss.eictapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class SpeechActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private TextToSpeech textToSpeech;
    Button button;
    EditText text;
    int lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);
        button=findViewById(R.id.button);
        text=findViewById(R.id.text);
        textToSpeech=new TextToSpeech(this, this);
        lang=textToSpeech.setLanguage(Locale.UK);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }

    @Override
    public void onInit(int status) {
        if(status==TextToSpeech.SUCCESS)
        {
            if(lang==TextToSpeech.LANG_MISSING_DATA || lang==TextToSpeech.LANG_NOT_SUPPORTED)
            {
                Toast.makeText(this, "Data Missing OR Language Not Supproted", Toast.LENGTH_SHORT).show();
            }
            else
            {
                speak();
            }
        }
        else
        {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
        }

    }
    public void speak()
    {
        String data=text.getText().toString();
        textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mylocale, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getTitle().toString())
        {
            case "USA":
                lang=textToSpeech.setLanguage(Locale.US);
                break;
            case "UK":
                lang=textToSpeech.setLanguage(Locale.UK);
                break;
            case "FRENCH":
                lang=textToSpeech.setLanguage(Locale.FRANCE);
                break;
            case "GERMAN":
                lang=textToSpeech.setLanguage(Locale.GERMANY);
                break;
            case "CHINESE":
                lang=textToSpeech.setLanguage(Locale.CHINA);
                break;
        }
        return false;
    }
}