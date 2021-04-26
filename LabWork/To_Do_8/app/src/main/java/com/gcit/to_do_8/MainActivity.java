package com.gcit.to_do_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText weditText, leditText, seditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weditText = findViewById(R.id.WeditText);
        leditText = findViewById(R.id.LeditText);
        seditText = findViewById(R.id.SeditText);
    }

    public void website(View view) {
        String msg = weditText.getText().toString();
        Uri uri = Uri.parse(msg);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("implicit intent", "Error message");
        }
    }

    public void location(View view) {
        String text = leditText.getText().toString();
        Uri url = Uri.parse("geo:0,0?q="+text);
        Intent intent = new Intent(Intent.ACTION_VIEW,url);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("implicit intent", "Error message");
        }
    }

    public void share(View view) {
        String message = seditText.getText().toString();
        String mimeType = "plain/text";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("share this text")
                .setText(message)
                .startChooser();

    }
}