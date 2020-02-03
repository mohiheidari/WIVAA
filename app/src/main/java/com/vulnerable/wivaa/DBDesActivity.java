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

public class DBDesActivity extends AppCompatActivity {
    ImageView dbattack_img5, dbattack_img4, dbattack_img3, dbattack_img2, dbattack_img1;
    TextView dbdestitle, dbdes10, dbdes9, dbdes8, dbdes7, dbdes6, dbdes5, dbdes4, dbdes3, dbdes2, dbdes1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_des);
        
        dbdestitle    = findViewById(R.id.dbdestitle);
        dbattack_img1 = findViewById(R.id.dbattack_img1);
        dbattack_img2 = findViewById(R.id.dbattack_img2);
        dbattack_img3 = findViewById(R.id.dbattack_img3);
        dbattack_img4 = findViewById(R.id.dbattack_img4);
        dbattack_img5 = findViewById(R.id.dbattack_img5);
        dbdes1 = findViewById(R.id.dbdes1);
        dbdes2 = findViewById(R.id.dbdes2);
        dbdes3 = findViewById(R.id.dbdes3);
        dbdes4 = findViewById(R.id.dbdes4);
        dbdes5 = findViewById(R.id.dbdes5);
        dbdes6 = findViewById(R.id.dbdes6);
        dbdes7 = findViewById(R.id.dbdes7);
        dbdes8 = findViewById(R.id.dbdes8);
        dbdes9 = findViewById(R.id.dbdes9);
        dbdes10 = findViewById(R.id.dbdes10);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));


        ToggleButton toggleButton_db_des = findViewById(R.id.toggleButton_db_des);
        toggleButton_db_des.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    dbdestitle.setText(R.string.attack);
                    dbdes1.setText(R.string.dbattackdes1);
                    dbdes2.setVisibility(View.VISIBLE);
                    dbdes3.setVisibility(View.VISIBLE);
                    dbdes4.setVisibility(View.VISIBLE);
                    dbdes5.setVisibility(View.VISIBLE);
                    dbdes6.setVisibility(View.VISIBLE);
                    dbdes7.setVisibility(View.VISIBLE);
                    dbdes8.setVisibility(View.VISIBLE);
                    dbdes9.setVisibility(View.VISIBLE);
                    dbdes10.setVisibility(View.VISIBLE);
                    dbattack_img1.setVisibility(View.VISIBLE);
                    dbattack_img2.setVisibility(View.VISIBLE);
                    dbattack_img3.setVisibility(View.VISIBLE);
                    dbattack_img4.setVisibility(View.VISIBLE);
                    dbattack_img5.setVisibility(View.VISIBLE);
                }
                else {
                    dbdestitle.setText(R.string.des1);
                    dbdes1.setText(R.string.dbDes);
                    dbdes2.setVisibility(View.GONE);
                    dbdes3.setVisibility(View.GONE);
                    dbdes4.setVisibility(View.GONE);
                    dbdes5.setVisibility(View.GONE);
                    dbdes6.setVisibility(View.GONE);
                    dbdes7.setVisibility(View.GONE);
                    dbdes8.setVisibility(View.GONE);
                    dbdes9.setVisibility(View.GONE);
                    dbdes10.setVisibility(View.GONE);
                    dbattack_img1.setVisibility(View.GONE);
                    dbattack_img2.setVisibility(View.GONE);
                    dbattack_img3.setVisibility(View.GONE);
                    dbattack_img4.setVisibility(View.GONE);
                    dbattack_img5.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, DBActivity.class));
        customType(DBDesActivity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, DBActivity.class));
                customType(DBDesActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
