package com.vulnerable.wivaa;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Debug;
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

import java.awt.font.TextAttribute;

import static maes.tech.intentanim.CustomIntent.customType;

public class DebugDesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug_des);

        final TextView debugdestv1 = findViewById(R.id.debugdestv1);
        final TextView debugdestv2 = findViewById(R.id.debugdestv2);
        final TextView debugdestv3 = findViewById(R.id.debugdestv3);
        final TextView debugdestv4 = findViewById(R.id.debugdestv4);
        final TextView debugdestv5 = findViewById(R.id.debugdestv5);
        final TextView debugdestv6 = findViewById(R.id.debugdestv6);
        final TextView debugdestv7 = findViewById(R.id.debugdestv7);
        final TextView debugdestv8 = findViewById(R.id.debugdestv8);
        final TextView debugdestv9 = findViewById(R.id.debugdestv9);
        final TextView debugdestv10 = findViewById(R.id.debugdestv10);
        final TextView debugdestv11 = findViewById(R.id.debugdestv11);
        final TextView debugdestv12 = findViewById(R.id.debugdestv12);
        final TextView debugdestv13 = findViewById(R.id.debugdestv13);
        final TextView debugdestv14 = findViewById(R.id.debugdestv14);
        final TextView debugdestv15 = findViewById(R.id.debugdestv15);
        final TextView debugdestv16 = findViewById(R.id.debugdestv16);
        final TextView debugdestv17 = findViewById(R.id.debugdestv17);
        final TextView debugdestv18 = findViewById(R.id.debugdestv18);
        final TextView debugdestv19 = findViewById(R.id.debugdestv19);
        final ImageView debugattack_img1 = findViewById(R.id.debugattack_img1);
        final ImageView debugattack_img2 = findViewById(R.id.debugattack_img2);
        final ImageView debugattack_img3 = findViewById(R.id.debugattack_img3);
        final ImageView debugattack_img4 = findViewById(R.id.debugattack_img4);
        final ImageView debugattack_img5 = findViewById(R.id.debugattack_img5);
        final ImageView debugattack_img6 = findViewById(R.id.debugattack_img6);
        final ImageView debugattack_img7 = findViewById(R.id.debugattack_img7);
        final ImageView debugattack_img8 = findViewById(R.id.debugattack_img8);
        final ImageView debugattack_img9 = findViewById(R.id.debugattack_img9);
        final ImageView debugattack_img10 = findViewById(R.id.debugattack_img10);
        final ImageView debugattack_img11 = findViewById(R.id.debugattack_img11);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        ToggleButton toggleButton_debug_des = findViewById(R.id.toggleButton_debug_des);
        toggleButton_debug_des.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    debugdestv1.setText(R.string.debugattacktv1);
                    debugdestv2.setVisibility(View.VISIBLE);
                    debugdestv3.setVisibility(View.VISIBLE);
                    debugdestv4.setVisibility(View.VISIBLE);
                    debugdestv5.setVisibility(View.VISIBLE);
                    debugdestv6.setVisibility(View.VISIBLE);
                    debugdestv7.setVisibility(View.VISIBLE);
                    debugdestv8.setVisibility(View.VISIBLE);
                    debugdestv9.setVisibility(View.VISIBLE);
                    debugdestv10.setVisibility(View.VISIBLE);
                    debugdestv11.setVisibility(View.VISIBLE);
                    debugdestv12.setVisibility(View.VISIBLE);
                    debugdestv13.setVisibility(View.VISIBLE);
                    debugdestv14.setVisibility(View.VISIBLE);
                    debugdestv15.setVisibility(View.VISIBLE);
                    debugdestv16.setVisibility(View.VISIBLE);
                    debugdestv17.setVisibility(View.VISIBLE);
                    debugdestv18.setVisibility(View.VISIBLE);
                    debugdestv19.setVisibility(View.VISIBLE);
                    debugattack_img1.setVisibility(View.VISIBLE);
                    debugattack_img2.setVisibility(View.VISIBLE);
                    debugattack_img3.setVisibility(View.VISIBLE);
                    debugattack_img4.setVisibility(View.VISIBLE);
                    debugattack_img5.setVisibility(View.VISIBLE);
                    debugattack_img6.setVisibility(View.VISIBLE);
                    debugattack_img7.setVisibility(View.VISIBLE);
                    debugattack_img8.setVisibility(View.VISIBLE);
                    debugattack_img9.setVisibility(View.VISIBLE);
                    debugattack_img10.setVisibility(View.VISIBLE);
                    debugattack_img11.setVisibility(View.VISIBLE);
                }
                else {
                    debugdestv1.setText(R.string.debugDes);
                    debugdestv2.setVisibility(View.GONE);
                    debugdestv3.setVisibility(View.GONE);
                    debugdestv4.setVisibility(View.GONE);
                    debugdestv5.setVisibility(View.GONE);
                    debugdestv6.setVisibility(View.GONE);
                    debugdestv7.setVisibility(View.GONE);
                    debugdestv8.setVisibility(View.GONE);
                    debugdestv9.setVisibility(View.GONE);
                    debugdestv10.setVisibility(View.GONE);
                    debugdestv11.setVisibility(View.GONE);
                    debugdestv12.setVisibility(View.GONE);
                    debugdestv13.setVisibility(View.GONE);
                    debugdestv14.setVisibility(View.GONE);
                    debugdestv15.setVisibility(View.GONE);
                    debugdestv16.setVisibility(View.GONE);
                    debugdestv17.setVisibility(View.GONE);
                    debugdestv18.setVisibility(View.GONE);
                    debugdestv19.setVisibility(View.GONE);
                    debugattack_img1.setVisibility(View.GONE);
                    debugattack_img2.setVisibility(View.GONE);
                    debugattack_img3.setVisibility(View.GONE);
                    debugattack_img4.setVisibility(View.GONE);
                    debugattack_img5.setVisibility(View.GONE);
                    debugattack_img6.setVisibility(View.GONE);
                    debugattack_img7.setVisibility(View.GONE);
                    debugattack_img8.setVisibility(View.GONE);
                    debugattack_img9.setVisibility(View.GONE);
                    debugattack_img10.setVisibility(View.GONE);
                    debugattack_img11.setVisibility(View.GONE);
                }
            }
        });
    }@Override
    public void onBackPressed() {
        startActivity(new Intent(this, DebugActivity.class));
        customType(DebugDesActivity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, DebugActivity.class));
                customType(DebugDesActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}



