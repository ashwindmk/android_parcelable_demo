package com.ashwin.android.parcelables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void next(View view) {
        Address a = new Address("Mumbai", "Maha");
        Student s = new Student(1, "Ashwin", 26, 8.45, false, a, new int[]{1, 2, 3});
        Intent intent = new Intent(this, NextActivity.class);
        intent.putExtra("student", s);

        startActivity(intent);
    }
}