package com.ashwin.android.parcelables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Student s = getIntent().getParcelableExtra("student");

        Log.d("parcelables", "NextActivity: " + s);

        TextView parcelableTextView = findViewById(R.id.parcelable_textview);
        parcelableTextView.setText(String.valueOf(s));
    }
}
