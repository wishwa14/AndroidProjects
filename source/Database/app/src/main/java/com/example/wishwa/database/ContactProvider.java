package com.example.wishwa.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by Wishwa on 12/09/2016.
 */

public class ContactProvider extends ContentProvider {

    public static final String PROVIDER_NAME = "com.example.wishwa.database.ContactProvider";

    static final String URL= "content://" + PROVIDER_NAME +"/cpcontacts";
    static final Uri CONTENT_URL = Uri.parse(URL);
    static final String id ="id";
    static final String name="name";
    static final int uriCode=1;

    private static HashMap<String,String> values;
    static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME,"cpcontacts",uriCode);

    }

    private SQLiteDatabase sqlDB;
    static final String DATABASE_NAME ="myContacts";
    static final String TABLE_NAME ="names";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE = "CREATE TABLE " +TABLE_NAME +
            " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " name TEXT NOT NULL);";

    @Override
    public boolean onCreate() {

        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        sqlDB = dbHelper.getWritableDatabase();

        if(sqlDB!=null){
            return true;
        }
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder sqLiteQueryBuilder =new SQLiteQueryBuilder();
        sqLiteQueryBuilder.setTables(TABLE_NAME);
        switch (uriMatcher.match(uri)){
            case uriCode:
                sqLiteQueryBuilder.setProjectionMap(values);
                break;
            default:
                throw new IllegalArgumentException("Unknown Uri" + uri);
        }

        Cursor cursor = sqLiteQueryBuilder.query(sqlDB,projection,selection,selectionArgs,null,null,sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(),uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case uriCode:
                return "com.example.wishwa.database/cpcontacts";

            default:
                throw new IllegalArgumentException("Unknown Uri" + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = sqlDB.insert(TABLE_NAME,null,values);
        if(rowID>0){
            Uri _uri= ContentUris.withAppendedId(CONTENT_URL,rowID);
            getContext().getContentResolver().notifyChange(_uri,null);
            return _uri;
        }
        else{
            Toast.makeText(getContext(),"Row Insert Failed",Toast.LENGTH_SHORT).show();
            return null;
        }

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int rowsDeleted=0;
        switch (uriMatcher.match(uri)){
            case uriCode:
                rowsDeleted = sqlDB.delete(TABLE_NAME,selection,selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown Uri" + uri);
        }
        getContext().getContentResolver().notifyChange(uri,null);
        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int rowsUpdated=0;
        switch (uriMatcher.match(uri)){
            case uriCode:
                rowsUpdated = sqlDB.delete(TABLE_NAME,selection,selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown Uri" + uri);
        }
        getContext().getContentResolver().notifyChange(uri,null);
        return rowsUpdated;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper{

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqlDB) {
            sqlDB.execSQL(CREATE_DB_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqlDB, int oldVersion, int newVersion) {
            sqlDB.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
            onCreate(sqlDB);
        }
    }
}
