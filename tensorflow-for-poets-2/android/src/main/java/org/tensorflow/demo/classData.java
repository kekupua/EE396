package org.tensorflow.demo;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.tensorflow.demo.DatabaseHelper;
import org.tensorflow.demo.env.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class classData extends Activity {

    DatabaseHelper mDataBase = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_data);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String title1 = getIntent().getStringExtra("Title");
        String confidence = getIntent().getStringExtra("Confidence");
        // Capture the layout's TextView and set the string as its text
        TextView title = (TextView) findViewById(R.id.title);
        title.setText(title1.toUpperCase());

        Button goBack = (Button) findViewById(R.id.goCamera);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //mDatabase is the Database class, getRoomclasses will return a List of "Room Objects" that matches the CourseLocation you passed
        //in (i.e. mDatabase.getRoomclasses("HOLM 387");
        List<Room> result;
        result = mDataBase.getRoomclasses("SAKAM C101");

        Log.d("CourseList","List: " + result);

    }


}
