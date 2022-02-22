package com.ss.eictapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewDemo extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_demo);
        webView=findViewById(R.id.webview);
        final ProgressDialog pd=new ProgressDialog(this);
        pd.setMessage("Loading ..");
        pd.setCancelable(false);
        webView.setVerticalScrollBarEnabled(true);
        webView.requestFocus();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        webView.loadUrl("https://bcebakhtiyarpur.org/");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(String.valueOf(request.getUrl()));
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress<100)
                {
                    pd.show();
                }
                else
                {
                    pd.dismiss();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(webView!=null && webView.canGoBack())
        {
            webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}