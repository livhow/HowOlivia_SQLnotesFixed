package com.example.howo1606.mycontactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SearchActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Get the intent that started the activity
        android.content.Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Set the String in the textView, three

        android.widget.TextView textView = findViewById(R.id.textView3);

        textView.setText(message);
    }
}
