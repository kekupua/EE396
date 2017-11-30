package org.tensorflow.demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

/**
 * Created by Umi on 11/28/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "HolmesHall.db";
    public static final String TABLE_NAME = "Rooms";
    public static final String COL_ID = "ID";
    public static final String COL_CRSENUM = "CourseNum";
    public static final String COL_CRSETITLE = "CourseTitle";
    public static final String COL_CRSEINSTR = "CourseInstr";
    public static final String COL_DAY = "CourseDay";
    public static final String COL_TIME = "CourseTime";
    public static final String COL_LOC = "CourseLoc";



    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase(); //Create database and table
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Makes table with columns
        db.execSQL("create table " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CourseNum TEXT," +
                "CourseTitle TEXT," +
                "CourseInstr TEXT," +
                "CourseDay TEXT," +
                "CourseTime TEXT," +
                "CourseLoc TEXT) "); //Execute query
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
