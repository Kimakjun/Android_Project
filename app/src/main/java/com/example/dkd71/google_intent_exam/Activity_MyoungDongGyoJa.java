package com.example.dkd71.google_intent_exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_MyoungDongGyoJa extends AppCompatActivity {
    TextView title_myeongdong;
    Button bt1;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity_myeongdong);
        title_myeongdong = (TextView) findViewById(R.id.title_myeongdong);
        bt1 = (Button) findViewById(R.id.button);
        title = title_myeongdong.getText().toString();
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, CommunityActivity.class);
        intent.putExtra("mode", 3);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}
