package com.vulnerable.wivaa;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.Toast;
import android.widget.ToggleButton;

import static maes.tech.intentanim.CustomIntent.customType;

public class SQLInjectionActivity extends AppCompatActivity {

    private SQLiteDatabase sDB;
    RelativeLayout sql_des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlinjection);

        final Button sql_access = findViewById(R.id.sql_access);
        final EditText sqlcard  = findViewById(R.id.sqlcard);
        final TextView sqltv    = findViewById(R.id.sqltv);
        final TextView sqlcode = findViewById(R.id.sqlcode);
        try {
            sDB= openOrCreateDatabase("sqli", MODE_PRIVATE, null);
            sDB.execSQL("DROP TABLE IF EXISTS sqliuser;");
            sDB.execSQL("CREATE TABLE IF NOT EXISTS sqliuser(user VARCHAR, password VARCHAR, credit_card VARCHAR);");
            sDB.execSQL("INSERT INTO sqliuser VALUES ('mohi' , 'passwd123'  , '1234567812345678');");
            sDB.execSQL("INSERT INTO sqliuser VALUES ('marie', 'p@ssword'   , '1111222233334444');");
            sDB.execSQL("INSERT INTO sqliuser VALUES ('star' , 'password123', '5555666677778888');");

        }
        catch(Exception e) {
            Log.d("wivaa-sqli", "Error occurred while creating database for SQLI: " + e.getMessage());
        }


        sql_des = findViewById(R.id.sql_des);
        sql_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SQLInjectionActivity.this , SQLInjectionDesActivity.class));
                customType(SQLInjectionActivity.this,"bottom-to-up");
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        ToggleButton toggleButton_sql = findViewById(R.id.toggleButton_sql);
        toggleButton_sql.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sql_access.setVisibility(View.GONE);
                    sqlcard.setVisibility(View.GONE);
                    Typeface regular = getResources().getFont(R.font.iransansregular);
                    sqltv.setTypeface(regular);
                    sqlcode.setVisibility(View.VISIBLE);
                    sqltv.setText(R.string.sqlDesInsec1);
                }
                else {
                    sql_access.setVisibility(View.VISIBLE);
                    sqlcard.setVisibility(View.VISIBLE);
                    Typeface bold = getResources().getFont(R.font.iransansbold);
                    sqltv.setTypeface(bold);
                    sqlcode.setVisibility(View.GONE);
                    sqltv.setText(R.string.sqlDesSec);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentActivity.class));
        customType(SQLInjectionActivity.this, "up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentActivity.class));
                customType(SQLInjectionActivity.this, "up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public void search(View view) {
        EditText srchtxt = findViewById(R.id.sqlcard);
        Cursor cr = null;
        try {
            cr = sDB.rawQuery("SELECT * FROM sqliuser WHERE user = '" + srchtxt.getText().toString() + "'", null);
            StringBuilder strb = new StringBuilder("");
            if ((cr != null) && (cr.getCount() > 0)) {
                cr.moveToFirst();

                do {
                    strb.append("User: (" + cr.getString(0) + ") pass: (" + cr.getString(1) + ") Credit card: (" + cr.getString(2) + ")\n");
                } while (cr.moveToNext());
            }
            else {
                strb.append("User: (" + srchtxt.getText().toString() +") not found");
            }
            Toast.makeText(this, strb.toString(), Toast.LENGTH_SHORT).show();
        }
        catch(Exception e) {
            Log.d("wivaa-sqli", "Error occurred while searching in database: " + e.getMessage());
        }
    }
}
