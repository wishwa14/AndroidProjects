package com.example.wishwa.eventhandler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import junit.framework.TestResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView text = (TextView)findViewById(R.id.text);
                        text.setText("Hello  Wishwa");

                    }
                }
        );

        button.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        TextView text = (TextView)findViewById(R.id.text);
                        text.setText("A long Click");
                        return true;

                    }
                }
        );



    }
}
