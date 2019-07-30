package com.liarkat.testwhatatest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = "TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Estructura.TABLE_NAME + " (" +
                    Estructura._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Estructura.COLUMN_NAME_USUARIO + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS" + Estructura.TABLE_NAME +;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TestWhatATest.sqlite";
    public BaseDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
