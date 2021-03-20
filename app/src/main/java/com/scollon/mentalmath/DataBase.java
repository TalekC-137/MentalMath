package com.scollon.mentalmath;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class DataBase extends SQLiteOpenHelper {



    public static final String POINTS_TABLE = "POINTS_TABLE";
    public static final String POINTS = "POINTS";
    public static final String COLUMN_ID = "ID";



    public DataBase(@Nullable Context context, int version) {
        super(context, "points.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + POINTS_TABLE + " ("  + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + POINTS + " INT ) ";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne (Helper helper){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
       cv.put(POINTS, helper.getPunkty());
        long insert =   db.insert(POINTS_TABLE, null, cv);
        if( insert == -1){
            return false;
        }else{
            return true;
        }
    }
    public boolean deleteOne(Helper helper){

        SQLiteDatabase db = this.getWritableDatabase();
        String queryString  = "DELETE FROM " + POINTS_TABLE + " WHERE " + COLUMN_ID + " = " + helper.getId();
        Cursor cursor=  db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            return true;

        }else {
            return false;
        }
    }
    public List<Helper> getEveryone(){
        List <Helper> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + POINTS_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);


        if (cursor.moveToFirst()){
            do {
                int customerID = cursor.getInt(1);
                int customerAge = cursor.getInt(0);
                Helper newCustomer = new Helper(customerID,customerAge);
                returnList.add(newCustomer);
            } while (cursor.moveToNext());

        }else{

        }   cursor.close();
        db.close();
        return returnList;
    }


}
