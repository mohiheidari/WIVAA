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

public class BackupActivity extends AppCompatActivity {
    EditText backupuser,backuppass;
    TextView backuptv, backupcode;
    Button   backupaccess;
    RelativeLayout backup_des;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup);

        backupuser    = findViewById(R.id.backupuser);
        backuppass    = findViewById(R.id.backuppass);
        backuptv      = findViewById(R.id.backuptv);
        backupaccess  = findViewById(R.id.backup_access);
        backupcode    = findViewById(R.id.backupcode);
        backup_des    = findViewById(R.id.backup_des);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        backup_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BackupActivity.this,BackupDesActivity.class));
                customType(BackupActivity.this, "bottom-to-up");
            }
        });

        ToggleButton toggleButton_backup = findViewById(R.id.toggleButton_backup);
        toggleButton_backup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    backupuser.setVisibility(View.GONE);
                    backuppass.setVisibility(View.GONE);
                    backupaccess.setVisibility(View.GONE);
                    backuptv.setText(R.string.backupDesInsec1);
                    backupcode.setVisibility(View.VISIBLE);
                    Typeface regular = getResources().getFont(R.font.iransansregular);
                    backuptv.setTypeface(regular);
                }
                else {
                    backupuser.setVisibility(View.VISIBLE);
                    backuppass.setVisibility(View.VISIBLE);
                    backupaccess.setVisibility(View.VISIBLE);
                    backuptv.setText(R.string.insecdsDesSec);
                    backupcode.setVisibility(View.GONE);
                    Typeface bold = getResources().getFont(R.font.iransansbold);
                    backuptv.setTypeface(bold);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(BackupActivity.this,"fadein-to-fadeout");
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(BackupActivity.this,"fadein-to-fadeout");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public void access(View view) {
        if (backupuser.getText().toString().isEmpty() || backuppass.getText().toString().isEmpty()) {
            final AlertDialog.Builder alert = new AlertDialog.Builder(BackupActivity.this);
            View alertView = getLayoutInflater().inflate(R.layout.dialog_poker_acess, null);
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
            SharedPreferences spref = PreferenceManager.getDefaultSharedPreferences(BackupActivity.this);
            SharedPreferences.Editor spedit = spref.edit();

            spedit.putString("user", backupuser.getText().toString());
            spedit.putString("password", backuppass.getText().toString());
            spedit.apply();

            final AlertDialog.Builder alert = new AlertDialog.Builder(BackupActivity.this);
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
