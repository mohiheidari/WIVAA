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

public class InsecureLoggingDesActivity extends AppCompatActivity {

    TextView loggingdestitle, loggingdestv1,
            loggingdestv2, loggingdestv3,
            loggingdestv4, loggingdestv5,
            loggingdestv6, loggingdestv7;
    ImageView loggingattack_img1, loggingattack_img2, loggingattack_img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insecurelogging_des);

        loggingdestitle = findViewById(R.id.loggingdestitle);
        loggingdestv1 = findViewById(R.id.loggingdestv1);
        loggingdestv2 = findViewById(R.id.loggingdestv2);
        loggingdestv3 = findViewById(R.id.loggingdestv3);
        loggingdestv4 = findViewById(R.id.loggingdestv4);
        loggingdestv5 = findViewById(R.id.loggingdestv5);
        loggingdestv6 = findViewById(R.id.loggingdestv6);
        loggingdestv7 = findViewById(R.id.loggingdestv7);
        loggingattack_img1 = findViewById(R.id.loggingattack_img1);
        loggingattack_img2 = findViewById(R.id.loggingattack_img2);
        loggingattack_img3 = findViewById(R.id.loggingattack_img3);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));


        ToggleButton toggledes_logging = (ToggleButton) findViewById(R.id.toggleButton_logging_des);
        toggledes_logging.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    loggingdestitle.setText(getString(R.string.attack));
                    loggingdestv1.setText(R.string.loggingattackdes1);
                    loggingdestv2.setVisibility(View.VISIBLE);
                    loggingdestv3.setVisibility(View.VISIBLE);
                    loggingdestv4.setVisibility(View.VISIBLE);
                    loggingdestv5.setVisibility(View.VISIBLE);
                    loggingdestv6.setVisibility(View.VISIBLE);
                    loggingdestv7.setVisibility(View.VISIBLE);
                    loggingattack_img1.setVisibility(View.VISIBLE);
                    loggingattack_img2.setVisibility(View.VISIBLE);
                    loggingattack_img3.setVisibility(View.VISIBLE);
                }
                else {
                    loggingdestitle.setText(getString(R.string.des1));
                    loggingdestv1.setText(R.string.loggingDes);
                    loggingdestv2.setVisibility(View.GONE);
                    loggingdestv3.setVisibility(View.GONE);
                    loggingdestv4.setVisibility(View.GONE);
                    loggingdestv5.setVisibility(View.GONE);
                    loggingdestv6.setVisibility(View.GONE);
                    loggingdestv7.setVisibility(View.GONE);
                    loggingattack_img1.setVisibility(View.GONE);
                    loggingattack_img2.setVisibility(View.GONE);
                    loggingattack_img3.setVisibility(View.GONE);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, InsecureLoggingActivity.class));
        customType(InsecureLoggingDesActivity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, InsecureLoggingActivity.class));
                customType(InsecureLoggingDesActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
