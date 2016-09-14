package com.example.wishwa.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {

            NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this)
                    .setAutoCancel(true);
            builder.setSmallIcon(R.drawable.wish);
            builder.setContentTitle("My Notification");
            builder.setContentText("This is my first Notification");
            Intent intent =new Intent(MainActivity.this,Notification.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
            stackBuilder.addParentStack(Notification.class);
            stackBuilder.addNextIntent(intent);
            PendingIntent pendingIntent = stackBuilder.getPendingIntent(new Random().nextInt(),PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);
            NotificationManager nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            Random random = new Random();
            int notficationId = random.nextInt(9999 - 1000) + 1000;
            nm.notify(notficationId,builder.build());

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void shownotification(View view){

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {long futuretime = System.currentTimeMillis() + 3000;
                            while (System.currentTimeMillis() < futuretime) {
                                synchronized (this) {
                                    try {
                                        wait(futuretime - System.currentTimeMillis());
                                    } catch (Exception e) {}
                                }
                            }
                            handler.sendEmptyMessage(0);
                        }
                    });

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }
}

