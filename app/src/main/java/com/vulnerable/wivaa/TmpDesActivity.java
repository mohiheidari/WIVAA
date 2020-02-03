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

public class TmpDesActivity extends AppCompatActivity {
    ImageView tmpattack_img4, tmpattack_img3, tmpattack_img2, tmpattack_img1;
    TextView tmpdestitle, tmpdes8, tmpdes7, tmpdes6, tmpdes5, tmpdes4, tmpdes3, tmpdes2, tmpdes1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmp_des);

        tmpdestitle    = findViewById(R.id.tmpdestitle);
        tmpattack_img1 = findViewById(R.id.tmpattack_img1);
        tmpattack_img2 = findViewById(R.id.tmpattack_img2);
        tmpattack_img3 = findViewById(R.id.tmpattack_img3);
        tmpattack_img4 = findViewById(R.id.tmpattack_img4);
        tmpdes1 = findViewById(R.id.tmpdes1);
        tmpdes2 = findViewById(R.id.tmpdes2);
        tmpdes3 = findViewById(R.id.tmpdes3);
        tmpdes4 = findViewById(R.id.tmpdes4);
        tmpdes5 = findViewById(R.id.tmpdes5);
        tmpdes6 = findViewById(R.id.tmpdes6);
        tmpdes7 = findViewById(R.id.tmpdes7);
        tmpdes8 = findViewById(R.id.tmpdes8);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));


        ToggleButton toggleButton_tmp_des = findViewById(R.id.toggleButton_tmp_des);
        toggleButton_tmp_des.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tmpdestitle.setText(R.string.attack);
                    tmpdes1.setText(R.string.tmpattackdes1);
                    tmpdes2.setVisibility(View.VISIBLE);
                    tmpdes3.setVisibility(View.VISIBLE);
                    tmpdes4.setVisibility(View.VISIBLE);
                    tmpdes5.setVisibility(View.VISIBLE);
                    tmpdes6.setVisibility(View.VISIBLE);
                    tmpdes7.setVisibility(View.VISIBLE);
                    tmpdes8.setVisibility(View.VISIBLE);
                    tmpattack_img1.setVisibility(View.VISIBLE);
                    tmpattack_img2.setVisibility(View.VISIBLE);
                    tmpattack_img3.setVisibility(View.VISIBLE);
                    tmpattack_img4.setVisibility(View.VISIBLE);
                }
                else {
                    tmpdestitle.setText(R.string.des1);
                    tmpdes1.setText(R.string.tmpDes);
                    tmpdes2.setVisibility(View.GONE);
                    tmpdes3.setVisibility(View.GONE);
                    tmpdes4.setVisibility(View.GONE);
                    tmpdes5.setVisibility(View.GONE);
                    tmpdes6.setVisibility(View.GONE);
                    tmpdes7.setVisibility(View.GONE);
                    tmpdes8.setVisibility(View.GONE);
                    tmpattack_img1.setVisibility(View.GONE);
                    tmpattack_img2.setVisibility(View.GONE);
                    tmpattack_img3.setVisibility(View.GONE);
                    tmpattack_img4.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, TmpActivity.class));
        customType(TmpDesActivity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, TmpActivity.class));
                customType(TmpDesActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
