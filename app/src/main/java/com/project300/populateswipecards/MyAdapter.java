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
    /*private Context mContext;
    private int mResource;
    private ArrayList<MovieModelClass> mData;*/

  //  private List<MovieModelClass> mData;

  //  private Context mContext;


    public MyAdapter(Context context, int resource, ArrayList<MovieModelClass> objects) {
        super(context, resource, objects);
        //this.mContext = context;
       // this.mData = objects;
       /* mContext = context;
        mResource = resource;
        mData = objects;*/
    }

    /*@Override
    public int getCount() {
        return mData.size();
    }*/

    public View getView(int position, View convertView, ViewGroup parent) {


       MovieModelClass movies = (MovieModelClass) getItem(position);

       if(convertView == null)
       {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
       }


       TextView name = (TextView) convertView.findViewById(R.id.name);

       name.setText(movies.getName());

       return convertView ;

       // String name = mData.get(position).getName();
       /* String color = mNotes.get(position).getColor();
        String location = mNotes.get(position).getLocation();
        String reminder = mNotes.get(position).getReminder();
        String image = mNotes.get(position).getImage();*/


       // MovieModelClass model = new MovieModelClass(name);

     //   LayoutInflater inflater = LayoutInflater.from(mContext);
     //   convertView = inflater.inflate(mResource, parent, false);


       // txt.setText(name);

     //   return convertView;


    }
}






