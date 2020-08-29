package com.bca.javascript;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class FinalPage extends AppCompatActivity {

    private Button close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google2);
        close = findViewById(R.id.end);
        WebView WebGo = findViewById(R.id.web);

        WebGo.loadUrl("about:blank");
        WebGo.loadUrl("https://www.google.com");


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent move3 = new Intent(FinalPage.this,MainActivity.class);
                startActivity(move3);
                finish();
            }
        });
    }
}
