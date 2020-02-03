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

public class TxtDesActivity extends AppCompatActivity {
    ImageView txtattack_img4, txtattack_img3, txtattack_img2, txtattack_img1;
    TextView txtdestitle, txtdes10, txtdes9, txtdes8, txtdes7, txtdes6, txtdes5, txtdes4, txtdes3, txtdes2, txtdes1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txt_des);
        txtdestitle = findViewById(R.id.txtdestitle);
        txtattack_img1 = findViewById(R.id.txtattack_img1);
        txtattack_img2 = findViewById(R.id.txtattack_img2);
        txtattack_img3 = findViewById(R.id.txtattack_img3);
        txtattack_img4 = findViewById(R.id.txtattack_img4);
        txtdes1  = findViewById(R.id.txtdes1);
        txtdes2  = findViewById(R.id.txtdes2);
        txtdes3  = findViewById(R.id.txtdes3);
        txtdes4  = findViewById(R.id.txtdes4);
        txtdes5  = findViewById(R.id.txtdes5);
        txtdes6  = findViewById(R.id.txtdes6);
        txtdes7  = findViewById(R.id.txtdes7);
        txtdes8  = findViewById(R.id.txtdes8);
        txtdes9  = findViewById(R.id.txtdes9);
        txtdes10 = findViewById(R.id.txtdes10);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        ToggleButton toggleButton_txt_des = findViewById(R.id.toggleButton_txt_des);
        toggleButton_txt_des.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    txtdestitle.setText(R.string.attack);
                    txtdes1.setText(R.string.txtattackdes1);
                    txtdes2.setVisibility(View.VISIBLE);
                    txtdes3.setVisibility(View.VISIBLE);
                    txtdes4.setVisibility(View.VISIBLE);
                    txtdes5.setVisibility(View.VISIBLE);
                    txtdes6.setVisibility(View.VISIBLE);
                    txtdes7.setVisibility(View.VISIBLE);
                    txtdes8.setVisibility(View.VISIBLE);
                    txtdes9.setVisibility(View.VISIBLE);
                    txtdes10.setVisibility(View.VISIBLE);
                    txtattack_img1.setVisibility(View.VISIBLE);
                    txtattack_img2.setVisibility(View.VISIBLE);
                    txtattack_img3.setVisibility(View.VISIBLE);
                    txtattack_img4.setVisibility(View.VISIBLE);
                }
                else {
                    txtdestitle.setText(R.string.des1);
                    txtdes1.setText(R.string.txtDes);
                    txtdes2.setVisibility(View.GONE);
                    txtdes3.setVisibility(View.GONE);
                    txtdes4.setVisibility(View.GONE);
                    txtdes5.setVisibility(View.GONE);
                    txtdes6.setVisibility(View.GONE);
                    txtdes7.setVisibility(View.GONE);
                    txtdes8.setVisibility(View.GONE);
                    txtdes9.setVisibility(View.GONE);
                    txtdes10.setVisibility(View.GONE);
                    txtattack_img1.setVisibility(View.GONE);
                    txtattack_img2.setVisibility(View.GONE);
                    txtattack_img3.setVisibility(View.GONE);
                    txtattack_img4.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, TxtActivity.class));
        customType(TxtDesActivity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, TxtActivity.class));
                customType(TxtDesActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
