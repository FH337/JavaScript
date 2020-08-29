package com.bca.javascript;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Page2 extends AppCompatActivity {

    String url;
    TextView txt;
    Button rfrsh;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_2);
        rfrsh = findViewById(R.id.refresh);
        url =  getIntent().getExtras().getString("myUrl");
       txt = (TextView) findViewById(R.id.cek2);
       txt.setText(url);

        WebView myWebView = findViewById(R.id.webView);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new Page2.WebAppInterface(Page2.this), "Android");
        myWebView.loadUrl("http://"+url);

        rfrsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView myWebView = findViewById(R.id.webView);
                myWebView.getSettings().setJavaScriptEnabled(true);
                myWebView.addJavascriptInterface(new Page2.WebAppInterface(Page2.this), "Android");
                myWebView.loadUrl("http://"+url);

            }
        });

    }


    public class WebAppInterface {

        Context mContext;


        // Instantiate the interface and set the context

        WebAppInterface(Context c) {
            mContext = c;
        }


        //Show a toast from the web page

        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface
        public void moveIntent() {

            Intent chnIntent = new Intent(Page2.this, Google.class);
            startActivity(chnIntent);

        }


    }

}


