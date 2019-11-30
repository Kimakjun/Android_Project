package com.example.dkd71.google_intent_exam;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class ListViewShowActivity extends AppCompatActivity {

    private ListView m_oListView = null;
    private List<Datas> datalist;
    private ListAdapter oAdapter;
    private ArrayList<Datas> oData;
    private EditText show_lv_et;

        @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_listview);
        show_lv_et=(EditText)findViewById(R.id.show_lv_et);
        initLoadDB();
        oData = new ArrayList<>();
        for(int i=0; i<datalist.size(); i++){
            Datas oItem = new Datas();
            oItem.위반일자=datalist.get(i).위반일자;
            oItem.업소명 = datalist.get(i).업소명;
            oItem.처분내용 = datalist.get(i).처분내용;
            oItem.소재지지번 = datalist.get(i).소재지지번;
            oData.add(oItem);
        }
//        m_oListView = (ListView)findViewById(R.id.show_listvew_lv);
//        madapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, temp_data);
//        m_oListView.setAdapter(madapter);
        //초기값은 최근 위반한 날짜부터.
        Collections.sort(oData, new Comparator<Datas>() {
            @Override
            public int compare(Datas o1, Datas o2) {
                return o2.위반일자.compareTo(o1.위반일자);
            }
        });

        m_oListView = (ListView)findViewById(R.id.show_listvew_lv);
        oAdapter = new ListAdapter(oData);
        m_oListView.setAdapter(oAdapter);


    }

    public void onClick2(View view){
            String searchName = show_lv_et.getText().toString();
            ArrayList<Datas> arr = new ArrayList<>();
            searchName=searchName.replaceAll(" ","");
            for(Datas name : oData){
                String foundName = name.업소명;
                foundName= foundName.replaceAll(" ","");
                if(foundName.equals(searchName)){
                    arr.add(name);
                }
            }
            oAdapter = new ListAdapter(arr);
            m_oListView.setAdapter(oAdapter);
            oAdapter.notifyDataSetChanged();

    }

    public void onClick(View view){

        PopupMenu popup = new PopupMenu(getApplicationContext(),view);
        getMenuInflater().inflate(R.menu.listview_menu, popup.getMenu());
        oAdapter = new ListAdapter(oData);
        m_oListView.setAdapter(oAdapter);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu1:
                        Toast.makeText(getApplicationContext(), "업소별 오름차순으로 정렬", Toast.LENGTH_SHORT).show();
                        Collections.sort(oData, new Comparator<Datas>() {
                            @Override
                            public int compare(Datas o1, Datas o2) {
                                return o1.업소명.compareTo(o2.업소명);
                            }
                        });
                        oAdapter.notifyDataSetChanged();
                        break;

                    case R.id.menu2:
                        Toast.makeText(getApplicationContext(), "업소별 내림차순으로 정렬", Toast.LENGTH_SHORT).show();
                        Collections.sort(oData, new Comparator<Datas>() {
                            @Override
                            public int compare(Datas o2, Datas o1) {
                                return o1.업소명.compareTo(o2.업소명);
                            }
                        });
                        oAdapter.notifyDataSetChanged();
                        break;

                    case R.id.menu3:
                        Toast.makeText(getApplicationContext(), "날짜별 내림차순으로 정렬", Toast.LENGTH_SHORT).show();
                        Collections.sort(oData, new Comparator<Datas>() {
                            @Override
                            public int compare(Datas o2, Datas o1) {
                                return o1.위반일자.compareTo(o2.위반일자);
                            }
                        });
                        oAdapter.notifyDataSetChanged();
                        break;
                }
                return false;
            }
        });

        popup.show();//Popup Menu 보이기


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.listview_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

}
