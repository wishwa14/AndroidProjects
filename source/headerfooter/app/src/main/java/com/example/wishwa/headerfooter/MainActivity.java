package com.example.wishwa.headerfooter;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ScrollView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScrollView scrollcontent = (ScrollView) findViewById(R.id.scrollcontent);
        getLayoutInflater().inflate(R.layout.content,scrollcontent);
    }

}
