package com.emptyfruits.com.eventlistenersandintents;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HelloWorldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        Toast.makeText(this, "Hello World !!", Toast.LENGTH_SHORT).show();
    }
}
