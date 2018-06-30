package com.adityadua.sqlitedbexample.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.adityadua.sqlitedbexample.utils.Constants;

/**
 * Created by AdityaDua on 30/06/18.
 */

public class DBHelper {

    private SQLiteDatabase db;
    private final Context context;
    private final TablesClass tableClass;
    private static DBHelper db_helper;

    private DBHelper(Context context){
        this.context = context;
        tableClass = new TablesClass(context, Constants.DATABASE_NAME,null,Constants.DATABASE_VERSION);
    }

    public static DBHelper getInstance(Context context){

        if(db_helper == null){
            db_helper = new DBHelper(context);
            db_helper.open();
        }

        return db_helper;

    }

    public void open(){
        try {
            db = tableClass.getWritableDatabase();
        }catch (Exception e){
            e.printStackTrace();
            db = tableClass.getReadableDatabase();
        }
    }

    public void close(){
        if(db.isOpen()){
            db.close();
        }
    }

    /**
     * BookData
     * book id : 100
     * book name : the alchimest
     * book author : Paul Coehlo
     * insert into table_name (book id,book auhtor,book_name) values
     * (100,"The Alchemist","Paul Coehlo");
     *
     * Solution :
     * Content Values ka object
     * you can think of it as a map
     * book id : 100
     * book name : the alchimest
     * book author : Paul Coehlo
     * obj.save(cv,tableName);
     */
    public long insertContentValues(String tableName, ContentValues cv){
        long id =0;

        try{
            db.beginTransaction();
            id = db.insert(tableName,null,cv);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.setTransactionSuccessful();
        }
        return id;
    }

    /*
     * Update
     */
    public int updateRecords(String tableName,ContentValues values,String where,String [] whereArgs){
        int rowCount= 0;

        try {
            db.beginTransaction();
            rowCount = db.update(tableName, values, where, whereArgs);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.setTransactionSuccessful();
        }

        return  rowCount;
    }

    /*
     * Delete Data
     */
    public int deleteRecords(String tableName,String where,String [] whereArgs){
        int rowCount= 0;

        try {
            db.beginTransaction();
            rowCount = db.delete(tableName, where, whereArgs);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.setTransactionSuccessful();
        }

        return  rowCount;
    }

}
