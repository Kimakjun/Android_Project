package com.example.dkd71.google_intent_exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_PlidongMyeonok extends AppCompatActivity {
    TextView title_pildong;
    Button button_pildong;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity_pildong);
        title_pildong = (TextView) findViewById(R.id.title_pildong);
        button_pildong = (Button) findViewById(R.id.button_pildong);
        title = title_pildong.getText().toString();
    }



    public void onClick(View view) {
        Intent intent = new Intent(this, CommunityActivity.class);
        intent.putExtra("mode", 1);
        CommunityActivity.flag=0;
        intent.putExtra("title", title);
        startActivity(intent);
    }
}
