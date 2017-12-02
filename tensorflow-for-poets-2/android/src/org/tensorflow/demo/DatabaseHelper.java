package org.tensorflow.demo;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.tensorflow.demo.env.Room;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "rooms";
    //Field
    private static final String COL_1 = "CourseNum";
    private static final String COL_2 = "CourseTitle";
    private static final String COL_3 = "CourseInstr";
    private static final String COL_4 = "CourseDay";
    private static final String COL_5 = "CourseTime";
    private static final String COL_6 = "CourseLoc";
    private static final String COL_7 = "ID";


    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //SQL command
        String createTable = "CREATE TABLE " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL_1 + " TEXT, " +
                COL_2 + " TEXT, " +
                COL_3 + " TEXT, " +
                COL_4 + " TEXT, " +
                COL_5 + " TEXT, " +
                COL_6 + " TEXT)";

        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(String.format("DROP IF TABLE EXISTS%s", TABLE_NAME));
        onCreate(db);
    }

   public boolean addData(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1 , item);

        Log.d(TAG, "addData: Adding " + item + "to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == 1){
            return false;
        } else {
            return true;
        }

    }

    public void testaddData(Room classroom){
        ContentValues values = new ContentValues();
        values.put(COL_1,classroom.getCourseNum());
        values.put(COL_2,classroom.getCourseTitle());
        values.put(COL_3,classroom.getCourseInstr());
        values.put(COL_4,classroom.getCourseDay());
        values.put(COL_5,classroom.getCourseTime());
        values.put(COL_6,classroom.getCourseLoc());

        SQLiteDatabase db = getWritableDatabase();

        //insert into table
        db.insert(TABLE_NAME,null,values);
        db.close();
    }



}
