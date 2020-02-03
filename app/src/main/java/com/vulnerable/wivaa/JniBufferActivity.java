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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import static maes.tech.intentanim.CustomIntent.customType;

public class JniBufferActivity extends AppCompatActivity {

    private VulJni vjni;
    TextView jnibuffer_tv, jnibuffercode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jnibuffer);

        jnibuffer_tv = findViewById(R.id.jnibuffer_tv);
        jnibuffercode = findViewById(R.id.jnibuffercode);
        final EditText jnibuffer_edittext = findViewById(R.id.jnibuffer_edittext);
        final Button jnibuffer_access = findViewById(R.id.jnibuffer_access);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        RelativeLayout jnibufferdes = findViewById(R.id.jnibuffer_des);
        jnibufferdes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JniBufferActivity.this,JniBufferDesActivity.class));
                customType(JniBufferActivity.this, "bottom-to-up");
            }
        });
        vjni = new VulJni();


        ToggleButton toggleButton_jnibuffer = findViewById(R.id.toggleButton_jnibuffer);
        toggleButton_jnibuffer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    jnibuffer_access.setVisibility(View.GONE);
                    jnibuffer_edittext.setVisibility(View.GONE);
                    jnibuffercode.setVisibility(View.VISIBLE);
                    jnibuffer_tv.setText(R.string.jnibufferDesInsec1);
                    Typeface regular = getResources().getFont(R.font.iransansregular);
                    jnibuffer_tv.setTypeface(regular);
                }
                else {
                    jnibuffer_access.setVisibility(View.VISIBLE);
                    jnibuffer_edittext.setVisibility(View.VISIBLE);
                    jnibuffercode.setVisibility(View.GONE);
                    jnibuffer_tv.setText(R.string.jniDesSec);
                    Typeface bold = getResources().getFont(R.font.iransansbold);
                    jnibuffer_tv.setTypeface(bold);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(JniBufferActivity.this,"fadein-to-fadeout");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
    }
    public void push(View view) {
        EditText cTxt = (EditText) findViewById(R.id.jnibuffer_edittext);

        if (cTxt.getText().toString().isEmpty()){
            final AlertDialog.Builder alert = new AlertDialog.Builder(JniBufferActivity.this);
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
        else if (vjni.initiateLaunchSequence(cTxt.getText().toString()) != 0) {
            final AlertDialog.Builder alert = new AlertDialog.Builder(JniBufferActivity.this);
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
            final AlertDialog.Builder alert = new AlertDialog.Builder(JniBufferActivity.this);
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
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(JniBufferActivity.this,"fadein-to-fadeout");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
