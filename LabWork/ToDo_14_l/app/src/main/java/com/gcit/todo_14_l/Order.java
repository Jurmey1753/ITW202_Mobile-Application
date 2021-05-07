package com.gcit.todo_14_l;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Order extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    RadioButton sameday,nextday,pickup;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        sameday = findViewById(R.id.same_day);
        nextday = findViewById(R.id.next_day);
        pickup = findViewById(R.id.pick_up);
        tv =  findViewById(R.id.textView7);
        Spinner spinner = findViewById(R.id.spinner);

        Intent intent = getIntent();
        String message =intent.getStringExtra("list");
        tv.setText(message);


        if (spinner != null){
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.labels_array, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null){
            spinner.setAdapter(arrayAdapter);
        }
    }

    public void SelectRadioButton(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.same_day:
                displayToast("Same day messenger service");
                break;

            case R.id.next_day:
                displayToast("Next day ground delivery");
                break;

            case R.id.pick_up:
                displayToast("Pick Up");
                break;
            default:
                break;

        }
    }
    private void displayToast(String pickup){
        Toast.makeText(getApplicationContext(),pickup,Toast.LENGTH_LONG).show();
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String msg = parent.getItemAtPosition(position).toString();
        displayToast(msg);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}