package com.vulnerable.wivaa;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.ToggleButton;

import static maes.tech.intentanim.CustomIntent.customType;

public class JavaScriptActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javascript);

        final LinearLayout linearjavascript = findViewById(R.id.linearjavascript);
        final ScrollView scrolljavascript = findViewById(R.id.scrolljavascript);
        final RelativeLayout javascript_des = findViewById(R.id.javascript_des);
        javascript_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JavaScriptActivity.this,JavaScriptDesActivity.class));
                customType(JavaScriptActivity.this, "bottom-to-up");
            }
        });
        myWebView = (WebView) findViewById(R.id.javascript_webview);
        WebSettings webSettings = myWebView.getSettings();
        myWebView.setWebChromeClient(new WebChromeClient());

        // setting up configuration for WebView
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);

        // URL navigate
        ImageView mWebviewButton = findViewById(R.id.javascript_click);
        mWebviewButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText mWebviewURLView = (EditText) findViewById(R.id.url_javascript);
                String url = mWebviewURLView.getText().toString();
                myWebView.loadUrl(url);
            }

        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        ToggleButton toggleButton_javascript = findViewById(R.id.toggleButton_javascript);
        toggleButton_javascript.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    linearjavascript.setVisibility(View.VISIBLE);
                    scrolljavascript.setVisibility(View.GONE);
                }
                else {
                    linearjavascript.setVisibility(View.GONE);
                    scrolljavascript.setVisibility(View.VISIBLE);

                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(JavaScriptActivity.this,"fadein-to-fadeout");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(JavaScriptActivity.this,"fadein-to-fadeout");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
