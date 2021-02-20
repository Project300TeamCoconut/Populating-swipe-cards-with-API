package com.project300.populateswipecards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListResourceBundle;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> al;
    private ArrayAdapter<MovieModelClass> arrayAdapter;
    private ArrayList<MovieModelClass> movieList = new ArrayList<>();
    private int i;
    String moviename = "";
    Context context;


    SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);


    private static String JSON_URL = "https://api.themoviedb.org/3/movie/popular?api_key=8099f5720bad1f61f020fdbc855f73db";
    //List<MovieModelClass> movieList;
    //@InjectView(R.id.frame) SwipeFlingAdapterView flingContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        GetData getData = new GetData();
        getData.execute();




        //AddArray();

        // ButterKnife.inject(this);

        //this add is the name of the card, with each add another card is added
        //adds into array
        //the array has a text and a layout we create
        //this layout is the card in itself textview picture ect...



        //this is when it actually swipes(clicks and movies)


        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {


            //every time a card is completely removed he just removes it from the array
            //notifies the adapter of this change
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
              //  Log.d("LIST", "removed object!");
              //  movieList.remove(0);
              //  arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
               // movieList.add();
             //   arrayAdapter.notifyDataSetChanged();
             //   Log.d("LIST", "notified");
              //  i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
               /* View view = flingContainer.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);*/
            }


        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public class GetData extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {

            String current = "";

            try {
                URL url;
                HttpURLConnection urlConnection = null;

                try {

                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while (data != -1) {
                        current += (char) data;
                        data = isr.read();
                    }

                    return current;

                } catch (MalformedURLException e) {
                    e.printStackTrace();;
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        //  urlConnection.disconnect();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            return current;
        }

        @Override
        protected void onPostExecute(@org.jetbrains.annotations.NotNull String s){



            try{
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("results");

                for(int i = 0; i< jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);


                    MovieModelClass model = new MovieModelClass();

                    movieList = new ArrayList<>();
                    //  model.setId(jsonObject1.getString("vote_average"));
                    //   model.setName(jsonObject1.getString("title"));
                    //  model.setImg(jsonObject1.getString("poster_path"));


                    moviename = jsonObject1.getString("title");
                    model.setName(moviename);
                    movieList.add(model);


                    arrayAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.item, R.id.helloText, movieList);

                    flingContainer.setAdapter(arrayAdapter);

                    arrayAdapter.notifyDataSetChanged();


                }


            } catch (JSONException e) {
                e.printStackTrace();
            }




        }
    }




    public void AddArray() {

        al = new ArrayList<>();
        al.add("php");
        al.add("c");
        al.add("python");
        al.add("java");
        al.add("html");
        al.add("c++");
        al.add("css");
        al.add("javascript");

    }
}

    /*static void makeToast(Context ctx, String s){
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.right)
    public void right() {
        /**
         * Trigger the right event manually.
         */
      //  flingContainer.getTopCardListener().selectRight();
    /*}

    @OnClick(R.id.left)
    public void left() {
        flingContainer.getTopCardListener().selectLeft();
    }*/




