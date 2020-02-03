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

public class FileDesActivity extends AppCompatActivity {

    ImageView fileattack_img1, fileattack_img2;
    TextView filedestv1, filedestv2,
            filedestv3, filedestv4,
            filedestitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_des);
        filedestv1 = findViewById(R.id.filedestv1);
        filedestv2 = findViewById(R.id.filedestv2);
        filedestv3 = findViewById(R.id.filedestv3);
        filedestv4 = findViewById(R.id.filedestv4);
        filedestitle = findViewById(R.id.filedestitle);
        fileattack_img1 = findViewById(R.id.fileattack_img1);
        fileattack_img2 = findViewById(R.id.fileattack_img2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        ToggleButton toggleButton_file_des = findViewById(R.id.toggleButton_file_des);
        toggleButton_file_des.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    filedestv1.setText(R.string.fileattacktv1);
                    filedestv2.setVisibility(View.VISIBLE);
                    filedestv3.setVisibility(View.VISIBLE);
                    filedestv4.setVisibility(View.VISIBLE);
                    fileattack_img1.setVisibility(View.VISIBLE);
                    fileattack_img2.setVisibility(View.VISIBLE);
                    filedestitle.setText(R.string.attack);
                }
                else {
                    filedestv1.setText(R.string.fileDes);
                    filedestv2.setVisibility(View.GONE);
                    filedestv3.setVisibility(View.GONE);
                    filedestv4.setVisibility(View.GONE);
                    fileattack_img1.setVisibility(View.GONE);
                    fileattack_img2.setVisibility(View.GONE);
                    filedestitle.setText(R.string.des1);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, FileActivity.class));
        customType(FileDesActivity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, FileActivity.class));
                customType(FileDesActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}



