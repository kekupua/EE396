package org.tensorflow.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class classData extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_data);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        // String message = intent.getStringExtra(ClassifierActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView title = (TextView) findViewById(R.id.title);
        title.setText("Test Here");
    }
}
