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

public class SQLInjectionDesActivity extends AppCompatActivity {

    TextView sqldestitle,
            sqldestv1, sqldestv2,
            sqldestv3, sqldestv4,
            sqldestv5, sqldestv6;

    ImageView sqlattack_img1, sqlattack_img2,
              sqlattack_img3, sqlattack_img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlinjection_des);

        sqldestitle = findViewById(R.id.sqldestitle);
        sqldestv1   = findViewById(R.id.sqldestv1);
        sqldestv2   = findViewById(R.id.sqldestv2);
        sqldestv3   = findViewById(R.id.sqldestv3);
        sqldestv4   = findViewById(R.id.sqldestv4);
        sqldestv5   = findViewById(R.id.sqldestv5);
        sqldestv6   = findViewById(R.id.sqldestv6);
        sqlattack_img1 = findViewById(R.id.sqlattack_img1);
        sqlattack_img2 = findViewById(R.id.sqlattack_img2);
        sqlattack_img3 = findViewById(R.id.sqlattack_img3);
        sqlattack_img4 = findViewById(R.id.sqlattack_img4);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        ToggleButton toggleButton_sql_des = findViewById(R.id.toggleButton_sql_des);
        toggleButton_sql_des.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sqldestitle.setText(R.string.attack);
                    sqldestv1.setText(R.string.sqlattacktv1);
                    sqldestv2.setVisibility(View.VISIBLE);
                    sqldestv3.setVisibility(View.VISIBLE);
                    sqldestv4.setVisibility(View.VISIBLE);
                    sqldestv5.setVisibility(View.VISIBLE);
                    sqldestv6.setVisibility(View.VISIBLE);
                    sqlattack_img4.setVisibility(View.VISIBLE);
                    sqlattack_img3.setVisibility(View.VISIBLE);
                    sqlattack_img2.setVisibility(View.VISIBLE);
                    sqlattack_img1.setVisibility(View.VISIBLE);
                }
                else{
                    sqldestitle.setText(R.string.des1);
                    sqldestv1.setText(R.string.sqlDes);
                    sqldestv2.setVisibility(View.GONE);
                    sqldestv3.setVisibility(View.GONE);
                    sqldestv4.setVisibility(View.GONE);
                    sqldestv5.setVisibility(View.GONE);
                    sqldestv6.setVisibility(View.GONE);
                    sqlattack_img4.setVisibility(View.GONE);
                    sqlattack_img3.setVisibility(View.GONE);
                    sqlattack_img2.setVisibility(View.GONE);
                    sqlattack_img1.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, SQLInjectionActivity.class));
        customType(SQLInjectionDesActivity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, SQLInjectionActivity.class));
                customType(SQLInjectionDesActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
