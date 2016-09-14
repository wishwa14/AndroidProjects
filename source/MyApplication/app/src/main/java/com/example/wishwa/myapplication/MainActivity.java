package com.example.wishwa.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView simpleList;
    String nameList[] = {"Wishwa", "Akila", "Dilushika", "Chamath", "Ashan", "Nimasha","Wishwa", "Akila", "Dilushika", "Chamath", "Ashan", "Nimasha"};
    int user[] = {R.drawable.wishwa, R.drawable.akila, R.drawable.akila, R.drawable.wishwa, R.drawable.akila, R.drawable.wishwa,R.drawable.wishwa, R.drawable.akila, R.drawable.akila, R.drawable.wishwa, R.drawable.akila, R.drawable.wishwa};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList = (ListView) findViewById(R.id.simpleListView);
        MyAdapter myAdapter = new MyAdapter(getApplicationContext(), nameList,user);
        simpleList.setAdapter(myAdapter);
    }
}