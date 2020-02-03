package com.vulnerable.wivaa;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
import android.widget.Toast;
import android.widget.ToggleButton;

import static maes.tech.intentanim.CustomIntent.customType;

public class ContentProviderActivity extends AppCompatActivity {

    TextView contentprovidertv, contentprovidercode;
    Button contentprovider_btn1;
    EditText contentproviderpass;
    RelativeLayout contentprovider_btn2, contentproviderdes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentprovider);

        contentprovidertv    = findViewById(R.id.contentprovidertv);
        contentprovidercode  = findViewById(R.id.contentprovidercode);
        contentproviderdes   = findViewById(R.id.contentprovider_des);
        contentprovider_btn1 = findViewById(R.id.contentprovider_btn1);
        contentproviderpass  = findViewById(R.id.contentproviderpass);
        contentprovider_btn2 = findViewById(R.id.contentprovider_btn2);
        contentproviderdes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContentProviderActivity.this,ContentProviderDesActivity.class));
                customType(ContentProviderActivity.this, "bottom-to-up");
            }
        });
        SharedPreferences spref = PreferenceManager.getDefaultSharedPreferences(this);
        String pin = spref.getString(getString(R.string.pkey), "");

        if (!pin.isEmpty()) {
           contentprovider_btn2.setVisibility(View.VISIBLE);
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));


        ToggleButton toggleButton_contentprovider = findViewById(R.id.toggleButton_contentprovider);
        toggleButton_contentprovider.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    contentprovider_btn1.setVisibility(View.GONE);
                    contentprovider_btn2.setVisibility(View.GONE);
                    contentproviderpass.setVisibility(View.GONE);
                    contentprovidertv.setVisibility(View.VISIBLE);
                    contentprovidercode.setVisibility(View.VISIBLE);
                }
                else {
                    contentprovider_btn1.setVisibility(View.VISIBLE);
                    contentprovider_btn2.setVisibility(View.VISIBLE);
                    contentproviderpass.setVisibility(View.VISIBLE);
                    contentprovidertv.setVisibility(View.GONE);
                    contentprovidercode.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(ContentProviderActivity.this,"fadein-to-fadeout");
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(ContentProviderActivity.this,"fadein-to-fadeout");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void addPass(View view) {
        SharedPreferences spref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor spedit = spref.edit();
        EditText pinTxt = (EditText) findViewById(R.id.contentproviderpass);
        String pin = pinTxt.getText().toString();

        if (pin == null || pin.isEmpty()) {
            final AlertDialog.Builder alert = new AlertDialog.Builder(ContentProviderActivity.this);
            View alertView= getLayoutInflater().inflate(R.layout.dialog_poker_acess, null);
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
        }
        else {
            RelativeLayout vbutton =  findViewById(R.id.contentprovider_btn2);
            spedit.putString(getString(R.string.pkey), pin);
            spedit.apply();
            if (vbutton.getVisibility() != View.VISIBLE) {
                vbutton.setVisibility(View.VISIBLE);
            }

            final AlertDialog.Builder alert = new AlertDialog.Builder(ContentProviderActivity.this);
            View alertView= getLayoutInflater().inflate(R.layout.dialog_happy_addpin, null);
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
            //Toast.makeText(this, "PIN Created successfully. Private notes are now protected with PIN", Toast.LENGTH_SHORT).show();
        }
    }
    public void goToNotes(View view) {
        Intent i = new Intent(this, ContentProviderNotesActivity.class);
        startActivity(i);
        customType(ContentProviderActivity.this,"right-to-left");
    }
}
