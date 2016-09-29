package com.example.wishwa.loginfunction;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Wishwa on 27/09/2016.
 */

public class Display extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String username = getIntent().getStringExtra("Username");
        TextView t = (TextView)findViewById(R.id.welcome);
        t.setText("Welcome " + username);
    }
}
