package com.example.pro3;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class insTsk extends AppCompatActivity {

    private EditText etPhone , etEmail , etCredit ;
    private MyDBHandler dbHandler;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ins_tsk);


        etPhone = (EditText) findViewById(R.id.edPhone);
        etEmail = (EditText) findViewById(R.id.edEmil);
        etCredit = (EditText) findViewById(R.id.edCredit);
        dbHandler = new MyDBHandler(getApplicationContext());
        db = dbHandler.getWritableDatabase();
    }

    public void addButtonClicked(View v){


        String phoneStr = etPhone.getText().toString();
        String emailStr = etEmail.getText().toString();
        String creditStr = etCredit.getText().toString();

        final int min = 20;
        final int max = 80;
        final int random = new Random().nextInt((max - min) + 1) + min;


        if (phoneStr.isEmpty() || emailStr.isEmpty()|| creditStr.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "PLease Fill missing data ", Toast.LENGTH_LONG).show();
            return;
        }


        db.execSQL("insert into "+ dbHandler.TABLE_NAME + "("+ dbHandler.COLUMN_PHONE + "," + dbHandler.COLUMN_CREDIT + "," + dbHandler.COLUMN_EMAIL + ") VALUES (?,?,?)", new String [] {phoneStr, emailStr, creditStr});


        String tstMsg ="Your account is inserted , " + " Your Locker number is " + random;
        Toast.makeText(getApplicationContext(), tstMsg, Toast.LENGTH_LONG).show();
        Intent i = new Intent (getApplicationContext(), home.class);
        startActivity(i);
        dbHandler.close();
        finish();

        // db.close();


        etPhone.setText("");
        etCredit.setText("");
        etEmail.setText("");


    }

    public void backTo(View v) {
        Intent i = new Intent (getApplicationContext(), home.class);
        startActivity(i);
        dbHandler.close();
        finish();
    }
}