package com.gcit.todo_14_l;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.gcit.todo_14_l.extra.MESSAGE";
    private Toolbar toolbar;
    private String mOrderMessage;
    String list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void Donut(View view) {
        String donut = "You ordered a donut";
        list = donut;
        Toast.makeText(this, "You ordered donut", Toast.LENGTH_SHORT).show();
    }

    public void ice_cream(View view) {
        String ice_cream = "You ordered a donut";
        list = ice_cream;
        Toast.makeText(this, "You ordered Ice cream sandwiche", Toast.LENGTH_SHORT).show();
    }

    public void froyo(View view) {
        String froyo = "You ordered a donut";
        list = froyo;
        Toast.makeText(this, "You ordered froyo", Toast.LENGTH_SHORT).show();
    }

    public void post(View view) {
        Intent intent = new Intent(getApplicationContext(), Order.class);
        intent.putExtra("list", list);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.order:
                Intent intent = new Intent(this, Order.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
                return true;
            case R.id.status:
                Toast.makeText(this, "You selected status", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.favorite:
                Toast.makeText(this, "You selected favorite", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.contact:
                Toast.makeText(this, "You selected contact", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;

    }
}