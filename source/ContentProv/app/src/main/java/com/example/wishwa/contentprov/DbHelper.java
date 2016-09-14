package com.example.wishwa.contentprov;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wishwa on 12/09/2016.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "data";
    public static final String TABLE_NAME = "comments_table";
    public static final String C_ID= "_id";
    public static final String NAME= "_name";
    public static final String COMMENT= "_comment";
    public static final String EMAIL= "_email";
    public static final String TIME= "_time";
    public static final int VERSION= 1;

    private final String createDb = "create table if not exist" + TABLE_NAME + "("
            + C_ID + "integer primary key autoincrement, "
            + NAME + "text, "
            + COMMENT + "text, "
            + EMAIL + "text, "
            + TIME + "text); ";



    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(createDb);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table" + TABLE_NAME);
    }
}
