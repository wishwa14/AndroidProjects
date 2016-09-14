package com.example.wishwa.service;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startservice(View view){
        Intent intent =new Intent(this,MyService.class);
        startService(intent);
    }
    public void stopservice(View view){
        Intent intent =new Intent(this,MyService.class);
        stopService(intent);
    }
}
