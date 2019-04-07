package com.example.pro3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class signup extends AppCompatActivity {

    SharedPreferences usrAccs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void signUp(View V){
        EditText usr = (EditText) findViewById(R.id.usrInp);
        EditText pwd = (EditText) findViewById(R.id.pwdInp);

        usrAccs = getApplicationContext().getSharedPreferences("UsersAccounts", 0); // 0 - for private mode
        SharedPreferences.Editor usrAccsEditor = usrAccs.edit();

        if(usrAccs.contains(usr.getText().toString())){
            Toast.makeText(getApplicationContext(),
                    "The user account is already existent",Toast.LENGTH_LONG).show();
            return;
        }

        usrAccsEditor.putString(usr.getText().toString(),pwd.getText().toString());
        usrAccsEditor.commit();

        Toast.makeText(getApplicationContext(),usr.getText().toString()+" account is created",Toast.LENGTH_LONG).show();

        Intent Int = new Intent(getApplicationContext(),insTsk.class);
        startActivity(Int);
        finish();

    }
    public void Next(View v) {
        Intent cha = new Intent(getApplicationContext(), home.class);
        startActivity(cha);
        finish();
    }


}



