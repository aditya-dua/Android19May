package com.adityadua.sqlitedbexample.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.adityadua.sqlitedbexample.utils.Constants;

/**
 * Created by AdityaDua on 30/06/18.
 */

public class TablesClass extends SQLiteOpenHelper {

    Context context;
    String query ="Create table IF NOT EXISTS "+ Constants.BOOK_TABLE+" ("+
            Constants.ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            Constants.BOOK_ID +" TEXT, "+
            Constants.BOOK_NAME +" TEXT, "+
            Constants.BOOK_AUTHOR+" TEXT);";


    public TablesClass(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        context.deleteDatabase(Constants.DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }
}
