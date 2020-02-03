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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import static maes.tech.intentanim.CustomIntent.customType;

public class ContentProviderDesActivity extends AppCompatActivity {

    TextView contentproviderdestitle,
            contentproviderdestv1, contentproviderdestv2,
            contentproviderdestv3, contentproviderdestv4,
            contentproviderdestv5,contentproviderdestv6, contentproviderdestv7;

    ImageView contentproviderattack_img1, contentproviderattack_img2, contentproviderattack_img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentprovider_des);

        contentproviderdestitle = findViewById(R.id.contentproviderdestitle);
        contentproviderdestv1   = findViewById(R.id.contentproviderdestv1);
        contentproviderdestv2   = findViewById(R.id.contentproviderdestv2);
        contentproviderdestv3   = findViewById(R.id.contentproviderdestv3);
        contentproviderdestv4   = findViewById(R.id.contentproviderdestv4);
        contentproviderdestv5   = findViewById(R.id.contentproviderdestv5);
        contentproviderdestv6   = findViewById(R.id.contentproviderdestv6);
        contentproviderdestv7   = findViewById(R.id.contentproviderdestv7);
        contentproviderattack_img2 = findViewById(R.id.contentproviderattack_img2);
        contentproviderattack_img1 = findViewById(R.id.contentproviderattack_img1);
        contentproviderattack_img3 = findViewById(R.id.contentproviderattack_img3);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        ToggleButton toggleButton_contentprovider_des = findViewById(R.id.toggleButton_contentprovider_des);
        toggleButton_contentprovider_des.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    contentproviderdestitle.setText(R.string.attack);
                    contentproviderdestv1.setText(R.string.contentproviderattacktv1);
                    contentproviderdestv2.setVisibility(View.VISIBLE);
                    contentproviderdestv3.setVisibility(View.VISIBLE);
                    contentproviderdestv4.setVisibility(View.VISIBLE);
                    contentproviderdestv5.setVisibility(View.VISIBLE);
                    contentproviderdestv6.setVisibility(View.VISIBLE);
                    contentproviderdestv7.setVisibility(View.VISIBLE);
                    contentproviderattack_img2.setVisibility(View.VISIBLE);
                    contentproviderattack_img1.setVisibility(View.VISIBLE);
                    contentproviderattack_img3.setVisibility(View.VISIBLE);
                }
                else{
                    contentproviderdestitle.setText(R.string.des1);
                    contentproviderdestv1.setText(R.string.accessDes);
                    contentproviderdestv2.setVisibility(View.GONE);
                    contentproviderdestv3.setVisibility(View.GONE);
                    contentproviderdestv4.setVisibility(View.GONE);
                    contentproviderdestv5.setVisibility(View.GONE);
                    contentproviderdestv6.setVisibility(View.GONE);
                    contentproviderdestv7.setVisibility(View.GONE);
                    contentproviderattack_img2.setVisibility(View.GONE);
                    contentproviderattack_img1.setVisibility(View.GONE);
                    contentproviderattack_img3.setVisibility(View.GONE);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentProviderActivity.class));
        customType(ContentProviderDesActivity.this, "up-to-bottom");
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentProviderActivity.class));
                customType(ContentProviderDesActivity.this, "up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
