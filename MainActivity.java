package com.example.pro3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtV;
    EditText Password;
    EditText Name;
    Button changed;
    static String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtV = (TextView) findViewById(R.id.txtvSignUp);
        Password = (EditText) findViewById(R.id.passw);
        Name = (EditText) findViewById(R.id.name);
        changed = (Button) findViewById(R.id.change);

        txtV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                Intent it = new Intent(getApplicationContext(), signup.class);
                startActivity(it);
                finish();
            }
        });
    }

    public void log(View V) {
        EditText userName = (EditText) findViewById(R.id.name);
        EditText passInput = (EditText) findViewById(R.id.passw);
        user = userName.getText().toString();
        pass = passInput.getText().toString();
        SharedPreferences usrAccounts = getSharedPreferences("UsersAccounts", 0);
        if (!usrAccounts.contains(user)) {
            Toast.makeText(getApplicationContext(), "The user account is not existent", Toast.LENGTH_LONG).show();
            return;
        }
        if ((usrAccounts.getString(user, null)).equals(pass)) {
            Toast.makeText(getApplicationContext(), "The access is authenticated", Toast.LENGTH_LONG).show();
            Intent ho = new Intent(getApplicationContext(), home.class);
            startActivity(ho);
            finish();
        } else{
            Toast.makeText(getApplicationContext(), "The password entered is wrong", Toast.LENGTH_LONG).show();}

    }

}