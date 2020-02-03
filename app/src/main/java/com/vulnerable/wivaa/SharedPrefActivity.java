package com.vulnerable.wivaa;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class SharedPrefActivity extends AppCompatActivity {
    RelativeLayout sharedpref_des;
    Button sharedaccess;
    EditText shareduser,sharedpass;
    TextView sharedtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpref);

        sharedpass = findViewById(R.id.sharedpass);
        shareduser = findViewById(R.id.shareduser);
        sharedaccess = findViewById(R.id.shared_access);
        sharedtv = findViewById(R.id.sharedtv);

        sharedpref_des = findViewById(R.id.sharedpref_des);
        sharedpref_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SharedPrefActivity.this,SharedPrefDesActivity.class));
                customType(SharedPrefActivity.this,"bottom-to-up");
            }
        });

        ToggleButton toggleButton_sharedpref = (ToggleButton) findViewById(R.id.toggleButton_sharedpref);
        toggleButton_sharedpref.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    shareduser.setVisibility(View.GONE);
                    sharedpass.setVisibility(View.GONE);
                    sharedaccess.setVisibility(View.GONE);
                    sharedtv.setText(R.string.sharedDesInsec);
                    Typeface regular = getResources().getFont(R.font.iransansregular);
                    sharedtv.setTypeface(regular);
                }
                else{
                    sharedpass.setVisibility(View.VISIBLE);
                    shareduser.setVisibility(View.VISIBLE);
                    sharedaccess.setVisibility(View.VISIBLE);
                    sharedtv.setText(R.string.insecdsDesSec);
                    Typeface bold = getResources().getFont(R.font.iransansbold);
                    sharedtv.setTypeface(bold);
                }
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(SharedPrefActivity.this,"fadein-to-fadeout");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(SharedPrefActivity.this,"fadein-to-fadeout");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public void access(View view) {
        if (shareduser.getText().toString().isEmpty() || sharedpass.getText().toString().isEmpty()) {
            final AlertDialog.Builder alert = new AlertDialog.Builder(SharedPrefActivity.this);
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
        }
        else {
            SharedPreferences spref = PreferenceManager.getDefaultSharedPreferences(SharedPrefActivity.this);
            SharedPreferences.Editor spedit = spref.edit();

            spedit.putString("user", shareduser.getText().toString());
            spedit.putString("password", sharedpass.getText().toString());
            spedit.apply();

            final AlertDialog.Builder alert = new AlertDialog.Builder(SharedPrefActivity.this);
            View alertView = getLayoutInflater().inflate(R.layout.dialog_happy_access, null);
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
