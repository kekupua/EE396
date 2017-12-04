package org.tensorflow.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.tensorflow.demo.env.Room;

import java.util.List;

/**
 * Created by Ky on 12/4/2017.
 */

class CustomAdapter extends BaseAdapter{

    private Context mContext;
    private List<Room> mRoomlist;

    public CustomAdapter(Context mContext, List<Room> mRoomlist) {
        this.mContext = mContext;
        this.mRoomlist = mRoomlist;
    }

    @Override
    public int getCount() {
        return mRoomlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mRoomlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View customView = View.inflate(mContext,R.layout.custom_row,null);

        TextView courseNum = (TextView) customView.findViewById(R.id.courseNum);
        TextView courseDay = (TextView) customView.findViewById(R.id.courseDay);
        TextView courseTime = (TextView) customView.findViewById(R.id.courseTime);

        //Set text values for each class
        courseNum.setText(mRoomlist.get(position).getCourseNum());
        courseDay.setText(mRoomlist.get(position).getCourseDay());
        courseTime.setText(mRoomlist.get(position).getCourseTime());

        return customView;
    }



/*
    public CustomAdapter(Context context, String[] classes) {
        super(context, R.layout.custom_row, classes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater classInflater = LayoutInflater.from(getContext());
        //One custom row
        View customView = classInflater.inflate(R.layout.custom_row, parent, false);

        String singleClassItem = getItem(position);
        TextView courseNum = (TextView) customView.findViewById(R.id.courseNum);
        TextView courseDay = (TextView) customView.findViewById(R.id.courseDay);

        courseNum.setText(singleClassItem);
        courseDay.setText(singleClassItem);

        return customView;
    }
   */
}
