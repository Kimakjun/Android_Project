package com.example.dkd71.google_intent_exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    TextView textView1, textView2;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        bt1 = (Button) findViewById(R.id.button);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, CommunityActivity.class);
        startActivity(intent);
    }
}
