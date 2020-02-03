
package com.vulnerable.wivaa;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

public class NotesProvider extends ContentProvider {

    // DB stuff
    SQLiteDatabase mDB;
    static final String DBNAME  = "appnotes.db";
    static final int DBVERSION  = 1;
    static final String TABLE   = "notes";
    static final String C_ID    = "_id";
    static final String C_TITLE = "title";
    static final String C_NOTE  = "note";

    static final String CREATE_TBL_QRY = " CREATE TABLE " + TABLE +
            " (" + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            C_TITLE + " TEXT NOT NULL, " +
            C_NOTE + " TEXT NOT NULL);";

    static final String DROP_TBL_QRY = "DROP TABLE IF EXISTS " +  TABLE;

    static final int PATH_TABLE = 1;
    static final int PATH_ID    = 2;

    static final String AUTHORITY = "com.vulnerable.wivaa.provider.notesprovider";
    static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE);

    static final UriMatcher urimatcher;
    static {
        urimatcher = new UriMatcher(UriMatcher.NO_MATCH);
        urimatcher.addURI(AUTHORITY, TABLE, PATH_TABLE);
        urimatcher.addURI(AUTHORITY, TABLE + "/#", PATH_ID);
    }

    private static class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, DBNAME, null, DBVERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DROP_TBL_QRY);
            db.execSQL(CREATE_TBL_QRY);
            db.execSQL("INSERT INTO " + TABLE + "(" + C_TITLE + "," + C_NOTE + ") VALUES ('mellatCard', '1485');");
            db.execSQL("INSERT INTO " + TABLE + "(" + C_TITLE + "," + C_NOTE + ") VALUES ('sepahCard', '2424');");
            db.execSQL("INSERT INTO " + TABLE + "(" + C_TITLE + "," + C_NOTE + ") VALUES ('meliCard', '1467');");
            db.execSQL("INSERT INTO " + TABLE + "(" + C_TITLE + "," + C_NOTE + ") VALUES ('Instagram', 'us3r:pass12');");
            db.execSQL("INSERT INTO " + TABLE + "(" + C_TITLE + "," + C_NOTE + ") VALUES ('Facebook', 'wivaa:pa@s');");
            db.execSQL("INSERT INTO " + TABLE + "(" + C_TITLE + "," + C_NOTE + ") VALUES ('Gmail', 'user:pass1');");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onCreate(db);
        }
     }

    public NotesProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;
        switch (urimatcher.match(uri)) {
            case PATH_TABLE:
                // delete all records
                count = mDB.delete(TABLE, selection, selectionArgs);
                break;
            case PATH_ID:
                // delete a single record
                String id = uri.getLastPathSegment();
                count = mDB.delete( TABLE, C_ID +  " = " + id +
                (!TextUtils.isEmpty(selection) ? " AND (" +
                selection + ')' : ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Wivanotes(delete): Unsupported URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public String getType(Uri uri) {
        switch (urimatcher.match(uri)){
            // Get all notes
            case PATH_TABLE:
                return "vnd.android.cursor.dir/vnd.vulnerbale.notes";
            // Get a single note
            case PATH_ID:
                return "vnd.android.cursor.item/vnd.vulnerbale.notes";
            default:
                throw new IllegalArgumentException("Wivanotes: Unsupported URI: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long row = mDB.insert(TABLE, "", values);
        if(row > 0) {
            // Record added
            Uri newUri = ContentUris.withAppendedId(CONTENT_URI, row);
            getContext().getContentResolver().notifyChange(newUri, null);
            return newUri;
        }
        throw new SQLException("Wivanotes: Fail to add a new record into " + uri);
    }

    @Override
    public boolean onCreate() {
        DBHelper dbHelper = new DBHelper(getContext());
        mDB = dbHelper.getWritableDatabase();
        if (mDB == null) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        // The table to query
        queryBuilder.setTables(TABLE);
        switch (urimatcher.match(uri)) {
            // maps all database column names
            case PATH_TABLE:
                break;
            case PATH_ID:
                queryBuilder.appendWhere( C_ID + "=" + uri.getLastPathSegment());
                break;
            default:
                throw new IllegalArgumentException("Wivaanotes(query): Unknown URI " + uri);
        }
        if (sortOrder == null || sortOrder == "") {
            // If no sorting specified by called then sort on title by default
            sortOrder = C_TITLE;
        }
        Cursor cursor = queryBuilder.query(mDB, projection, selection,
                                           selectionArgs, null, null, sortOrder);

         // register to watch a content URI for changes and notify the content resolver
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int count = 0;

        switch (urimatcher.match(uri)) {
            case PATH_TABLE:
                count = mDB.update(TABLE, values, selection, selectionArgs);
                break;
            case PATH_ID:
                count = mDB.update(TABLE, values, C_ID +
                        " = " + uri.getLastPathSegment() +
                (!TextUtils.isEmpty(selection) ? " AND (" +
                selection + ')' : ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Wivanotes(update): Unsupported URI " + uri );
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}
