package com.example.myapplication;

import android.content.Context;
import android.location.Location;
import android.support.v7.app.AlertDialog;

import com.mapbox.android.core.location.LocationEngineCallback;
import com.mapbox.android.core.location.LocationEngineResult;

import java.lang.ref.WeakReference;

public class LocationListeningCallback
        implements LocationEngineCallback<LocationEngineResult> {
    public static Location lastLocation;

    private final WeakReference<second> activityWeakReference;
    Context context;
    LocationListeningCallback(second activity) {

        this.activityWeakReference = new WeakReference<>(activity);
        context=activity;
    }

    @Override
    public void onSuccess(LocationEngineResult result) {

        // The LocationEngineCallback interface's method which fires when the device's location has changed.


        lastLocation = result.getLastLocation();


    }

    @Override
    public void onFailure( Exception exception) {

        // The LocationEngineCallback interface's method which fires when the device's location can not be captured
        show(" "," "+exception);


    }
    void show( String ti,String ma)
    {
        AlertDialog.Builder a = new AlertDialog.Builder(context);
        a.setTitle(ti);
        a.setMessage(ma);
        a.setCancelable(true);
        a.show();
    }
}
