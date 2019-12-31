package com.example.myapplication;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class bdrcs extends AppCompatActivity {
    WebView bdrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdrcs);
        bdrc =findViewById(R.id.bdrcs);
          WebSettings a = bdrc.getSettings();
          a.getJavaScriptEnabled();
        bdrc.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        bdrc.getSettings().setAppCacheEnabled(true);
        a.setDomStorageEnabled(true);
        a.setEnableSmoothTransition(true);

          bdrc.loadUrl("http://www.bdrcs.org/");
        bdrc.setWebViewClient(new WebViewClient());



    }
    void showmassage (String title, String massage)
    {
        AlertDialog.Builder dialouge = new AlertDialog.Builder(this);
        dialouge.setTitle(title);
        dialouge.setMessage(massage);
        dialouge.show();

    }
}
