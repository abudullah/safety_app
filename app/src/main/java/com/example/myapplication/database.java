package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class database extends SQLiteOpenHelper {
    Context context;

    public static final String DATABASE_NAME = "Stut.db";
    public static final String TABLE_NAME = "student_tabl";
    public static final String COL_1 = "ID";
   // public static final String COL_2 = "NAME";
    //public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "NUMBER";

    public database(Context context ) {

        super (context,"dg",null,1);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Toast.makeText(context,"I have reached oncreate ",Toast.LENGTH_LONG).show();
     try {

         db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NUMBER INTEGER)");
        // showMessage("created ", "we have");
         Toast.makeText(context,"I have reached exec",Toast.LENGTH_LONG).show();
     }
     catch(Exception e)
     {
        // showMessage("error","hell "+e);
        // Toast.makeText(context,"I have reached oncreate "+e,Toast.LENGTH_LONG).show();


     }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

    }
    public boolean insertData(String num) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_4,num);
       showMessage( contentValues.get(COL_4).toString(),"hell");
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public Integer deleteData (String num) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "num = ?", new String[]{num});
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
