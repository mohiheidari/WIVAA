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

public class IntentPart2DesActivity extends AppCompatActivity {
    TextView intentp2destitle, 
            intentp2destv1, intentp2destv2,
            intentp2destv3, intentp2destv4,
            intentp2destv5, intentp2destv6,
            intentp2destv7, intentp2destv8,
            intentp2destv9, intentp2destv10;
    ImageView intentp2attack_img1, intentp2attack_img2,
              intentp2attack_img3, intentp2attack_img4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentpart2_des);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        intentp2destitle = findViewById(R.id.intentp2destitle);
        intentp2destv1   = findViewById(R.id.intentp2destv1);
        intentp2destv2   = findViewById(R.id.intentp2destv2);
        intentp2destv3   = findViewById(R.id.intentp2destv3);
        intentp2destv4   = findViewById(R.id.intentp2destv4);
        intentp2destv5   = findViewById(R.id.intentp2destv5);
        intentp2destv6   = findViewById(R.id.intentp2destv6);
        intentp2destv7   = findViewById(R.id.intentp2destv7);
        intentp2destv8   = findViewById(R.id.intentp2destv8);
        intentp2destv9   = findViewById(R.id.intentp2destv9);
        intentp2destv10   = findViewById(R.id.intentp2destv10);
        intentp2attack_img1 = findViewById(R.id.intentp2attack_img1);
        intentp2attack_img2 = findViewById(R.id.intentp2attack_img2);
        intentp2attack_img3 = findViewById(R.id.intentp2attack_img3);
        intentp2attack_img4 = findViewById(R.id.intentp2attack_img4);

        ToggleButton toggleButton_intentp2_des = findViewById(R.id.toggleButton_intentp2_des);
        toggleButton_intentp2_des.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    intentp2destitle.setText(R.string.attack);
                    intentp2destv1.setText(R.string.intentp2attacktv1);
                    intentp2attack_img1.setVisibility(View.VISIBLE);
                    intentp2attack_img2.setVisibility(View.VISIBLE);
                    intentp2attack_img3.setVisibility(View.VISIBLE);
                    intentp2attack_img4.setVisibility(View.VISIBLE);
                    intentp2destv2.setVisibility(View.VISIBLE);
                    intentp2destv3.setVisibility(View.VISIBLE);
                    intentp2destv4.setVisibility(View.VISIBLE);
                    intentp2destv5.setVisibility(View.VISIBLE);
                    intentp2destv6.setVisibility(View.VISIBLE);
                    intentp2destv7.setVisibility(View.VISIBLE);
                    intentp2destv8.setVisibility(View.VISIBLE);
                    intentp2destv9.setVisibility(View.VISIBLE);
                    intentp2destv10.setVisibility(View.VISIBLE);
                }
                else {
                    intentp2destitle.setText(R.string.des1);
                    intentp2destv1.setText(R.string.accessDes);
                    intentp2attack_img1.setVisibility(View.GONE);
                    intentp2attack_img2.setVisibility(View.GONE);
                    intentp2attack_img3.setVisibility(View.GONE);
                    intentp2attack_img4.setVisibility(View.GONE);
                    intentp2destv2.setVisibility(View.GONE);
                    intentp2destv3.setVisibility(View.GONE);
                    intentp2destv4.setVisibility(View.GONE);
                    intentp2destv5.setVisibility(View.GONE);
                    intentp2destv6.setVisibility(View.GONE);
                    intentp2destv7.setVisibility(View.GONE);
                    intentp2destv8.setVisibility(View.GONE);
                    intentp2destv9.setVisibility(View.GONE);
                    intentp2destv10.setVisibility(View.GONE);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, IntentPart2Activity.class));
        customType(IntentPart2DesActivity.this, "up-to-bottom");
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, IntentPart2Activity.class));
                customType(IntentPart2DesActivity.this, "up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
