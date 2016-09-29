package com.example.wishwa.testingactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
    }

    public void click(View view){
        Intent intent = new Intent(this,Display.class);
        String message = editText.getText().toString();
        intent.putExtra("message", message);
        startActivity(intent);

    }
}
