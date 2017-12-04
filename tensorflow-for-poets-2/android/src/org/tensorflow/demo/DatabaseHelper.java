package org.tensorflow.demo;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.tensorflow.demo.env.Room;

import java.sql.SQLInput;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "rooms";
    private static final String DATABASE_NAME = "Rooms.db";
    private static final String DATABASE_PATH = "/data/data/org.tensorflow.demo/databases/";

    private static final String COL_1 = "_CourseNum";
    private static final String COL_2 = "_CourseTitle";
    private static final String COL_3 = "_CourseInstr";
    private static final String COL_4 = "_CourseDay";
    private static final String COL_5 = "_CourseTime";
    private static final String COL_6 = "_CourseLoc";
    private static final String COL_7 = "_ID";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


            //SQL command
            String createTable = "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_7 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_1 + " TEXT," +
                    COL_2 + " TEXT," +
                    COL_3 + " TEXT," +
                    COL_4 + " TEXT," +
                    COL_5 + " TEXT," +
                    COL_6 + " TEXT" +
                    ");";
            db.execSQL(createTable);
            Log.d("CreateDB", "Database Created");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(String.format("DROP IF TABLE EXISTS%s", TABLE_NAME));
        onCreate(db);
    }


    public void testaddData(Room classroom){

        ContentValues values = new ContentValues();
        values.put(COL_1, classroom.getCourseNum());
        values.put(COL_2, classroom.getCourseTitle());
        values.put(COL_3, classroom.getCourseInstr());
        values.put(COL_4, classroom.getCourseDay());
        values.put(COL_5, classroom.getCourseTime());
        values.put(COL_6, classroom.getCourseLoc());
        SQLiteDatabase db = getWritableDatabase();

        //insert into table
        db.insert(TABLE_NAME, null, values);
        Log.d("testaddData", "Just added to db: " + values);
        db.close();

    }

    //Return list of data
    public ArrayList<Room> getRoomclasses(String courseLoc){
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<Room> resultList= new ArrayList<>();

        String CourseNum = "";
        String CourseTitle = "";
        String CourseInstr = "";
        String CourseDay = "";
        String CourseTime = "";
        String CourseLoc = "";


        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_6 + " = '" + courseLoc + "';";
//        Log.d("StringQuery", "query:" + query );
        //Cursor points to location of result
        Cursor c = db.rawQuery(query, null);
        //Move to first row in result
        c.moveToFirst();

        if (c.getCount() == 0){
            Log.d("No Data", "No Data for:" + courseLoc );
        }
        else {

            while (!c.isAfterLast()) {
                if (c.getString(c.getColumnIndex(COL_6)) != null) {
                    //Retrieve values of results per row
                    CourseNum = c.getString(c.getColumnIndex(COL_1));
                    CourseTitle = c.getString(c.getColumnIndex(COL_2));
                    CourseInstr = c.getString(c.getColumnIndex(COL_3));
                    CourseDay = c.getString(c.getColumnIndex(COL_4));
                    CourseTime = c.getString(c.getColumnIndex(COL_5));
                    CourseLoc = c.getString(c.getColumnIndex(COL_6));
                }
                //turn results into object
                Room result = new Room(CourseNum,CourseTitle,CourseInstr,CourseDay,CourseTime,CourseLoc);
//                Log.d("CourseLocationTest:", "Course Info:" + result);
                resultList.add(result);
                c.moveToNext();
            }

            db.close();
        }
        return resultList;
    }

    public boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase(DATABASE_PATH + DATABASE_NAME, null,
                    SQLiteDatabase.OPEN_READONLY);
            checkDB.close();
        } catch (SQLiteException e) {
            // database doesn't exist yet.
        }
        return checkDB != null;
    }

}
