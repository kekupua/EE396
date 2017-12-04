package org.tensorflow.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ky on 12/4/2017.
 */

class CustomAdapter extends ArrayAdapter<String>{

    public CustomAdapter(Context context, String[] classes) {
        super(context, R.layout.custom_row, classes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater classInflater = LayoutInflater.from(getContext());
        //One custom row
        View customView = null;
        if(customView==null) {
             customView =classInflater.inflate(R.layout.custom_row, parent, false);
        }

        String singleClassItem = getItem(position);
        TextView courseNum = (TextView) customView.findViewById(R.id.courseNum);
        TextView courseDay = (TextView) customView.findViewById(R.id.courseDay);

        courseNum.setText(singleClassItem);
        courseDay.setText(singleClassItem);

        return customView;
    }
}
