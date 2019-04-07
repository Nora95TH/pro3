package com.example.pro3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class home extends AppCompatActivity {
    EditText etName, etPhone,etPass,etEmail,etCredit;
    MyDBHandler dbHandler;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // To read
        //etName = (EditText) findViewById(R.id.edName);
        etPhone = (EditText) findViewById(R.id.edPhone);
        //etPass = (EditText) findViewById(R.id.edPass);
        etEmail = (EditText) findViewById(R.id.edEmil);
        etCredit = (EditText) findViewById(R.id.edCredit);

        dbHandler = new MyDBHandler(this);
        db = dbHandler.getWritableDatabase();
    }


    /*public void insForm(View v){

        Intent i = new Intent (getApplicationContext(), insTsk.class);
        startActivity(i);
        dbHandler.close();
        finish();
    }*/


    /*public void delForm(View v){

        Intent i = new Intent (getApplicationContext(), delTsk.class);
        startActivity(i);
        dbHandler.close();
        finish();

    }*/


    public void btnShwDbData(View v)
    {
        // To store table info
        String dbData = "";

        String query = "SELECT * FROM "+ dbHandler.TABLE_NAME;

        Cursor c = db.rawQuery(query,null);

        c.moveToFirst();

        while(!c.isAfterLast())
        {
            dbData += c.getString(c.getColumnIndex(dbHandler.COLUMN_RECID));
            dbData += " | "+ c.getString(c.getColumnIndex(dbHandler.COLUMN_PHONE));
            dbData += " | "+ c.getString(c.getColumnIndex(dbHandler.COLUMN_EMAIL));
            dbData += " | "+ c.getString(c.getColumnIndex(dbHandler.COLUMN_CREDIT));
            dbData += "\n";

            c.moveToNext();
        }

        c.close();
        Toast.makeText(getApplicationContext(), dbData, Toast.LENGTH_LONG).show();

    }
    public void Exit(View v) {
        Intent i = new Intent (getApplicationContext(), MainActivity.class);
        startActivity(i);
        dbHandler.close();
        finish();
    }
}

