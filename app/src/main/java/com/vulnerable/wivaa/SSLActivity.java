package com.vulnerable.wivaa;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.http.SslError;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.ToggleButton;

import static maes.tech.intentanim.CustomIntent.customType;

public class SSLActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssl);

        final ScrollView scrollssl = findViewById(R.id.scrollssl);
        final LinearLayout linearssl = findViewById(R.id.linearssl);
        final RelativeLayout ssl_des= findViewById(R.id.ssl_des);
        ssl_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SSLActivity.this,SSLDesActivity.class));
                customType(SSLActivity.this, "bottom-to-up");
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));


        myWebView = (WebView) findViewById(R.id.ssl_webview);
        //myWebView.loadUrl("http://http-login.badssl.com/");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        // URL navigate
        ImageView mWebviewButton = findViewById(R.id.ssl_click);
        mWebviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText mWebviewURLView = (EditText) findViewById(R.id.url_ssl);
                String url = mWebviewURLView.getText().toString();
                myWebView.loadUrl("https://self-signed.badssl.com/");
                myWebView.setWebViewClient(new WebViewClient() {
                    @Override
                    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                        handler.proceed();
                    }
                });
            }
        });

        ToggleButton toggleButton_ssl = findViewById(R.id.toggleButton_ssl);
        toggleButton_ssl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    scrollssl.setVisibility(View.GONE);
                    linearssl.setVisibility(View.VISIBLE);
                }
                else {
                    scrollssl.setVisibility(View.VISIBLE);
                    linearssl.setVisibility(View.GONE);
                }
            }
        });
    }
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(SSLActivity.this,"fadein-to-fadeout");
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(SSLActivity.this,"fadein-to-fadeout");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
