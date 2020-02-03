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

public class JniBufferDesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jnibuffer_des);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        final TextView jnibufferdestitle = findViewById(R.id.jnibufferdestitle);
        final TextView jnibufferdestv1   = findViewById(R.id.jnibufferdestv1);
        final TextView jnibufferdestv2   = findViewById(R.id.jnibufferdestv2);
        final ImageView jnibufferattack_img1   = findViewById(R.id.jnibufferattack_img1);
        final ImageView jnibufferattack_img2   = findViewById(R.id.jnibufferattack_img2);
        ToggleButton toggleButton_jnibuffer_des = findViewById(R.id.toggleButton_jnibuffer_des);
        toggleButton_jnibuffer_des.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    jnibufferdestitle.setText(R.string.attack);
                    jnibufferdestv1.setText(R.string.jnibufferattacktv1);
                    jnibufferdestv2.setVisibility(View.VISIBLE);
                    jnibufferattack_img2.setVisibility(View.VISIBLE);
                    jnibufferattack_img1.setVisibility(View.VISIBLE);
                }
                else {
                    jnibufferdestitle.setText(R.string.des1);
                    jnibufferdestv1.setText(R.string.jnibufferDes);
                    jnibufferdestv2.setVisibility(View.GONE);
                    jnibufferattack_img2.setVisibility(View.GONE);
                    jnibufferattack_img1.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, JniBufferActivity.class));
        customType(JniBufferDesActivity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, JniBufferActivity.class));
                customType(JniBufferDesActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}

