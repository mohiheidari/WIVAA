package com.vulnerable.wivaa;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static maes.tech.intentanim.CustomIntent.customType;

public class IntentPart2Activity extends AppCompatActivity {
    TextView intentp2_tv1;
    RadioGroup radio_intent2;
    Button intentp2_btn1;
    RelativeLayout intentp2des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentpart2);

        intentp2_tv1 =findViewById(R.id.intentp2_tv1);
        radio_intent2 = findViewById(R.id.radio_intent2);
        intentp2_btn1 = findViewById(R.id.intentp2_btn1);
        intentp2des  = findViewById(R.id.intentp2_des);
        intentp2des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntentPart2Activity.this,IntentPart2DesActivity.class));
                customType(IntentPart2Activity.this, "bottom-to-up");
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        ToggleButton toggleButton_intentp2 = findViewById(R.id.toggleButton_intentp2);
        toggleButton_intentp2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    intentp2_tv1.setVisibility(View.VISIBLE);
                    radio_intent2.setVisibility(View.GONE);
                    intentp2_btn1.setVisibility(View.GONE);
                }
                else {
                    intentp2_tv1.setVisibility(View.GONE);
                    radio_intent2.setVisibility(View.VISIBLE);
                    intentp2_btn1.setVisibility(View.VISIBLE);

                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(IntentPart2Activity.this,"fadein-to-fadeout");
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(IntentPart2Activity.this,"fadein-to-fadeout");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public void viewAPICredentials(View view) {
        //RadioButton rbalreadyreg = (RadioButton) findViewById(R.id.aci2rbalreadyreg);
        RadioButton rbregnow = (RadioButton) findViewById(R.id.radio1);
        Intent i = new Intent();
        boolean chk_pin = rbregnow.isChecked();

        // Calling implicit intent i.e. with app defined action instead of activity class
        i.setAction("com.vulnerable.wivaa.action.VIEW_CREDS2");
        i.putExtra(getString(R.string.chk_pin), chk_pin);
        // Check whether the intent resolves to an activity or not
        if (i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
            customType(IntentPart2Activity.this,"fadein-to-fadeout");
        }
        else {
            //alert
            Toast.makeText(this, "Error while getting Tveeter API details", Toast.LENGTH_SHORT).show();
            Log.e("aci1", "Couldn't resolve the Intent VIEW_CREDS2 to our activity");
        }
    }
}
