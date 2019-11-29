package com.example.dkd71.google_intent_exam;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CommunityActivity extends AppCompatActivity {


    RatingBar ratingBar;
    EditText editText;
    ListView listView;
    ArrayList<String> mList;
    ArrayAdapter<String> mAdapter;
    String str, id, listitem = "";
    String[] data;
    float score;

    long now = System.currentTimeMillis();
    Date date = new Date(now);
    SimpleDateFormat sdfNow = new SimpleDateFormat("(yyyy/MM/dd HH:mm:ss)");
    String formatDate = sdfNow.format(date);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        editText = (EditText) findViewById(R.id.eText);
        listView = (ListView) findViewById(R.id.listview);
        ratingBar = (RatingBar) findViewById(R.id.ratingbar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                score = rating;
            }
        });

        mList = new ArrayList<>();
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mList);
        listView.setAdapter(mAdapter);


        SharedPreferences settings = getSharedPreferences("share", 0);
        id = settings.getString("id", "");


        SharedPreferences settings2 = getSharedPreferences("share_listitem", 0);
        listitem = settings2.getString("listitem", "");

        data = listitem.split("%");
        for(int i=0; i<data.length; i++) {
            mList.add(data[i]);
        }
        mAdapter.notifyDataSetChanged();


    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences("share_listitem", 0);
        SharedPreferences.Editor editor = settings.edit();
        String newdata = "";
        for (int i=0; i<mList.size(); i++) {
            newdata += mList.get(i) + "%";
        }
        editor.putString("listitem", newdata);
        editor.commit();
    }

    public void onClick(View view) {

        str = editText.getText().toString();
        mList.add(id + " " + formatDate + " " + score + "점\n" + str);
        mAdapter.notifyDataSetChanged();
    }

}
