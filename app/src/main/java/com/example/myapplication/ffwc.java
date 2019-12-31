package com.example.myapplication;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ffwc extends AppCompatActivity {
  private  WebView bdrcs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ffwc);
        bdrcs =findViewById(R.id.ffwc);

            WebSettings a = bdrcs.getSettings();
            a.getJavaScriptEnabled();

        bdrcs.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        bdrcs.getSettings().setAppCacheEnabled(true);
        a.setDomStorageEnabled(true);
        a.setEnableSmoothTransition(true);

            bdrcs.loadUrl("http://www.ffwc.gov.bd/");
        bdrcs.setWebViewClient(new WebViewClient());


    }
    void showmassage (String title, String massage)
    {
        android.app.AlertDialog.Builder dialouge = new AlertDialog.Builder(this);
        dialouge.setTitle(title);
        dialouge.setMessage(massage);
        dialouge.show();

    }
}
