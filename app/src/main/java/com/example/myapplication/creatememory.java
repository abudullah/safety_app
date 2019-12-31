package com.example.myapplication;

import java.util.ArrayList;

public class creatememory {
    ArrayList<Textdata> t;


   ArrayList<Textdata> createarraylist()
    {
        t=new ArrayList<Textdata>();


        return t;
    }



    public void getdata(String s)
    {   Textdata textdat;
        textdat=new Textdata(s);
        t.add(textdat);



    }

}
