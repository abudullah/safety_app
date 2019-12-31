package com.example.myapplication;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ddm extends AppCompatActivity {
  private  WebView ddm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddm);
        ddm=findViewById(R.id.webbi);

         WebSettings webSettings = ddm.getSettings();
         webSettings.getJavaScriptEnabled();
        ddm.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        ddm.getSettings().setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setEnableSmoothTransition(true);

         ddm.loadUrl("http://www.ddm.gov.bd/");
        ddm.setWebViewClient(new WebViewClient());
    }
    void showmassage (String title, String massage)
    {
        AlertDialog.Builder dialouge = new AlertDialog.Builder(this);
        dialouge.setTitle(title);
        dialouge.setMessage(massage);
        dialouge.show();

    }
}
