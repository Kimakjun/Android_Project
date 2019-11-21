package com.example.dkd71.google_intent_exam;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText Login_et1;
    EditText Login_et2;
    Button Login_bt;
    List<Members> userList;
    Map<String, String> ID_PW;
    LinearLayout Login_ll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ID_PW = new HashMap<>();
        Login_et1 = (EditText) findViewById(R.id.Login_et1);
        Login_et2 = (EditText) findViewById(R.id.Login_et2);
        Login_bt = (Button) findViewById(R.id.Login_bt);
        Login_ll = (LinearLayout) findViewById(R.id.Login_ll);
        initLoadDB();
        Login_bt.setBackgroundColor(getResources().getColor(R.color.colorBlueGray));
        Login_ll.setBackgroundColor(getResources().getColor(R.color.colorBackground));
    }

    private void initLoadDB() {

        DataAdapter mDbHelper = new DataAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        // db에 있는 값들을 model을 적용해서 넣는다.
        userList = mDbHelper.getTableData();

        for (int i = 0; i < userList.size(); i++) {
            ID_PW.put(userList.get(i).id, userList.get(i).pw);
            Log.d("tag" + i, userList.get(i).id + "," + userList.get(i).pw);
        }

        // db 닫기
        mDbHelper.close();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Login_bt:
                String inputID = Login_et1.getText().toString();
                String inputPW = Login_et2.getText().toString();
                if (ID_PW.keySet().contains(inputID)) { // ID가 DB안에 있으면

                    if (ID_PW.get(inputID).equals(inputPW)) {
                        Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, MAIN.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "비밀번호 틀림", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "없는 아이디 입니다", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}

