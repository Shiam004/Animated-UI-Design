package com.example.modern_ui_splash_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class bus_Booking extends AppCompatActivity {

    WebView busview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_bus__booking);

        busview = findViewById(R.id.bus_book);

        WebSettings webSettings  = busview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        busview.setWebViewClient(new WebViewClient());

        busview.loadUrl("https://www.shohoz.com/bus-tickets");
    }


    @Override
    public void onBackPressed() {
        if(busview.canGoBack()){
            busview.goBack();
        }
        else
            super.onBackPressed();
    }
}
