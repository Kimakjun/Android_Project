package com.example.dkd71.google_intent_exam;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CommunityActivity extends AppCompatActivity {

    EditText editText;
    ListView listView;
    LinkedList<String> mList;
    ArrayAdapter<String> mAdapter;
    String str, id;

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
        mList = new LinkedList<String>();
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mList);

        SharedPreferences settings = getSharedPreferences("share", 0);
        id = settings.getString("id", "");
        listView.setAdapter(mAdapter);
    }

    public void onClicked(View view) {
        str = editText.getText().toString();
        mList.add(id + " " + formatDate + "\n" + str);
        mAdapter.notifyDataSetChanged();
    }


}
