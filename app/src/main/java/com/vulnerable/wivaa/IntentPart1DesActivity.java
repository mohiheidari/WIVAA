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

public class IntentPart1DesActivity extends AppCompatActivity {
    ImageView intentp1attack_img1, intentp1attack_img2;
    TextView intentp1destitle, intentp1destv1,
            intentp1destv2, intentp1destv3,
            intentp1destv4, intentp1destv5,
            intentp1destv6, intentp1destv7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentpart1_des);

        intentp1destitle = findViewById(R.id.intentp1destitle);
        intentp1destv1   = findViewById(R.id.intentp1destv1);
        intentp1destv2   = findViewById(R.id.intentp1destv2);
        intentp1destv3   = findViewById(R.id.intentp1destv3);
        intentp1destv4   = findViewById(R.id.intentp1destv4);
        intentp1destv5   = findViewById(R.id.intentp1destv5);
        intentp1destv6   = findViewById(R.id.intentp1destv6);
        intentp1destv7   = findViewById(R.id.intentp1destv7);
        intentp1attack_img1 = findViewById(R.id.intentp1attack_img1);
        intentp1attack_img2 = findViewById(R.id.intentp1attack_img2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        ToggleButton toggleButton_intentp1_des = findViewById(R.id.toggleButton_intentp1_des);
        toggleButton_intentp1_des.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    intentp1destitle.setText(getString(R.string.attack));
                    intentp1destv1.setText(R.string.intentp1attacktv1);
                    intentp1attack_img1.setVisibility(View.VISIBLE);
                    intentp1attack_img2.setVisibility(View.VISIBLE);
                    intentp1destv2.setVisibility(View.VISIBLE);
                    intentp1destv3.setVisibility(View.VISIBLE);
                    intentp1destv4.setVisibility(View.VISIBLE);
                    intentp1destv5.setVisibility(View.VISIBLE);
                    intentp1destv6.setVisibility(View.VISIBLE);
                    intentp1destv7.setVisibility(View.VISIBLE);
                }
                else {
                    intentp1destitle.setText(getString(R.string.des1));
                    intentp1destv1.setText(R.string.accessDes);
                    intentp1attack_img1.setVisibility(View.GONE);
                    intentp1attack_img2.setVisibility(View.GONE);
                    intentp1destv2.setVisibility(View.GONE);
                    intentp1destv3.setVisibility(View.GONE);
                    intentp1destv4.setVisibility(View.GONE);
                    intentp1destv5.setVisibility(View.GONE);
                    intentp1destv6.setVisibility(View.GONE);
                    intentp1destv7.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, IntentPart1Activity.class));
        customType(IntentPart1DesActivity.this, "up-to-bottom");
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, IntentPart1Activity.class));
                customType(IntentPart1DesActivity.this, "up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
