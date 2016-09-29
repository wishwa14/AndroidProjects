package com.example.wishwa.logininterface;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = (EditText)findViewById(R.id.username);
        etPassword = (EditText)findViewById(R.id.passwrd);

    }

    public void clickButton(View view){
        String username = String.valueOf(etUsername.getText());
        String password = String.valueOf(etPassword.getText());
        boolean error = false;

        if(username.isEmpty() && password.isEmpty()){
            error = true;
            dialogBox("Username and Password Empty");
        }

        else if(username.isEmpty()){
            error = true;
            dialogBox("Username is Empty");
        }

        else if (password.isEmpty()){
            error = true;
            dialogBox("Password is Empty");
        }
        if(!error){
            validateUser(username,password);
        }
    }

    public void validateUser(String username,String password) {
        if ((username.equals("Wishwa") && password.equals("123"))) {
            Intent i = new Intent(MainActivity.this,Display.class);
            i.putExtra("Username",username);
            startActivity(i);

        }
        else{
            etUsername.setText("");
            etPassword.setText("");
            dialogBox("Wrong Username or Password");
        }
    }

    public void hideSoftKeyboard(View view) {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void dialogBox(String message){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.cancel();

            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
