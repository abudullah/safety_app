package com.example.myapplication;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class bfs extends AppCompatActivity {
  private WebView  a ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bfs);
      try {
          a = findViewById(R.id.bfs);
          WebSettings d = a.getSettings();
          d.getJavaScriptEnabled();
          a.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
          a.getSettings().setAppCacheEnabled(true);
          d.setDomStorageEnabled(true);
          d.setEnableSmoothTransition(true);
         // a.getSettings().getCacheMode(WebS);
       //   a.setWebViewClient(new WebViewClient());
          a.loadUrl("http://www.fireservice.gov.bd/");

          a.setWebViewClient(new WebViewClient());


      }
      catch (Exception e)
      {
          showmassage("problem was","  "+e);
      }
    }
    void showmassage (String title, String massage)
    {
        AlertDialog.Builder dialouge = new AlertDialog.Builder(this);
        dialouge.setTitle(title);
        dialouge.setMessage(massage);
        dialouge.show();

    }
}
