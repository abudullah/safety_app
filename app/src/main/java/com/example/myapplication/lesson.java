package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lesson extends AppCompatActivity implements View.OnClickListener{
    private Button bfs,bdrcs,ddm,ffwc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        bfs=findViewById(R.id.bfs);
        bdrcs=findViewById(R.id.bdrcs);
        ddm=findViewById(R.id.ddm);
        ffwc=findViewById(R.id.ffwc);

bfs.setOnClickListener(this);
        bdrcs.setOnClickListener(this);
        ddm.setOnClickListener(this);
        ffwc.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.ddm){
            Intent i;
            i=new Intent(lesson.this,ddm.class);
            startActivity(i);

        }
      else  if (v.getId()==R.id.bdrcs){
            Intent i;
            i=new Intent(lesson.this,bdrcs.class);
            startActivity(i);
        }
        else  if (v.getId()==R.id.bfs){
            Intent i;
            i=new Intent(lesson.this,bfs.class);
            startActivity(i);

        }
        else  if (v.getId()==R.id.ffwc){
            Intent i;
            i=new Intent(lesson.this,ffwc.class);
            startActivity(i);
        }
    }
}
