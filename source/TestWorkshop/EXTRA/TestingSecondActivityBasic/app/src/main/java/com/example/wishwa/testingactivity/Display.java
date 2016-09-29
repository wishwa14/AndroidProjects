package com.example.wishwa.testingactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Wishwa on 22/09/2016.
 */

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");

        TextView textView = (TextView)findViewById(R.id.textView2);
        textView.setText(message);

    }


}
