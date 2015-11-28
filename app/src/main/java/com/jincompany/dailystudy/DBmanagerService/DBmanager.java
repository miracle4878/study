package com.jincompany.dailystudy.DBmanagerService;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Armor on 2015-11-28.
 */
public class DBmanager extends SQLiteOpenHelper {
    public DBmanager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블을 생성한다.
        // create table 테이블명 (컬럼명 타입 옵션);
        db.execSQL("CREATE TABLE MEMBER_LIST( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, price INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
