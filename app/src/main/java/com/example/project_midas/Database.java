package com.example.project_midas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    //db naam
    public static String DATABASE_NAME = "database_midas_mobile";

    //tabel 1
    public static final String DATABASE_table_1 = "user";

    public static final String Table_1_col_0 = "id";
    public static final String Table_1_col_1 = "naam";
    public static final String Table_1_col_2 = "achternaam";
    public static final String Table_1_col_3 = "foto_path";
    public static final String Table_1_col_4 = "geboorte_date";
    public static final String Table_1_col_5 = "password";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DATABASE_table_1 + "(" + Table_1_col_0 + " INTEGER DEFAULT 0" +
                " primary key autoincrement ,"
                + Table_1_col_1 + " TEXT ," + Table_1_col_2 + " TEXT ," + Table_1_col_3 + " " +
                "TEXT default null," + Table_1_col_4 + " TEXT ,"+ Table_1_col_5 + " TEXT )");
    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_table_1);
    }

    public void addToTabel1(String naam, String achternaam , String foto ,String geboorte,
                            String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Table_1_col_1, naam);
        contentValues.put(Table_1_col_2, achternaam);
        contentValues.put(Table_1_col_3, foto);
        contentValues.put(Table_1_col_4, geboorte);
        contentValues.put(Table_1_col_5, password);

        sqLiteDatabase.insert(DATABASE_table_1, null, contentValues);
    }
}
