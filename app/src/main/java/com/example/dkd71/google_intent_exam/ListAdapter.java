package com.example.dkd71.google_intent_exam;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter
{
    LayoutInflater inflater = null;
    private ArrayList<Datas> m_oData = null;
    private int nListCnt = 0;

    public ListAdapter(ArrayList<Datas> _oData)
    {
        m_oData = _oData;
        nListCnt = m_oData.size();
    }

    @Override
    public int getCount()
    {
        Log.i("TAG", "getCount");
        return nListCnt;
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            final Context context = parent.getContext();
            if (inflater == null)
            {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            convertView = inflater.inflate(R.layout.activity_listview, parent, false);
        }

        TextView oTextTitle = (TextView) convertView.findViewById(R.id.textTitle);
        TextView oTextContents = (TextView) convertView.findViewById(R.id.textContents);
        TextView oTextAddress = (TextView) convertView.findViewById(R.id.textAddress);


        oTextTitle.setText(m_oData.get(position).업소명);
        oTextContents.setText(m_oData.get(position).처분내용);
        oTextAddress.setText(m_oData.get(position).소재지지번);
        return convertView;
    }
}

