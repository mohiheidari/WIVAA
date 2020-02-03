package com.vulnerable.wivaa;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.os.Environment;
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

public class TxtActivity extends AppCompatActivity {
    RelativeLayout txt_des;
    EditText txtuser, txtpass;
    Button txtaccess;
    TextView txttv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txt);


        txtaccess = findViewById(R.id.txt_access);
        txtuser   = findViewById(R.id.txtuser);
        txtpass   = findViewById(R.id.txtpass);
        txt_des   = findViewById(R.id.txt_des);
        txttv     = findViewById(R.id.txttv);

        txt_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TxtActivity.this,TxtDesActivity.class));
                customType(TxtActivity.this,"bottom-to-up");
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        ToggleButton toggleButton_txt = findViewById(R.id.toggleButton_txt);
        toggleButton_txt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    txtaccess.setVisibility(View.GONE);
                    txtuser.setVisibility(View.GONE);
                    txtpass.setVisibility(View.GONE);
                    txttv.setText(R.string.txtDesInsec);
                    Typeface regular = getResources().getFont(R.font.iransansregular);
                    txttv.setTypeface(regular);
                }
                else {
                    txtaccess.setVisibility(View.VISIBLE);
                    txtuser.setVisibility(View.VISIBLE);
                    txtpass.setVisibility(View.VISIBLE);
                    txttv.setText(R.string.insecdsDesSec);
                    Typeface bold = getResources().getFont(R.font.iransansbold);
                    txttv.setTypeface(bold);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(TxtActivity.this,"fadein-to-fadeout");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(TxtActivity.this,"fadein-to-fadeout");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public void access(View view){

        File sdir = Environment.getExternalStorageDirectory();
        if (txtuser.getText().toString().isEmpty() || txtpass.getText().toString().isEmpty()){
            final AlertDialog.Builder alert = new AlertDialog.Builder(TxtActivity.this);
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
        else{
            try {
                File uinfo = new File(sdir.getAbsolutePath() + "/.uinfo.txt");
                uinfo.setReadable(true);
                uinfo.setWritable(true);
                FileWriter fw = new FileWriter(uinfo);
                fw.write(txtuser.getText().toString() + ":" + txtpass.getText().toString() + "\n");
                fw.close();
                // Now you can read the temporary file where ever the credentials are required.
                final AlertDialog.Builder alert = new AlertDialog.Builder(TxtActivity.this);
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
                final AlertDialog.Builder alert = new AlertDialog.Builder(TxtActivity.this);
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
                Log.d("Error!", "File error: " + e.getMessage());
            }
        }
    }
}
