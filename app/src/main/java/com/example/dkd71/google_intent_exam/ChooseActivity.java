package com.example.dkd71.google_intent_exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

    }

    public void onClick(View view){
        Intent intent1;
        switch (view.getId()){
            case R.id.choose_bt1:
                intent1 = new Intent(this,ChooseActivity.class);
                startActivity(intent1);
                break;

            case R.id.choose_bt2:
                intent1 = new Intent(this,ShowActivity.class);
                startActivity(intent1);
                break;

            case R.id.choose_bt3:
                intent1 = new Intent(this, ListViewShowActivity.class);
                startActivity(intent1);
                break;

        }
    }


}
