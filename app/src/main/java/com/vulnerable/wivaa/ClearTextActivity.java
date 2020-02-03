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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.ToggleButton;

import static maes.tech.intentanim.CustomIntent.customType;

public class ClearTextActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleartext);

        final ScrollView scrollcleartext = findViewById(R.id.scrollcleartext);
        final LinearLayout linearcleartext = findViewById(R.id.linearcleartext);
        final RelativeLayout cleartext_des= findViewById(R.id.cleartext_des);
        cleartext_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClearTextActivity.this,ClearTextDesActivity.class));
                customType(ClearTextActivity.this, "bottom-to-up");
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        myWebView = (WebView) findViewById(R.id.cleartext_webview);
        final WebSettings webSettings = myWebView.getSettings();
        myWebView.setWebChromeClient(new WebChromeClient());

        // setting up configuration for WebView
        webSettings.setJavaScriptEnabled(false);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);

        // URL navigate
        ImageView mWebviewButton = findViewById(R.id.cleartext_click);
        mWebviewButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText mWebviewURLView = (EditText) findViewById(R.id.url_cleartext);
                String url = mWebviewURLView.getText().toString();
                myWebView.loadUrl(url);
            }

        });

        ToggleButton toggleButton_cleartext = findViewById(R.id.toggleButton_cleartext);
        toggleButton_cleartext.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    scrollcleartext.setVisibility(View.GONE);
                    linearcleartext.setVisibility(View.VISIBLE);
                }
                else {
                    scrollcleartext.setVisibility(View.VISIBLE);
                    linearcleartext.setVisibility(View.GONE);
                }
            }
        });
    }
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(ClearTextActivity.this,"fadein-to-fadeout");
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(ClearTextActivity.this,"fadein-to-fadeout");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
