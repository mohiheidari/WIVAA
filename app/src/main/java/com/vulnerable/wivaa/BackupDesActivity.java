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

public class BackupDesActivity extends AppCompatActivity {

    TextView backupdestv1, backupdestv2, backupdestv3,
            backupdestv4,  backupdestv5,
            backupdestv6,  backupdestv7,
            backupdestv8,  backupdestv9,
            backupdestv10, backupdestv11;
    ImageView backupattack_img1, backupattack_img2,
            backupattack_img3, backupattack_img4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup_des);

        backupdestv1 = findViewById(R.id.backupdestv1);
        backupdestv2 = findViewById(R.id.backupdestv2);
        backupdestv3 = findViewById(R.id.backupdestv3);
        backupdestv4 = findViewById(R.id.backupdestv4);
        backupdestv5 = findViewById(R.id.backupdestv5);
        backupdestv6 = findViewById(R.id.backupdestv6);
        backupdestv7 = findViewById(R.id.backupdestv7);
        backupdestv8 = findViewById(R.id.backupdestv8);
        backupdestv9 = findViewById(R.id.backupdestv9);
        backupdestv10 = findViewById(R.id.backupdestv10);
        backupdestv11 = findViewById(R.id.backupdestv11);
        backupattack_img1 = findViewById(R.id.backupattack_img1);
        backupattack_img2 = findViewById(R.id.backupattack_img2);
        backupattack_img3 = findViewById(R.id.backupattack_img3);
        backupattack_img4 = findViewById(R.id.backupattack_img4);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));


        ToggleButton toggleButton_backup_des = findViewById(R.id.toggleButton_backup_des);
        toggleButton_backup_des.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    backupdestv1.setText(R.string.backupattacktv1);
                    backupdestv2.setVisibility(View.VISIBLE);
                    backupdestv3.setVisibility(View.VISIBLE);
                    backupdestv4.setVisibility(View.VISIBLE);
                    backupdestv5.setVisibility(View.VISIBLE);
                    backupdestv6.setVisibility(View.VISIBLE);
                    backupdestv7.setVisibility(View.VISIBLE);
                    backupdestv8.setVisibility(View.VISIBLE);
                    backupdestv9.setVisibility(View.VISIBLE);
                    backupdestv10.setVisibility(View.VISIBLE);
                    backupdestv11.setVisibility(View.VISIBLE);
                    backupattack_img1.setVisibility(View.VISIBLE);
                    backupattack_img2.setVisibility(View.VISIBLE);
                    backupattack_img3.setVisibility(View.VISIBLE);
                    backupattack_img4.setVisibility(View.VISIBLE);
                }
                else {
                    backupdestv1.setText(R.string.backupDes);
                    backupdestv2.setVisibility(View.GONE);
                    backupdestv3.setVisibility(View.GONE);
                    backupdestv4.setVisibility(View.GONE);
                    backupdestv5.setVisibility(View.GONE);
                    backupdestv6.setVisibility(View.GONE);
                    backupdestv7.setVisibility(View.GONE);
                    backupdestv8.setVisibility(View.GONE);
                    backupdestv9.setVisibility(View.GONE);
                    backupdestv10.setVisibility(View.GONE);
                    backupdestv11.setVisibility(View.GONE);
                    backupattack_img1.setVisibility(View.GONE);
                    backupattack_img2.setVisibility(View.GONE);
                    backupattack_img3.setVisibility(View.GONE);
                    backupattack_img4.setVisibility(View.GONE);

                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, BackupActivity.class));
        customType(BackupDesActivity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, BackupActivity.class));
                customType(BackupDesActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}


