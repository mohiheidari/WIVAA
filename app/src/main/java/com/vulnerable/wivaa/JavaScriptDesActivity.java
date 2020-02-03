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

public class JavaScriptDesActivity extends AppCompatActivity {

    TextView javascriptdestv1,javascriptdestv2,
            javascriptdestitle;
    ImageView javascriptattack_img1,javascriptattack_img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javascript_des);

        javascriptattack_img1 = findViewById(R.id.javascriptattack_img1);
        javascriptattack_img2 = findViewById(R.id.javascriptattack_img2);
        javascriptdestv1 = findViewById(R.id.javascriptdestv1);
        javascriptdestv2 = findViewById(R.id.javascriptdestv2);
        javascriptdestitle = findViewById(R.id.javascriptdestitle);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        ToggleButton toggleButton_javascript_des = findViewById(R.id.toggleButton_javascript_des);
        toggleButton_javascript_des.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    javascriptdestv1.setText(R.string.javascriptattacktv1);
                    javascriptdestv2.setVisibility(View.VISIBLE);
                    javascriptattack_img1.setVisibility(View.VISIBLE);
                    javascriptattack_img2.setVisibility(View.VISIBLE);
                    javascriptdestitle.setText(R.string.attack);
                }
                else {
                    javascriptdestv1.setText(R.string.javascriptDes);
                    javascriptdestv2.setVisibility(View.GONE);
                    javascriptattack_img1.setVisibility(View.GONE);
                    javascriptattack_img2.setVisibility(View.GONE);
                    javascriptdestitle.setText(R.string.des1);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, JavaScriptActivity.class));
        customType(JavaScriptDesActivity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, JavaScriptActivity.class));
                customType(JavaScriptDesActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}



