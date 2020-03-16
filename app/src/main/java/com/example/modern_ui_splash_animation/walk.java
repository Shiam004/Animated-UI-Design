package com.example.modern_ui_splash_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class walk extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_walk);

        webView = findViewById(R.id.walk);

        WebSettings webSettings  = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://www.google.com.bd/maps/@23.7806365,90.4193257,12z");

    }
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else
            super.onBackPressed();
    }
}
