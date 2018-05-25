package com.example.howo1606.mycontactapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
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

    public void viewData(View view)
    {
        Cursor res =  myDb.getAllData();
        Log.d("MyContactApp", "MainActivity: received cursor");

        if(res.getCount() == 0)
        {
            showMessage("Error", "No data found in the database");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext())
        {
            //append the res column 0, 1, 2, 3 to the buffer - see StringBuffer and Cursor api's
            // Delimit each of the "appends" with line feed "\n"
            buffer.append("Name: " + res.getString(1));
            buffer.append("\nAddress: " + res.getString(2));
            buffer.append("\nPhone Number: " + res.getString(3));
            buffer.append("\n\n");
        }
        showMessage("Data", buffer.toString());
        Log.d("MyContact", buffer.toString());
    }

    private void showMessage(String title, String message)
    {
        Log.d("MyContactApp", "MainActivity:  showMessage: assembling AlertDialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}
