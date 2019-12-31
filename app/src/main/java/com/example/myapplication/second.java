package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.location.LocationEngineProvider;
import com.mapbox.android.core.location.LocationEngineRequest;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;

import java.util.List;


public class second extends AppCompatActivity implements View.OnClickListener, PermissionsListener {
    Button massag,donatio,lesson,call;
    private final int MY_PERMISSIONS_REQUEST_CALL_PHONE=1;
  TelephonyManager telephonymanager;
  String num="999";
    PermissionsManager permissionsManager;
    public  LocationListeningCallback callback = new LocationListeningCallback(this);













    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        massag = findViewById(R.id.massage);
        massag.setOnClickListener(this);
        call =findViewById(R.id.call);
        call.setOnClickListener(this);

    lesson = findViewById(R.id.lesson);
    lesson.setOnClickListener(this);
    permission();
    }

    @Override
    public void onClick(View v) {

         if (v.getId()==R.id.massage)
        { permission();
            Intent inten = new Intent (second.this,massage.class);
            startActivity(inten);
        }
        else if (v.getId()==R.id.donation)
        {
            Intent intnt = new Intent (second.this,donation.class);
            startActivity(intnt);
        }
        else if (v.getId()==R.id.lesson)
        {
            Intent i ;
            i =new Intent(second.this,lesson.class);
            startActivity(i);

        }
        else if (v.getId()== R.id.call)
         {


             String Number = String.format("tel:%s",num);



                 Intent i = new Intent(Intent.ACTION_CALL);
                 i.setData(Uri.parse(Number));
                 startActivity(i);

             }


         }

    void showmassage (String title, String massage)
    {
        AlertDialog.Builder dialouge = new AlertDialog.Builder(this);
        dialouge.setTitle(title);
        dialouge.setMessage(massage);
        dialouge.show();

    }

    @SuppressWarnings("MissingPermission")
    void permission ()
    {
        if (PermissionsManager.areLocationPermissionsGranted(this)) {

            long DEFAULT_INTERVAL_IN_MILLISECONDS = 1000L;
            long DEFAULT_MAX_WAIT_TIME = DEFAULT_INTERVAL_IN_MILLISECONDS * 5;

            LocationEngine locationEngine = LocationEngineProvider.getBestLocationEngine(this);

            LocationEngineRequest request = new LocationEngineRequest.Builder(DEFAULT_INTERVAL_IN_MILLISECONDS)
                    .setPriority(LocationEngineRequest.PRIORITY_NO_POWER)
                    .setMaxWaitTime(DEFAULT_MAX_WAIT_TIME)
                    .build();

            locationEngine.requestLocationUpdates(request, callback, getMainLooper());
            locationEngine.getLastLocation(callback);

// Permission sensitive logic called here, such as activating the Maps SDK's LocationComponent to show the device's location


        } else {
            permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(this);
        }
    }

    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {

    }

    @Override
    public void onPermissionResult(boolean granted) {
        if (granted)
        {
            permission();
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
