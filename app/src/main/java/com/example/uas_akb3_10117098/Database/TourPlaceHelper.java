package com.example.uas_akb3_10117098.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import static com.example.uas_akb3_10117098.Database.DatabaseHelper.MyColumns.id;

/** NIM : 10117098
 * Nama : Santi Susanti
 * Kelas : IF-3
 * Tanggal : 09-08-2020 - 12-08-2020**/

public class TourPlaceHelper {
    private static final String DATABASE_TABLE = "tempatWisata";
    private static DatabaseHelper databaseHelper;
    private static TourPlaceHelper INSTANCE;
    private static SQLiteDatabase db;
    private static ListInsert li;

    private TourPlaceHelper(Context context){

        databaseHelper = new DatabaseHelper(context);

         li = new ListInsert(context);

    }

    public static TourPlaceHelper getInstance(Context context){
        if (INSTANCE == null){
            synchronized (SQLiteOpenHelper.class){
                if (INSTANCE == null){
                    INSTANCE = new TourPlaceHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        db = databaseHelper.getWritableDatabase();
    }

    public void close(){
        databaseHelper.close();

        if (db.isOpen()){
            db.close();
        }
    }

    public Cursor queryAll(){
        return db.query(DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                 id +" Desc");

    }

    public Cursor queryById(String id){
        return db.query(
                DATABASE_TABLE,
                null,
                id + " = ?",
                new String[]{id},
                null,
                null,
                null,
                null);
    }


}
