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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import static maes.tech.intentanim.CustomIntent.customType;

public class SharedPrefDesActivity extends AppCompatActivity {
    TextView shareddestitle, shareddes1, shareddes2, shareddes3, shareddes4, shareddes5, shareddes6, shareddes7, shareddes8, shareddes9;
    ImageView sharedattack_img1, sharedattack_img2 ,sharedattack_img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpref_des);

        shareddestitle = findViewById(R.id.shareddestitle);
        sharedattack_img1 = findViewById(R.id.sharedattack_img1);
        sharedattack_img2 = findViewById(R.id.sharedattack_img2);
        sharedattack_img3 = findViewById(R.id.sharedattack_img3);
        shareddes1 = findViewById(R.id.shareddes1);
        shareddes2 = findViewById(R.id.shareddes2);
        shareddes3 = findViewById(R.id.shareddes3);
        shareddes4 = findViewById(R.id.shareddes4);
        shareddes5 = findViewById(R.id.shareddes5);
        shareddes6 = findViewById(R.id.shareddes6);
        shareddes7 = findViewById(R.id.shareddes7);
        shareddes8 = findViewById(R.id.shareddes8);
        shareddes9 = findViewById(R.id.shareddes9);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        ToggleButton toggleButton_shared_des = (ToggleButton) findViewById(R.id.toggleButton_shared_des);
        toggleButton_shared_des.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    shareddestitle.setText(R.string.attack);
                    shareddes1.setText(R.string.sharedattackdes1);
                    sharedattack_img1.setVisibility(View.VISIBLE);
                    sharedattack_img2.setVisibility(View.VISIBLE);
                    sharedattack_img3.setVisibility(View.VISIBLE);
                    shareddes2.setVisibility(View.VISIBLE);
                    shareddes3.setVisibility(View.VISIBLE);
                    shareddes4.setVisibility(View.VISIBLE);
                    shareddes5.setVisibility(View.VISIBLE);
                    shareddes6.setVisibility(View.VISIBLE);
                    shareddes7.setVisibility(View.VISIBLE);
                    shareddes8.setVisibility(View.VISIBLE);
                    shareddes9.setVisibility(View.VISIBLE);
                }
                else {
                    shareddestitle.setText(R.string.des1);
                    shareddes1.setText(R.string.sharedDes);
                    sharedattack_img1.setVisibility(View.GONE);
                    sharedattack_img2.setVisibility(View.GONE);
                    sharedattack_img3.setVisibility(View.GONE);
                    shareddes2.setVisibility(View.GONE);
                    shareddes3.setVisibility(View.GONE);
                    shareddes4.setVisibility(View.GONE);
                    shareddes5.setVisibility(View.GONE);
                    shareddes6.setVisibility(View.GONE);
                    shareddes7.setVisibility(View.GONE);
                    shareddes8.setVisibility(View.GONE);
                    shareddes9.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, SharedPrefActivity.class));
        customType(SharedPrefDesActivity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, SharedPrefActivity.class));
                customType(SharedPrefDesActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
