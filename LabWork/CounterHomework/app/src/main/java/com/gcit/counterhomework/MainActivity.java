package com.gcit.counterhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView textview;
    private int Count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = findViewById(R.id.textView);

        if (savedInstanceState != null){
            Count = savedInstanceState.getInt("mcount");
            textview.setText(String.valueOf(Count));
        }
    }

    public void count(View view) {
        Count++;
        textview.setText(String.valueOf(Count));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle data) {
        super.onRestoreInstanceState(data);

       data.putInt("mcount",Count);
    }
}