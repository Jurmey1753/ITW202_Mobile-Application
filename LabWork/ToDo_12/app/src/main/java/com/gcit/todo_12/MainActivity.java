package com.gcit.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void Donut(View view) {
        displayToast(getString(R.string.donut_order_message));
    }

    public void ice_cream(View view) {
        displayToast(getString(R.string.ice_cream_order_message));
    }

    public void froyo(View view) {
        displayToast(getString(R.string.froyo_order_message));
    }

    public void Call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+97517532757"));
        startActivity(intent);
    }
}