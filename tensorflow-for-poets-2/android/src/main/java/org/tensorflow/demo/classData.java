package org.tensorflow.demo;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.tensorflow.demo.DatabaseHelper;
import org.tensorflow.demo.env.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


public class classData extends Activity {

    DatabaseHelper mDataBase = new DatabaseHelper(this);
    private CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_data);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String roomTitle = intent.getStringExtra("Title");
        roomTitle = parseRoom(roomTitle);
        //Get day of week
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);

        // Capture the layout's TextView and set the string as its text
        TextView title = (TextView) findViewById(R.id.title);
        title.setText(roomTitle.toUpperCase());

        TextView DayofWeek = (TextView) findViewById(R.id.Dayofweek);
        DayofWeek.setText(dayOfTheWeek);

        Button goBack = (Button) findViewById(R.id.goCamera);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //mDatabase is the Database class, getRoomclasses will return a List of "Room Objects" that matches the CourseLocation you passed
        //in (i.e. mDatabase.getRoomclasses("HOLM 387");

        ArrayList<Room> result;

        Log.d("Room Title", "Room Title: " + roomTitle);

        result = mDataBase.getRoomclasses("ART 132");

        result = filterRooms(result);

        ListView classes = (ListView) findViewById(R.id.classes);

        //create adapter
        adapter = new CustomAdapter(getApplicationContext(),result);
        classes.setAdapter(adapter);

        //Set onClick Listener

        classes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //what happens on click
                String thisCourseTitle = view.getTag().toString();
                Toast toast = Toast.makeText(getApplicationContext(), thisCourseTitle, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        //Log.d("CourseList","List: " + result);

    }

    private String[][] getValuesOfObjects(ArrayList<Room> result){
        String[] courseNum = new String[result.size()];
        String[] courseTitle = new String[result.size()];
        String[] courseInstr = new String[result.size()];
        String[] courseDay = new String[result.size()];
        String[] courseTime = new String[result.size()];
        String[] courseLoc = new String[result.size()];

        //Turn result objects into string arrays
        for (int i = 0; i<result.size(); i++){
            courseNum[i] = result.get(i).getCourseNum();
            courseTitle[i] = result.get(i).getCourseTitle();
            courseInstr[i] = result.get(i).getCourseInstr();
            courseDay[i] = result.get(i).getCourseDay();
            courseTime[i] = result.get(i).getCourseTime();
            courseLoc[i] = result.get(i).getCourseLoc();
        }

        //store array of result strings into an array
        String[] resultValues[] = {courseNum,courseTitle,courseInstr,courseDay,courseTime,courseLoc};

        return resultValues;
    }


    private String parseRoom(String room) {
        if (room.charAt(0)=='h' && room.charAt(1)=='h') {
            return "HOLM " + room.substring(2);
        }
        return room;
    }

    private ArrayList<Room> filterRooms(List<Room> allRooms){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        char DotW;
        switch (day) {
            case 2:
                DotW = 'M';
                break;
            case 3:
                DotW = 'T';
                break;
            case 4:
                DotW = 'W';
                break;
            case 5:
                DotW = 'R';
                break;
            case 6:
                DotW = 'F';
                break;
            case 7:
                DotW = 'S';
                break;
            default:
                DotW = 'T';
        }
  //      DotW = 'T';
        ArrayList<Room> filtered = new ArrayList<>();
        for (Room item : allRooms) {
            if(item.getCourseDay().indexOf(DotW) >= 0){
                filtered.add(item);
            }
        }

        if (!filtered.isEmpty()) {
            Collections.sort(filtered, new Comparator<Room>() {
                @Override
                public int compare(Room r1, Room r2) {
                    //You should ensure that list doesn't contain null values!
                    String r1Time = r1.getCourseTime();
                    char m1 = r1Time.charAt(9);
                    r1Time = r1Time.substring(5,9);
                    int r1I = Integer.parseInt(r1Time);
                    if(m1 == 'p' && r1I-1200<0){
                        r1I = r1I + 1200;
                    }

                    String r2Time = r2.getCourseTime();
                    char m2 = r2Time.charAt(9);
                    r2Time = r2Time.substring(5,9);
                    int r2I = Integer.parseInt(r2Time);
                    if(m2 == 'p' && r2I-1200<0){
                        r2I = r2I + 1200;
                    }

                    return r1I-r2I;
                }
            });
        }

        return filtered;
    }


}
