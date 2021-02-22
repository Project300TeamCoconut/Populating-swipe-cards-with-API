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

public class MyAdapter extends ArrayAdapter {

    public MyAdapter(Context context, int resource, ArrayList<MovieModelClass> objects) {
        super(context, resource, objects);
    }


    public View getView(int position, View convertView, ViewGroup parent) {


       MovieModelClass movies = (MovieModelClass) getItem(position);

       if(convertView == null)
       {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
       }


       TextView name = (TextView) convertView.findViewById(R.id.name);

       name.setText(movies.getName());

       return convertView ;



    }
}






