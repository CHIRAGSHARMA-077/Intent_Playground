package com.example.intentplaygroudapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("This is the Intent Playground App.\nVersion: 1.0");
        tv.setTextSize(18);
        setContentView(tv);
    }
}

