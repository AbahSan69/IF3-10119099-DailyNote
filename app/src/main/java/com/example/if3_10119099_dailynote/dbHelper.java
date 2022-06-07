package com.example.if3_10119099_dailynote;

//NIM   = 10119099;
//Nama  = Sandi Komara;
//Kelas = IF3

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "catatan";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String KEY_CATEGORIES = "kategori";
    private static final String KEY_NOTES = "note";
    private static final String KEY_DATE = "date";

    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+ TABLE_NAME + "("+ COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUMN_TITLE + " TEXT,"+
                KEY_CATEGORIES + " TEXT,"+
                KEY_NOTES + " TEXT,"+
                KEY_DATE + " TEXT,"+")";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("DROP TABLE IF EXIST"+TABLE_NAME);
    onCreate(sqLiteDatabase);
    }
}
