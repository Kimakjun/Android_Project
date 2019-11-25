package com.example.dkd71.google_intent_exam;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataAdapter_show {
    protected static final String TAG = "DataAdapter_show";

    // TODO : TABLE 이름을 명시해야함
    protected static final String TABLE_NAME = "dataset";

    private final Context mContext2;
    private SQLiteDatabase mDb2;
    private DataBaseHelper_show mDbHelper_show;

    public DataAdapter_show(Context context) {
        this.mContext2 = context;
        mDbHelper_show = new DataBaseHelper_show(mContext2);
    }

    public DataAdapter_show createDatabase() throws SQLException {
        try {
            mDbHelper_show.createDataBase();
        } catch (IOException mIOException) {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public DataAdapter_show open() throws SQLException {
        try {
            mDbHelper_show.openDataBase();
            mDbHelper_show.close();
            mDb2 = mDbHelper_show.getReadableDatabase();
        } catch (SQLException mSQLException) {
            Log.e(TAG, "open >>" + mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close() {
        mDbHelper_show.close();
    }

    public List getTableData() {
        try {
            // Table 이름 -> antpool_bitcoin 불러오기
            String sql = "SELECT * FROM " + TABLE_NAME;

            // 모델 넣을 리스트 생성
            List userList2 = new ArrayList();

            // TODO : 모델 선언
            Datas datas = null;

            Cursor mCur = mDb2.rawQuery(sql, null);
            if (mCur != null) {
                // 칼럼의 마지막까지
                while (mCur.moveToNext()) {

                    // TODO : 커스텀 모델 생성
                    datas = new Datas();

                    // TODO : Record 기술
                    // id, name, account, privateKey, secretKey, Comment
                    datas.시군구코드=(mCur.getString(0));
                    datas.처분일자=(mCur.getString(1));
                    datas.교부번호=(mCur.getString(2));
                    datas.업종명=(mCur.getString(3));
                    datas.업태명=(mCur.getString(4));
                    datas.업소명=(mCur.getString(5));
                    datas.소재지도로명=(mCur.getString(6));
                    datas.소재지지번=(mCur.getString(7));
                    datas.지도점검일자=(mCur.getString(8));
                    datas.행정처분상태 =(mCur.getString(9));
                    datas.처분명=(mCur.getString(10));
                    datas.위반내역분류=(mCur.getString(11));
                    datas.법적근거=(mCur.getString(12));
                    datas.위반일자=(mCur.getString(13));
                    datas.위반내용=(mCur.getString(14));
                    datas.처분내용=(mCur.getString(15));
                    datas.처분기간=(mCur.getString(16));

                    // 리스트에 넣기
                    userList2.add(datas);
                }

            }
            return userList2;
        } catch (SQLException mSQLException) {
            Log.e(TAG, "getTestData >>" + mSQLException.toString());
            throw mSQLException;
        }
    }
}

