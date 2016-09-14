package com.example.wishwa.database;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText contactNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactNameEditText = (EditText)findViewById(R.id.editText1);
    }
    public void addname(View view){
        String name = contactNameEditText.getText().toString();
        ContentValues values = new ContentValues();
        values.put(ContactProvider.name,name);
        Uri uri = getContentResolver().insert(ContactProvider.CONTENT_URL,values);
        Toast.makeText(getBaseContext(),"New Contact Added",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, test.class);
        startActivity(intent);
    }
}
