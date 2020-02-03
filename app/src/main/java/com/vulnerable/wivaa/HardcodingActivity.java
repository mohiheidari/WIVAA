package com.vulnerable.wivaa;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import static maes.tech.intentanim.CustomIntent.customType;

public class HardcodingActivity extends AppCompatActivity {
    EditText hckey ;
    Button hcbtn ;
    TextView hctv ;
    RelativeLayout hcdes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardcoding);

        hckey = (EditText) findViewById(R.id.Key);
        hctv = (TextView) findViewById(R.id.hardcode_tv);
        hcbtn = (Button) findViewById(R.id.hardcode_access);
        hcdes = (RelativeLayout)findViewById(R.id.hc_des);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        ToggleButton toggle_hardcode = (ToggleButton) findViewById(R.id.toggleButton_hardcode);
        toggle_hardcode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    hckey.setVisibility(View.GONE);
                    hcbtn.setVisibility(View.GONE);
                    hctv.setText(getString(R.string.hcDesInsec));
                    Typeface regular = getResources().getFont(R.font.iransansregular);
                    hctv.setTypeface(regular);
                }else {
                    hckey.setVisibility(View.VISIBLE);
                    hcbtn.setVisibility(View.VISIBLE);
                    hctv.setText(getString(R.string.hardcodeDesSec));
                    Typeface bold = getResources().getFont(R.font.iransansbold);
                    hctv.setTypeface(bold);
                }
            }
        });


        hcdes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HardcodingActivity.this,HardcodingDesActivity.class));
                customType(HardcodingActivity.this,"bottom-to-up");
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(HardcodingActivity.this,"up-to-bottom");
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(HardcodingActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public void access(View view) {
        if (hckey.getText().toString().isEmpty()){
            final AlertDialog.Builder alert = new AlertDialog.Builder(HardcodingActivity.this);
            View alertView= getLayoutInflater().inflate(R.layout.dialog_poker_acess, null);
            //Set the view
            alert.setView(alertView);
            //Show alert
            final AlertDialog alertDialog = alert.show();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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
        }
        else if (hckey.getText().toString().equals("رمز عبور ناحیه کاربری")) {
            final AlertDialog.Builder alert = new AlertDialog.Builder(HardcodingActivity.this);
            View alertView= getLayoutInflater().inflate(R.layout.dialog_happy_access, null);
            //Set the view
            alert.setView(alertView);
            //Show alert
            final AlertDialog alertDialog = alert.show();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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
        }
        else {
            final AlertDialog.Builder alert = new AlertDialog.Builder(HardcodingActivity.this);
            View alertView= getLayoutInflater().inflate(R.layout.dialog_angry_access, null);
            //Set the view
            alert.setView(alertView);
            //Show alert
            final AlertDialog alertDialog = alert.show();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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
        }
    }
}

