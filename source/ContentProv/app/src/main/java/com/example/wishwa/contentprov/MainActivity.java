package com.example.wishwa.contentprov;

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

    static final Uri CONTENT_URL = Uri.parse("content://com.example.wishwa.contentprov.ContactProvider/cpcontacts");
    TextView textView=null;
    EditText deletetext,findtext,addtext;

    ContentResolver resolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resolver = getContentResolver();

        textView =  (TextView)findViewById(R.id.contactsTextView);
        deletetext=(EditText)findViewById(R.id.deletetext);
        findtext=(EditText)findViewById(R.id.findtext);
        addtext=(EditText)findViewById(R.id.addtext);


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

    public void showcontact(View view){
        getContacts();
    }

    public void deletecontact(View view){
        String iddelete = deletetext.getText().toString();
        long idDel = resolver.delete(CONTENT_URL,"id = ?",new String[]{iddelete});
        getContacts();
    }

    public void findcontact(View view){
        String idfind = findtext.getText().toString();
        String[] proj = {"id","name"};
        Cursor cursor = resolver.query(CONTENT_URL,proj,"id = ?",new String[]{idfind},null);

        String contact ="";
        if(cursor.moveToFirst()){
            do{
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                contact = contact + id + ":" + name + "\n";
            }while(cursor.moveToNext());

            textView.setText(contact);
        }
        else{
            Toast.makeText(this,"Contact Not Found",Toast.LENGTH_SHORT).show();
        }
    }

    public void addcontact(View view){
        String addname = addtext.getText().toString();
        ContentValues values = new ContentValues();
        values.put("name",addname);
        resolver.insert(CONTENT_URL,values);
        getContacts();
        addtext.setText("");
    }

}
