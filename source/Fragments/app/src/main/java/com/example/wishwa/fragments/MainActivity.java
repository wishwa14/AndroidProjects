package com.example.wishwa.fragments;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity implements TopSection.Topsectionlistener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void creatememe(String top, String bottom) {
        BottomSection bottomf = (BottomSection)getSupportFragmentManager().findFragmentById(R.id.fragment4);
        bottomf.setmemetext(top, bottom);

    }
}
