package com.example.wishwa.broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendBroadcast(View view){
        Intent intent = new Intent();
        intent.setAction("android.intent.action.sendbroadcast");
        sendBroadcast(intent);
    }
}
