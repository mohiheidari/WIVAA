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

public class JniHardcodingDesActivity extends AppCompatActivity {

    TextView jnihardcodedestitle, jnihardcodedestv1,
            jnihardcodedestv2, jnihardcodedestv3,
            jnihardcodedestv4, jnihardcodedestv5,
            jnihardcodedestv6, jnihardcodedestv7,
            jnihardcodedestv8, jnihardcodedestv9;
    ImageView jnihardcodeattack_img1, jnihardcodeattack_img2,
            jnihardcodeattack_img3, jnihardcodeattack_img4,
            jnihardcodeattack_img5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jnihardcoding_des);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));


        jnihardcodedestitle = findViewById(R.id.jnihardcodedestitle);
        jnihardcodedestv1   = findViewById(R.id.jnihardcodedestv1);
        jnihardcodedestv2   = findViewById(R.id.jnihardcodedestv2);
        jnihardcodedestv3   = findViewById(R.id.jnihardcodedestv3);
        jnihardcodedestv4   = findViewById(R.id.jnihardcodedestv4);
        jnihardcodedestv5   = findViewById(R.id.jnihardcodedestv5);
        jnihardcodedestv6   = findViewById(R.id.jnihardcodedestv6);
        jnihardcodedestv7   = findViewById(R.id.jnihardcodedestv7);
        jnihardcodedestv8   = findViewById(R.id.jnihardcodedestv8);
        jnihardcodedestv9   = findViewById(R.id.jnihardcodedestv9);
        jnihardcodeattack_img1 = findViewById(R.id.jnihardcodeattack_img1);
        jnihardcodeattack_img2 = findViewById(R.id.jnihardcodeattack_img2);
        jnihardcodeattack_img3 = findViewById(R.id.jnihardcodeattack_img3);
        jnihardcodeattack_img4 = findViewById(R.id.jnihardcodeattack_img4);
        jnihardcodeattack_img5 = findViewById(R.id.jnihardcodeattack_img5);
        ToggleButton toggleButton_jnihardcode_des = findViewById(R.id.toggleButton_jnihardcode_des);
        toggleButton_jnihardcode_des.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    jnihardcodedestitle.setText(R.string.attack);
                    jnihardcodedestv1.setText(R.string.jnihardcodeattacktv1);
                    jnihardcodedestv2.setVisibility(View.VISIBLE);
                    jnihardcodedestv3.setVisibility(View.VISIBLE);
                    jnihardcodedestv4.setVisibility(View.VISIBLE);
                    jnihardcodedestv5.setVisibility(View.VISIBLE);
                    jnihardcodedestv6.setVisibility(View.VISIBLE);
                    jnihardcodedestv7.setVisibility(View.VISIBLE);
                    jnihardcodedestv8.setVisibility(View.VISIBLE);
                    jnihardcodedestv9.setVisibility(View.VISIBLE);
                    jnihardcodeattack_img1.setVisibility(View.VISIBLE);
                    jnihardcodeattack_img2.setVisibility(View.VISIBLE);
                    jnihardcodeattack_img3.setVisibility(View.VISIBLE);
                    jnihardcodeattack_img4.setVisibility(View.VISIBLE);
                    jnihardcodeattack_img5.setVisibility(View.VISIBLE);
                }
                else {
                    jnihardcodedestitle.setText(R.string.des1);
                    jnihardcodedestv1.setText(R.string.jnihardcodeDes);
                    jnihardcodedestv2.setVisibility(View.GONE);
                    jnihardcodedestv3.setVisibility(View.GONE);
                    jnihardcodedestv4.setVisibility(View.GONE);
                    jnihardcodedestv5.setVisibility(View.GONE);
                    jnihardcodedestv6.setVisibility(View.GONE);
                    jnihardcodedestv7.setVisibility(View.GONE);
                    jnihardcodedestv8.setVisibility(View.GONE);
                    jnihardcodedestv9.setVisibility(View.GONE);
                    jnihardcodeattack_img1.setVisibility(View.GONE);
                    jnihardcodeattack_img2.setVisibility(View.GONE);
                    jnihardcodeattack_img3.setVisibility(View.GONE);
                    jnihardcodeattack_img4.setVisibility(View.GONE);
                    jnihardcodeattack_img5.setVisibility(View.GONE);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, JniHardcodingActivity.class));
        customType(JniHardcodingDesActivity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, JniHardcodingActivity.class));
                customType(JniHardcodingDesActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}

