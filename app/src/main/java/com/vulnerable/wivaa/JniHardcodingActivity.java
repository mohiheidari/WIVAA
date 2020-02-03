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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import static maes.tech.intentanim.CustomIntent.customType;

public class JniHardcodingActivity extends AppCompatActivity {

    private VulJni vjni;
    TextView jnihardcode_tv;
    EditText jnihardcode_Key;
    Button jnihardcodeaccess;
    RelativeLayout jnihcdes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jnihardcoding);
        vjni = new VulJni();

        jnihardcode_tv    = findViewById(R.id.jnihardcode_tv);
        jnihardcodeaccess = findViewById(R.id.jnihardcode_access);
        jnihardcode_Key   = findViewById(R.id.jnihardcode_Key);
        jnihcdes         = findViewById(R.id.jnihardcode_des);
        jnihcdes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JniHardcodingActivity.this,JniHardcodingDesActivity.class));
                customType(JniHardcodingActivity.this, "bottom-to-up");
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        ToggleButton toggleButton_jnihardcode = findViewById(R.id.toggleButton_jnihardcode);
        toggleButton_jnihardcode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    jnihardcode_Key.setVisibility(View.GONE);
                    jnihardcodeaccess.setVisibility(View.GONE);
                    jnihardcode_tv.setText(R.string.jnihardcodeDesInsec);
                    Typeface regular = getResources().getFont(R.font.iransansregular);
                    jnihardcode_tv.setTypeface(regular);
                }
                else{
                    jnihardcode_Key.setVisibility(View.VISIBLE);
                    jnihardcodeaccess.setVisibility(View.VISIBLE);
                    jnihardcode_tv.setText(R.string.jniDesSec);
                    Typeface regular = getResources().getFont(R.font.iransansbold);
                    jnihardcode_tv.setTypeface(regular);
                }
            }
        });
    }
    public void access(View view) {
        EditText hckey = (EditText) findViewById(R.id.jnihardcode_Key);

        if (hckey.getText().toString().isEmpty()){
            final AlertDialog.Builder alert = new AlertDialog.Builder(JniHardcodingActivity.this);
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
        else if (vjni.access(hckey.getText().toString()) != 0) {
            final AlertDialog.Builder alert = new AlertDialog.Builder(JniHardcodingActivity.this);
            View alertView= getLayoutInflater().inflate(R.layout.dialog_happy_access, null);
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
            //Toast.makeText(this, "Access granted! See you on the other side :)", Toast.LENGTH_SHORT).show();
        }
        else {
            final AlertDialog.Builder alert = new AlertDialog.Builder(JniHardcodingActivity.this);
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
            //Toast.makeText(this, "Access denied! See you in hell :D", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(JniHardcodingActivity.this,"fadein-to-fadeout");
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(JniHardcodingActivity.this,"fadein-to-fadeout");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
