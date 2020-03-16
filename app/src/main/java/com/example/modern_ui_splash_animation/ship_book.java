package com.example.modern_ui_splash_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ship_book extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_ship_book);

        webView = findViewById(R.id.ship_book);

        WebSettings webSettings  = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://www.shohoz.com/launch/");
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
