package com.vulnerable.wivaa;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
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

public class HardcodingDesActivity extends AppCompatActivity {
    TextView hcdestv1, hcdestv2, hcdestv3;
    TextView hcdestitle;
    ImageView hcattack_img1, hcattack_img2, hcattack_img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardcoding_des);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        hcdestitle = findViewById(R.id.hcdestitle);
        hcdestv1 = findViewById(R.id.hcdestv1);
        hcdestv2 = findViewById(R.id.hcdestv2);
        hcdestv3 = findViewById(R.id.hcdestv3);
        hcattack_img1 = findViewById(R.id.hcattack_img1);
        hcattack_img2 = findViewById(R.id.hcattack_img2);
        hcattack_img3 = findViewById(R.id.hcattack_img3);

        ToggleButton toggledes_hardcode = (ToggleButton) findViewById(R.id.toggleButton_hardcode_des);
        toggledes_hardcode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    hcdestitle.setText(getString(R.string.attack));
                    hcdestv1.setText(R.string.hcattackdes1);
                    hcattack_img1.setVisibility(View.VISIBLE);
                    hcattack_img2.setVisibility(View.VISIBLE);
                    hcattack_img3.setVisibility(View.VISIBLE);
                    hcdestv2.setVisibility(View.VISIBLE);
                    hcdestv3.setVisibility(View.VISIBLE);

                }else {
                    hcdestitle.setText(getString(R.string.des1));
                    hcdestv1.setText(R.string.hcDes);
                    hcattack_img1.setVisibility(View.GONE);
                    hcattack_img2.setVisibility(View.GONE);
                    hcattack_img3.setVisibility(View.GONE);
                    hcdestv2.setVisibility(View.GONE);
                    hcdestv3.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, HardcodingActivity.class));
        customType(HardcodingDesActivity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, HardcodingActivity.class));
                customType(HardcodingDesActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
