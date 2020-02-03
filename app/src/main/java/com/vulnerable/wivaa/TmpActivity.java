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

import java.io.File;
import java.io.FileWriter;

import static maes.tech.intentanim.CustomIntent.customType;

public class TmpActivity extends AppCompatActivity {
    RelativeLayout tmp_des;
    EditText tmpuser, tmppass;
    Button tmpaccess;
    TextView tmptv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmp);

        tmpaccess = findViewById(R.id.tmp_access);
        tmpuser   = findViewById(R.id.tmpuser);
        tmppass   = findViewById(R.id.tmppass);
        tmp_des   = findViewById(R.id.tmp_des);
        tmptv     = findViewById(R.id.tmptv);

        tmp_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TmpActivity.this , TmpDesActivity.class));
                customType(TmpActivity.this,"bottom-to-up");
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        ToggleButton toggleButton_tmp = findViewById(R.id.toggleButton_tmp);
        toggleButton_tmp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                   tmpaccess.setVisibility(View.GONE);
                   tmppass.setVisibility(View.GONE);
                   tmpuser.setVisibility(View.GONE);
                   tmptv.setText(R.string.tmpDesInsec);
                    Typeface regular = getResources().getFont(R.font.iransansregular);
                    tmptv.setTypeface(regular);
                }
                else{
                    tmpaccess.setVisibility(View.VISIBLE);
                    tmppass.setVisibility(View.VISIBLE);
                    tmpuser.setVisibility(View.VISIBLE);
                    tmptv.setText(R.string.insecdsDesSec);
                    Typeface bold = getResources().getFont(R.font.iransansbold);
                    tmptv.setTypeface(bold);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(TmpActivity.this,"fadein-to-fadeout");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(TmpActivity.this,"fadein-to-fadeout");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public void access(View view){
        File ddir =  new File(getApplicationInfo().dataDir);
        if (tmpuser.getText().toString().isEmpty() || tmppass.getText().toString().isEmpty()){
            final AlertDialog.Builder alert = new AlertDialog.Builder(TmpActivity.this);
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
        else {
            try {
                File uinfo = File.createTempFile("uinfo", "tmp", ddir);
                uinfo.setReadable(true);
                uinfo.setWritable(true);
                FileWriter fw = new FileWriter(uinfo);
                fw.write(tmpuser.getText().toString() + ":" + tmppass.getText().toString() + "\n");
                fw.close();
                // Now you can read the temporary file where ever the credentials are required.
                final AlertDialog.Builder alert = new AlertDialog.Builder(TmpActivity.this);
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
            catch (Exception e) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(TmpActivity.this);
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
                }.start();Log.d("Error!", "File error: " + e.getMessage());
            }
        }
    }
}
