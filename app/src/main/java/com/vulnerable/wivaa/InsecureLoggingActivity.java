package com.vulnerable.wivaa;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
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
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import static maes.tech.intentanim.CustomIntent.customType;

public class InsecureLoggingActivity extends AppCompatActivity {
    RelativeLayout loggingdes;
    EditText loggingcart;
    Button insecureaccess;
    TextView loggingtv, loggingcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insecurelogging);


        loggingdes = findViewById(R.id.logging_des);
        loggingcart = findViewById(R.id.logging_cart);
        insecureaccess = findViewById(R.id.insecure_access);
        loggingtv = findViewById(R.id.loggingtv);
        loggingcode = findViewById(R.id.loggingcode);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        loggingdes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InsecureLoggingActivity.this, InsecureLoggingDesActivity.class));
                customType(InsecureLoggingActivity.this, "bottom-to-up");
            }
        });

        ToggleButton toggle_logging = (ToggleButton) findViewById(R.id.toggleButton_logging);
        toggle_logging.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    insecureaccess.setVisibility(View.GONE);
                    loggingcart.setVisibility(View.GONE);
                    loggingtv.setText(getString(R.string.loggingDesInsec));
                    Typeface regular = getResources().getFont(R.font.iransansregular);
                    loggingtv.setTypeface(regular);
                    loggingcode.setVisibility(View.VISIBLE);
                } else {
                    insecureaccess.setVisibility(View.VISIBLE);
                    loggingcart.setVisibility(View.VISIBLE);
                    loggingtv.setText(getString(R.string.insecureDesSec));
                    Typeface bold = getResources().getFont(R.font.iransansbold);
                    loggingtv.setTypeface(bold);
                    loggingcode.setVisibility(View.GONE);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(InsecureLoggingActivity.this, "fadein-to-fadeout");
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(InsecureLoggingActivity.this, "fadein-to-fadeout");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public void access(View view) {
        EditText logging_cart = findViewById(R.id.logging_cart);
        if (logging_cart.getText().toString().isEmpty()) {
            final AlertDialog.Builder alert = new AlertDialog.Builder(InsecureLoggingActivity.this);
            View alertView = getLayoutInflater().inflate(R.layout.dialog_poker_acess, null);
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
        } else {
            try {
                // Assuming we do some HTTP requests credit card validation and processing
                //Everything seems fine and then we hit some unforseen error
                process(logging_cart.getText().toString());
            } catch (RuntimeException re) {
                Log.e("wivaa-log", "خطا در هنگام تراکنش با کارت :" + logging_cart.getText().toString());
                final AlertDialog.Builder alert = new AlertDialog.Builder(InsecureLoggingActivity.this);
                View alertView = getLayoutInflater().inflate(R.layout.dialog_angry_error, null);
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
    private void process(String str) {
        // Do some important processing and throw if there is any error
        RuntimeException e = new RuntimeException();
        throw e;
    }
}
