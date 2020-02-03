package com.vulnerable.wivaa;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import static maes.tech.intentanim.CustomIntent.customType;

public class IntentPart1Activity extends AppCompatActivity {
    RelativeLayout intentp1des, intentp1_des;
    TextView intentp1_tv1;
    Button intentp1btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentpart1);

        intentp1btn1  = findViewById(R.id.intentp1_btn1);
        intentp1_tv1  = findViewById(R.id.intentp1_tv1);
        intentp1des   = findViewById(R.id.intentp1_des);
        intentp1des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntentPart1Activity.this,IntentPart1DesActivity.class));
                customType(IntentPart1Activity.this, "bottom-to-up");
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        ToggleButton toggleButton_intentp1 = findViewById(R.id.toggleButton_intentp1);
        toggleButton_intentp1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    intentp1btn1.setVisibility(View.GONE);
                    intentp1_tv1.setVisibility(View.VISIBLE);
                }
                else {
                    intentp1_tv1.setVisibility(View.GONE);
                    intentp1btn1.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    public void viewAPICredentials(View view) {
        // Calling implicit intent i.e. with app defined action instead of activity class
        Intent i = new Intent();
        i.setAction("com.vulnerable.wivaa.action.VIEW_CREDS");
        // Check whether the intent resolves to an activity or not
        if (i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
            customType(IntentPart1Activity.this,"fadein-to-fadeout");
        }
        else {
            final AlertDialog.Builder alert = new AlertDialog.Builder(IntentPart1Activity.this);
            View alertView= getLayoutInflater().inflate(R.layout.dialog_angry_access, null);
            //Set the view
            alert.setView(alertView);
            //Show alert
            final AlertDialog alertDialog = alert.show();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            //Toast.makeText(this, "دسترسی غیرمجاز است!! :<", Toast.LENGTH_SHORT).show();
            new CountDownTimer(2000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    // TODO Auto-generated method stub
                }
                @Override
                public void onFinish() {
                    // TODO Auto-generated method stub

                    alertDialog.dismiss();
                }
            }.start();
            //Toast.makeText(this, "Error while getting API details", Toast.LENGTH_SHORT).show();
            Log.e("aci1", "Couldn't resolve the Intent VIEW_CREDS to our activity");
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(IntentPart1Activity.this,"fadein-to-fadeout");
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(IntentPart1Activity.this,"fadein-to-fadeout");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
