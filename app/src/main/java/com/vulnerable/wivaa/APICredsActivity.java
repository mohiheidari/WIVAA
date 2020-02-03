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
import android.widget.ImageView;

import static maes.tech.intentanim.CustomIntent.customType;

public class APICredsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicreds);
        ImageView intentp1_p2_img1 = findViewById(R.id.intentp1_p2_img1);
        ImageView intentp1_p2_img2 = findViewById(R.id.intentp1_p2_img2);

        intentp1_p2_img1.setImageResource(R.mipmap.creditcard_pass);
        intentp1_p2_img2.setImageResource(R.mipmap.credit_card);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, IntentPart1Activity.class));
        customType(APICredsActivity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, IntentPart1Activity.class));
                customType(APICredsActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
