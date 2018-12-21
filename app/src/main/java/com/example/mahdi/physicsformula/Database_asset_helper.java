package com.example.mahdi.physicsformula;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;



public class Database_asset_helper extends SQLiteAssetHelper {

    private static final String TAG2 = "data";
    private static final String DATABASE_NAME = "db_formula.db";
    private static final int DATABASE_VERSION = 1;
    private static final String ITEM_TABLE_NAME = "tbl_item";
    public static final String COL_ID = "col_id";
    public static final String COL_TITLE = "col_title";
    public static final String COL_CONTENT = "col_content";
    public static final String COL_IMG = "col_image";

    Context context;

    public Database_asset_helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
        this.context = context;
    }
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
                items.setImage(cursor.getString(3));
                itemss.add(items);
                cursor.moveToNext();
            }
        }
        cursor.close();
        sqLiteDatabase.close();
        return itemss;
    }

}
