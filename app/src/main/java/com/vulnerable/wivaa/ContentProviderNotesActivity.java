package com.vulnerable.wivaa;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import static maes.tech.intentanim.CustomIntent.customType;

public class ContentProviderNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentprovider_notes);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ContentProviderActivity.class));
        customType(ContentProviderNotesActivity.this,"left-to-right");
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ContentProviderActivity.class));
                customType(ContentProviderNotesActivity.this,"left-to-right");
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public void accessNotes(View view) {
        EditText pinTxt = (EditText) findViewById(R.id.contentnotepass);
        Button abutton = (Button) findViewById(R.id.contentnotebtn);
        ImageView imgcontent = findViewById(R.id.contentnote_img1);
        SharedPreferences spref = PreferenceManager.getDefaultSharedPreferences(this);
        String pin = spref.getString(getString(R.string.pkey), "");
        String userpin = pinTxt.getText().toString();

        // XXX Easter Egg?
        if (userpin.equals(pin)) {
            // Display the private notes
            ListView lview = (ListView) findViewById(R.id.contentnotelistview);
            lview.setVisibility(View.VISIBLE);
            Cursor cr = getContentResolver().query(NotesProvider.CONTENT_URI, new String[] {"_id", "title", "note"}, null, null, null);
            String[] columns = {NotesProvider.C_TITLE, NotesProvider.C_NOTE};
            int [] fields = {R.id.title_entry, R.id.note_entry};
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.notes_entry ,cr, columns, fields, 0);
            lview.setAdapter(adapter);
            pinTxt.setVisibility(View.INVISIBLE);
            abutton.setVisibility(View.INVISIBLE);
            //cr.close();

        }
        else {
            final AlertDialog.Builder alert = new AlertDialog.Builder(ContentProviderNotesActivity.this);
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
            //Toast.makeText(this, "Please Enter a valid pin!", Toast.LENGTH_SHORT).show();
        }

    }
}
