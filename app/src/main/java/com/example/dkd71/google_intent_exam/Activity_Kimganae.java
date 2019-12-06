package com.example.dkd71.google_intent_exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Kimganae extends AppCompatActivity {
    TextView title_kimganae;
    Button bt1;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity_kimganae);
        title_kimganae = (TextView) findViewById(R.id.title_kimganae);
        bt1 = (Button) findViewById(R.id.button);
        title = title_kimganae.getText().toString();
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, CommunityActivity.class);
        intent.putExtra("mode", 4);
        CommunityActivity.flag=0;
        intent.putExtra("title", title);
        startActivity(intent);
    }
}
