package com.bca.javascript;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Button button;

    EditText url;
    TextView cek;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button1);
        url =(EditText) findViewById(R.id.url);
        cek =(TextView) findViewById(R.id.cek);






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.wtf("Error NULL",url.getText().toString());
                Intent page2 = new Intent(MainActivity.this, Page2.class);
                page2.putExtra("myUrl", url.getText().toString());
                startActivity(page2);
                cek.setText(url.getText().toString());


            }
        });

    }



}