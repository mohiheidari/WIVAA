package com.vulnerable.wivaa;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static maes.tech.intentanim.CustomIntent.customType;

public class DebugActivity extends AppCompatActivity {

    Button debugaccess;
    TextView debugtv, debugcode , debugtv2;
    RelativeLayout debug_des;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        debugcode   = findViewById(R.id.debugcode);
        debugtv     = findViewById(R.id.debugtv);
        debugaccess = (Button) findViewById(R.id.debug_access);
        debugtv2    = findViewById(R.id.debugtv_2);
        debug_des   = findViewById(R.id.debug_des);
        debugaccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text_debug =(TextView)findViewById(R.id.debugtv);
                Toast.makeText(DebugActivity.this, "Crack me App For Debugging", Toast.LENGTH_SHORT).show();
                String secret = "دوباره تلاش کنید!";
                text_debug.setText(secret);
            }
        });
        debug_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DebugActivity.this,DebugDesActivity.class));
                customType(DebugActivity.this, "bottom-to-up");
            }
        });
        ToggleButton toggleButton_debug = findViewById(R.id.toggleButton_debug);
        toggleButton_debug.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    debugaccess.setVisibility(View.GONE);
                    debugtv.setVisibility(View.GONE);
                    debugcode.setVisibility(View.VISIBLE);
                    debugtv2.setVisibility(View.VISIBLE);
                }
                else{
                    debugaccess.setVisibility(View.VISIBLE);
                    debugtv2.setVisibility(View.GONE);
                    debugtv.setVisibility(View.VISIBLE);
                    debugcode.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(DebugActivity.this,"fadein-to-fadeout");
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(DebugActivity.this,"fadein-to-fadeout");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
