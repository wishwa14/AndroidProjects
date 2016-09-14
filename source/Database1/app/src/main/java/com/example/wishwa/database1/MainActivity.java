package com.example.wishwa.database1;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final Uri CONTENT_URL = Uri.parse("content://com.example.wishwa.database.ContactProvider/cpcontacts");
    TextView textView=null;

    ContentResolver resolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resolver = getContentResolver();

        textView =  (TextView)findViewById(R.id.textView);

        getContacts();
    }

    public void getContacts(){
        String[] projection = new String[]{"id","name"};
        Cursor cursor = resolver.query(CONTENT_URL,projection,null,null,null);
        String contactlist = "";

        if(cursor.moveToFirst()){
            do{
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                contactlist = contactlist + id + " : " + name + "\n";
            }while(cursor.moveToNext());

            textView.setText(contactlist);
        }

        else{
            Toast.makeText(this,"Contacts Empty",Toast.LENGTH_SHORT).show();
        }
    }

}
