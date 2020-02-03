package com.vulnerable.wivaa;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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

public class DBActivity extends AppCompatActivity {
    RelativeLayout db_des;
    EditText dbuser, dbpass;
    Button dbaccess;
    TextView dbtv;
    private SQLiteDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        try {
            mDB = openOrCreateDatabase("ids2", MODE_PRIVATE, null);
            mDB.execSQL("CREATE TABLE IF NOT EXISTS myuser(user VARCHAR, password VARCHAR);");
        }
        catch(Exception e) {
            Log.d("Error!", "Error occurred while creating database: " + e.getMessage());
        }

        dbaccess = findViewById(R.id.db_access);
        dbuser   = findViewById(R.id.dbuser);
        dbpass   = findViewById(R.id.dbpass);
        db_des   = findViewById(R.id.db_des);
        dbtv     = findViewById(R.id.dbtv);

        db_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DBActivity.this , DBDesActivity.class));
                customType(DBActivity.this,"bottom-to-up");
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));


        ToggleButton toggleButton_db = findViewById(R.id.toggleButton_db);
        toggleButton_db.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    dbaccess.setVisibility(View.GONE);
                    dbpass.setVisibility(View.GONE);
                    dbuser.setVisibility(View.GONE);
                    dbtv.setText(R.string.dbDesInsec);
                    Typeface regular = getResources().getFont(R.font.iransansregular);
                    dbtv.setTypeface(regular);
                }
                else{
                    dbaccess.setVisibility(View.VISIBLE);
                    dbpass.setVisibility(View.VISIBLE);
                    dbuser.setVisibility(View.VISIBLE);
                    dbtv.setText(R.string.insecdsDesSec);
                    Typeface bold = getResources().getFont(R.font.iransansbold);
                    dbtv.setTypeface(bold);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(DBActivity.this,"fadein-to-fadeout");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(DBActivity.this,"fadein-to-fadeout");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public void access(View view) {
        if (dbuser.getText().toString().isEmpty() || dbpass.getText().toString().isEmpty()) {
            final AlertDialog.Builder alert = new AlertDialog.Builder(DBActivity.this);
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
            try {
                mDB.execSQL("INSERT INTO myuser VALUES ('"+ dbuser.getText().toString() +"', '"+ dbpass.getText().toString() +"');");
                mDB.close();
            }
            catch(Exception e) {
                Log.d("Error!", "Error occurred while inserting into database: " + e.getMessage());
            }
            final AlertDialog.Builder alert = new AlertDialog.Builder(DBActivity.this);
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
    }
}
