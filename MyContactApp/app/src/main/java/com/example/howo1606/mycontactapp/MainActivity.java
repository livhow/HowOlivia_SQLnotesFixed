package com.example.howo1606.mycontactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   DatabaseHelper myDb;
   EditText editName, editAddress, editPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editText_name);
        editAddress = findViewById(R.id.editText_address);
        editPhone = findViewById(R.id.editText_phone);

        myDb = new DatabaseHelper(this);
        Log.d("MyContactApp", "MainActivity:  instantiated myDb");
    }

    public void addData(View view)
    {
        Log.d("MyContactApp", "MainActivity:  Add Contact Button Pressed");

        boolean isInserted = myDb.insertData(editName.getText().toString(), editAddress.getText().toString(), editPhone.getText().toString());

        Log.d("MyContactApp", editName.getText().toString());
        Log.d("MyContactApp", editAddress.getText().toString());
        Log.d("MyContactApp", editPhone.getText().toString());

        if(isInserted)
        {
            Toast.makeText(MainActivity.this, "Contact Added - Success", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Contact Added - Failure", Toast.LENGTH_LONG).show();
        }
    }

}
