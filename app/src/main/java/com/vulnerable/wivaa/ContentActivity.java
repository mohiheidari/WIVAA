package com.vulnerable.wivaa;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static maes.tech.intentanim.CustomIntent.customType;


public class ContentActivity extends AppCompatActivity {

    Button btn0,btn1,btn6,btn2,btn3,btn4,btn5,btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        //btn0 ... btn6
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);

        //ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF0909")));
        getSupportActionBar().setElevation(0);
        actionBar.setDisplayHomeAsUpEnabled(false);

        //ClickListener
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert_reverse = new AlertDialog.Builder(ContentActivity.this);
                View alertView_reverse = getLayoutInflater().inflate(R.layout.reverse_dialog, null);
                //Set the view
                alert_reverse.setView(alertView_reverse);
                //Show alert
                final AlertDialog alertDialog_reverse = alert_reverse.show();
                //Can not close the alert by touching outside.
                alertDialog_reverse.setCancelable(false);
                alertDialog_reverse.setCanceledOnTouchOutside(false);
                alertDialog_reverse.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                ImageView cat0_cancel = (ImageView) alertView_reverse.findViewById(R.id.cat0_cancel);
                ImageView cat0_1 = (ImageView) alertView_reverse.findViewById(R.id.cat0_1);
                ImageView cat0_2 = (ImageView) alertView_reverse.findViewById(R.id.cat0_2);
                ImageView cat0_3 = (ImageView) alertView_reverse.findViewById(R.id.cat0_3);

                cat0_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog_reverse.dismiss();
                    }
                });
                cat0_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Content -> adb
                        startActivity(new Intent(ContentActivity.this, AdbActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
                cat0_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Content -> adb
                        startActivity(new Intent(ContentActivity.this, DecompileandUnzipActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });

                cat0_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Content -> adb
                        startActivity(new Intent(ContentActivity.this, Dex2jarActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Content -> Hardcoding
                startActivity(new Intent(ContentActivity.this, HardcodingActivity.class));
                customType(ContentActivity.this,"bottom-to-up");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert_insecuredatastorage = new AlertDialog.Builder(ContentActivity.this);
                View alertView_insecuredatastorage = getLayoutInflater().inflate(R.layout.insecuredatastorage_dialog, null);
                //Set the view
                alert_insecuredatastorage.setView(alertView_insecuredatastorage);
                //Show alert
                final AlertDialog alertDialog_insecuredatastorage = alert_insecuredatastorage.show();
                //Can not close the alert by touching outside.
                alertDialog_insecuredatastorage.setCancelable(false);
                alertDialog_insecuredatastorage.setCanceledOnTouchOutside(false);
                alertDialog_insecuredatastorage.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                ImageView cat2_cancel = (ImageView) alertView_insecuredatastorage.findViewById(R.id.cat2_cancel);
                ImageView cat2_1 = (ImageView) alertView_insecuredatastorage.findViewById(R.id.cat2_1);
                ImageView cat2_2 = (ImageView) alertView_insecuredatastorage.findViewById(R.id.cat2_2);
                ImageView cat2_3 = (ImageView) alertView_insecuredatastorage.findViewById(R.id.cat2_3);
                ImageView cat2_4 = (ImageView) alertView_insecuredatastorage.findViewById(R.id.cat2_4);
                ImageView cat2_5 = (ImageView) alertView_insecuredatastorage.findViewById(R.id.cat2_5);

                cat2_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog_insecuredatastorage.dismiss();
                    }
                });
                cat2_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Content -> insecure logging
                        startActivity(new Intent(ContentActivity.this, InsecureLoggingActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
                cat2_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Content -> insecure logging
                        startActivity(new Intent(ContentActivity.this, SharedPrefActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
                cat2_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ContentActivity.this,TxtActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
                cat2_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ContentActivity.this,TmpActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
                cat2_5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ContentActivity.this,DBActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert_accesscontrol = new AlertDialog.Builder(ContentActivity.this);
                View alertView_accesscontrol = getLayoutInflater().inflate(R.layout.accesscontrol_dialog, null);
                //Set the view
                alert_accesscontrol.setView(alertView_accesscontrol);
                //Show alert
                final AlertDialog alertDialog_accesscontrol = alert_accesscontrol.show();
                //Can not close the alert by touching outside.
                alertDialog_accesscontrol.setCancelable(false);
                alertDialog_accesscontrol.setCanceledOnTouchOutside(false);
                alertDialog_accesscontrol.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                ImageView cat3_cancel = (ImageView) alertView_accesscontrol.findViewById(R.id.cat3_cancel);
                ImageView cat3_1 = (ImageView) alertView_accesscontrol.findViewById(R.id.cat3_1);
                ImageView cat3_2 = (ImageView) alertView_accesscontrol.findViewById(R.id.cat3_2);
                ImageView cat3_3 = (ImageView) alertView_accesscontrol.findViewById(R.id.cat3_3);

                cat3_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog_accesscontrol.dismiss();
                    }
                });
                cat3_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ContentActivity.this,IntentPart1Activity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
                cat3_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ContentActivity.this,IntentPart2Activity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
                cat3_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ContentActivity.this,ContentProviderActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Content -> Hardcoding
                startActivity(new Intent(ContentActivity.this, SQLInjectionActivity.class));
                customType(ContentActivity.this,"bottom-to-up");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert_backupanddebug = new AlertDialog.Builder(ContentActivity.this);
                View alertView_backupanddebug = getLayoutInflater().inflate(R.layout.backupanddebug_dialog, null);
                //Set the view
                alert_backupanddebug.setView(alertView_backupanddebug);
                //Show alert
                final AlertDialog alertDialog_backupanddebug = alert_backupanddebug.show();
                //Can not close the alert by touching outside.
                alertDialog_backupanddebug.setCancelable(false);
                alertDialog_backupanddebug.setCanceledOnTouchOutside(false);
                alertDialog_backupanddebug.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                ImageView cat5_cancel = (ImageView) alertView_backupanddebug.findViewById(R.id.cat5_cancel);
                ImageView cat5_1 = (ImageView) alertView_backupanddebug.findViewById(R.id.cat5_1);
                ImageView cat5_2 = (ImageView) alertView_backupanddebug.findViewById(R.id.cat5_2);

                cat5_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog_backupanddebug.dismiss();
                    }
                });
                cat5_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ContentActivity.this,BackupActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
                cat5_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ContentActivity.this,DebugActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert_cvulnerabilities = new AlertDialog.Builder(ContentActivity.this);
                View alertView_cvulnerabilities = getLayoutInflater().inflate(R.layout.cvulnerabilities_dialog, null);
                //Set the view
                alert_cvulnerabilities.setView(alertView_cvulnerabilities);
                //Show alert
                final AlertDialog alertDialog_cvulnerabilities = alert_cvulnerabilities.show();
                //Can not close the alert by touching outside.
                alertDialog_cvulnerabilities.setCancelable(false);
                alertDialog_cvulnerabilities.setCanceledOnTouchOutside(false);
                alertDialog_cvulnerabilities.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                ImageView cat6_cancel = (ImageView) alertView_cvulnerabilities.findViewById(R.id.cat6_cancel);
                ImageView cat6_1 = (ImageView) alertView_cvulnerabilities.findViewById(R.id.cat6_1);
                ImageView cat6_2 = (ImageView) alertView_cvulnerabilities.findViewById(R.id.cat6_2);

                cat6_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog_cvulnerabilities.dismiss();
                    }
                });
                cat6_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ContentActivity.this,JniHardcodingActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
                cat6_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ContentActivity.this,JniBufferActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert_webview = new AlertDialog.Builder(ContentActivity.this);
                View alertView_webview = getLayoutInflater().inflate(R.layout.webview_dialog, null);
                //Set the view
                alert_webview.setView(alertView_webview);
                //Show alert
                final AlertDialog alertDialog_webview = alert_webview.show();
                //Can not close the alert by touching outside.
                alertDialog_webview.setCancelable(false);
                alertDialog_webview.setCanceledOnTouchOutside(false);
                alertDialog_webview.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                ImageView cat7_cancel = (ImageView) alertView_webview.findViewById(R.id.cat7_cancel);
                ImageView cat7_1 = (ImageView) alertView_webview.findViewById(R.id.cat7_1);
                ImageView cat7_2 = (ImageView) alertView_webview.findViewById(R.id.cat7_2);
                ImageView cat7_3 = (ImageView) alertView_webview.findViewById(R.id.cat7_3);
                ImageView cat7_4 = (ImageView) alertView_webview.findViewById(R.id.cat7_4);

                cat7_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog_webview.dismiss();
                    }
                });
                cat7_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ContentActivity.this,FileActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
                cat7_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ContentActivity.this,JavaScriptActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
                cat7_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ContentActivity.this,ClearTextActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
                cat7_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ContentActivity.this,SSLActivity.class));
                        customType(ContentActivity.this,"fadein-to-fadeout");
                    }
                });
            }
        });
    }



    //menu

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        customType(ContentActivity.this,"up-to-bottom");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                customType(ContentActivity.this,"up-to-bottom");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}