package com.ss.eictapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public class BarCodeScanner extends AppCompatActivity {
    CodeScanner scanner;
    CodeScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code_scanner);
        scannerView=findViewById(R.id.camscanner);
        scanner=new CodeScanner(this, scannerView);
        scanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                BarCodeScanner.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        MediaPlayer mp=MediaPlayer.create(BarCodeScanner.this, R.raw.tone);
                        mp.start();
                        Toast.makeText(BarCodeScanner.this, result.getText(), Toast.LENGTH_SHORT).show();
                        finish();

                    }
                });
            }
        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanner.startPreview();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        scanner.startPreview();
    }
}