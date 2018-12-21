package com.example.mahdi.physicsformula;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOpenHelper extends SQLiteAssetHelper {

    private static final String TAG2 = "data";
    private static final String DATABASE_NAME = "db_formula";
    private static final int DATABASE_VERSION = 1;
    private static final String ITEM_TABLE_NAME = "tbl_item";
    public static final String COL_ID = "col_id";
    public static final String COL_TITLE = "col_title";
    public static final String COL_CONTENT = "col_content";
    Context context;
//    private static final String SQL_COMMAND_ITEM_CREATE = "CREATE TABLE IF  NOT EXISTS  "+ ITEM_TABLE_NAME +" ("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+COL_TITLE+" TEXT, "+COL_CONTENT+" TEXT);";

//            "CREATE TABLE IF NOT EXISTS " + ITEM_TABLE_NAME + "(" +
//            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
//            COL_TITLE + "VARCHAR, " +
//            COL_CONTENT + "VARCHAR );";
//




    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        try {
//            db.execSQL(SQL_COMMAND_ITEM_CREATE);
//        } catch (SQLException e) {
//            Log.e(TAG2, "onCreate: making table -->> " + e.toString());
//        }
//    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //محیطی برای ارسال دیتا به دیتابیس
    }
    //کلاسی برای دریافت دیتا از دیتابیس
    //کلاسی برای اضافه کردن دیتا به دیتابیس

    public List<items> getitems() {
        List<items> itemss = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + ITEM_TABLE_NAME, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 1) {
            while (!cursor.isAfterLast()) {
                items items=new items();
                items.setId(cursor.getInt(0));
                items.setTitle(cursor.getString(1));
                items.setContent(cursor.getString(2));
                itemss.add(items);
                cursor.moveToNext();
            }
        }
        cursor.close();
        sqLiteDatabase.close();
        return itemss;
    }

}
