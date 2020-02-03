package com.vulnerable.wivaa;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wajahatkarim3.easyflipview.EasyFlipView;

import static maes.tech.intentanim.CustomIntent.customType;

public class APICreds2Activity extends AppCompatActivity {
    EditText api2pass;
    Button api2access;
    TextView api2tv1;
    EasyFlipView flipview2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicreds2);
        flipview2 = findViewById(R.id.flipview2);

        api2tv1 = findViewById(R.id.api2tv1);
        api2pass = findViewById(R.id.api2pass);
        api2access = findViewById(R.id.api2_access);

        Intent i = getIntent();
        boolean bcheck = i.getBooleanExtra(getString(R.string.chk_pin), true);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));


        if (!bcheck) {
            flipview2.setVisibility(View.VISIBLE);
        }
        else{
            api2access.setVisibility(View.VISIBLE);
            api2pass.setVisibility(View.VISIBLE);
            api2tv1.setText(R.string.api2Des2);

        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, IntentPart2Activity.class));
        customType(APICreds2Activity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, IntentPart2Activity.class));
                customType(APICreds2Activity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public void access(View view) {
        if (api2pass.getText().toString().isEmpty()){
            final AlertDialog.Builder alert = new AlertDialog.Builder(APICreds2Activity.this);
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
        else if (api2pass.getText().toString().equals("892317")) {
            api2access.setVisibility(View.GONE);
            api2pass.setVisibility(View.GONE);
            flipview2.setVisibility(View.VISIBLE);
            api2tv1.setText(R.string.api2Des1);
        }
        else {
            final AlertDialog.Builder alert = new AlertDialog.Builder(APICreds2Activity.this);
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
        }
    }
}
