package com.gcit.todo_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
   // private static final String LOG_TAG =MainActivity.class.getSimpleName();
    public static final String EXTRA_REPLY = "com.gcit.todo_4.reply";
    private TextView textview;
    private EditText edittext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textview = findViewById(R.id.textView2);
        edittext = findViewById(R.id.MessageReply);

        Intent obj = getIntent();
        String msg = obj.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textview.setText(msg);
    }

    public void reply(View view) {
        String message = edittext.getText().toString();

        Intent Rintent = new Intent();
        Rintent.putExtra(EXTRA_REPLY, message);
        setResult(RESULT_OK, Rintent);
        finish();
    }
}