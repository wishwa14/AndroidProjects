package com.example.wishwa.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Wishwa on 12/09/2016.
 */

public class AirplaneMode extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Airplane Mode Changed",Toast.LENGTH_SHORT).show();


    }
}
