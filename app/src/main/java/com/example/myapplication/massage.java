package com.example.myapplication;

import android.Manifest;
import android.app.AlertDialog;

import android.app.PendingIntent;

import android.content.pm.PackageManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class massage extends AppCompatActivity implements View.OnClickListener {
    Button button;
    EditText editnumber;
   database a;
    //a=new database (this );

    Button b_for_data;
    String num;

    EditText text;
    private static final int  MY_PERMISSIONS_REQUEST_SEND_SMS =1;


    private  void  checkforSmspermission ()
  {
      if (ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)
              != PackageManager.PERMISSION_GRANTED)
      {
          ActivityCompat.requestPermissions(this,
                  new String[] {Manifest.permission.SEND_SMS},1);

      }

  }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case MY_PERMISSIONS_REQUEST_SEND_SMS : {
                if(permissions[0].equalsIgnoreCase(Manifest.permission.SEND_SMS)) {


                }
                else {
                    Toast.makeText(this,"nai permission nai",Toast.LENGTH_LONG).show();
                }
            }

        }

    }

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massage);
        button=findViewById(R.id.send);
   // database a;
    a=new database (this );
    SQLiteDatabase c =a.getWritableDatabase();


        button.setOnClickListener(this);
    b_for_data=findViewById(R.id.add);

b_for_data.setOnClickListener(this);
editnumber =findViewById(R.id.addnewnumber);



    }

    @Override
    public void onClick(View v) {
      if(v.getId()==R.id.send)
      {
        text=findViewById(R.id.massage);

          Cursor res = a.getAllData();
          if(res.getCount() == 0) {
              // show message
              showmassage("my" , "hell");
              return;
          }

         // StringBuffer buffer = new StringBuffer();
          while (res.moveToNext()) {


              try {
                   num = res.getString(1);
                  num = '0' + num;

                  showmassage(""+num,"we are doing well");
              }
          catch(Exception e) {
                  showmassage("number is"+num, ""+e);
              }

              String massag =LocationListeningCallback.lastLocation.getLatitude()+" "+LocationListeningCallback.lastLocation.getLongitude() +text.getText().toString();
              String scAddress = null;
              PendingIntent sentIntent = null, deliveryIntent = null;
              checkforSmspermission();
              SmsManager smsManager = SmsManager.getDefault();
              try {
                  smsManager.sendTextMessage
                          (num, scAddress, massag,
                                  sentIntent, deliveryIntent);
                  showmassage("help seeking massage", "we are sending massage for help ");
              } catch (Exception e) {
                  showmassage("sms send fail", "sorry "+e);


              }
          }
      }
      if (v.getId()==R.id.add)
      {
boolean i;
       try {
           Toast.makeText(this,"we enter add imformation  ",Toast.LENGTH_LONG).show();
            i = a.insertData(editnumber.getText().toString());
           Toast.makeText(this,"we have done  add imformation  ",Toast.LENGTH_LONG).show();

       }
       catch (Exception e)
       {
           Toast.makeText(this,"we enter add imformation  "+e,Toast.LENGTH_LONG).show();
       }



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






