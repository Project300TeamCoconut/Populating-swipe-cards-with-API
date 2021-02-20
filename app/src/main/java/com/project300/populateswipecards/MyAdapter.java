package com.project300.populateswipecards;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<MovieModelClass> {
    private Context mContext;
    private int mResource;
    private ArrayList<MovieModelClass> mData;

    public MyAdapter(@NonNull Context context, int resource, ArrayList<MovieModelClass> objects) {
        super(context, resource);
        mContext = context;
        mResource = resource;
        mData = objects;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        String name = mData.get(position).getName();
       /* String color = mNotes.get(position).getColor();
        String location = mNotes.get(position).getLocation();
        String reminder = mNotes.get(position).getReminder();
        String image = mNotes.get(position).getImage();*/


        MovieModelClass model = new MovieModelClass(name);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);


        TextView txt = convertView.findViewById(R.id.helloText);

        txt.setText(name);

        return convertView;


    }
}






