package com.example.wishwa.handler;

import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText("Nice Job Wishwa");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickme(View view) {
        Runnable r =new Runnable() {
            @Override
            public void run() {
                long futuretime = System.currentTimeMillis() + 10000;
                while (System.currentTimeMillis() < futuretime) {
                    synchronized (this) {
                        try {
                            wait(futuretime - System.currentTimeMillis());
                        } catch (Exception e) {}
                    }
                }
                handler.sendEmptyMessage(0);
            }
        };
        Thread thread = new Thread(r);
        thread.start();
    }
}



































