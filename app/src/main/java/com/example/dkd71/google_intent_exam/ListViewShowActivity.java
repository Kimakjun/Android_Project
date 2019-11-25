package com.example.dkd71.google_intent_exam;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class ListViewShowActivity extends AppCompatActivity {

    private ListView m_oListView = null;
    private List<Datas> datalist;
    ArrayAdapter<String> madapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_listview);
        initLoadDB();

        ArrayList<Datas> oData = new ArrayList<>();
        List<String> temp_data = new LinkedList<>();


        for(int i=0; i<datalist.size(); i++){
            Datas oItem = new Datas();
            temp_data.add(datalist.get(i).업소명);
            oItem.업소명 = datalist.get(i).업소명;
            oItem.처분내용 = datalist.get(i).처분내용;
            oItem.소재지지번 = datalist.get(i).소재지지번;
            oData.add(oItem);
        }
//        m_oListView = (ListView)findViewById(R.id.show_listvew_lv);
//        madapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, temp_data);
//        m_oListView.setAdapter(madapter);

        m_oListView = (ListView)findViewById(R.id.show_listvew_lv);
        ListAdapter oAdapter = new ListAdapter(oData);
        m_oListView.setAdapter(oAdapter);


    }

    private void initLoadDB() {

        DataAdapter_show mDbHelper2 = new DataAdapter_show(getApplicationContext());
        mDbHelper2.createDatabase();
        mDbHelper2.open();

        // db에 있는 값들을 model을 적용해서 넣는다.
        datalist = mDbHelper2.getTableData();

//        for (int i = 0; i < datalist.size(); i++) {
//            ID_PW.put(datalist.get(i).id, userList.get(i).pw);
//            Log.d("tag" + i, userList.get(i).id + "," + userList.get(i).pw);
//        }

        // db 닫기
        mDbHelper2.close();
    }

}
