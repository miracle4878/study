package com.jincompany.dailystudy.DBmanagerService;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jincompany.dailystudy.member.DTO.MemberDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Armor on 2015-11-28.
 */
public class DBManager extends SQLiteOpenHelper {

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블을 생성한다.
        // create table 테이블명 (컬럼명 타입 옵션);
        db.execSQL("CREATE TABLE MEMBER_LIST(unique_id INTEGER PRIMARY KEY AUTOINCREMENT, user_id TEXT, user_name TEXT, user_email TEXT, user_password TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void update(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void delete(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public List<MemberDTO> selectUserInfoWithUserId(String table_name, String user_id) {
        SQLiteDatabase db = getReadableDatabase();

        List MemberDTO_list = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from " + table_name + " where user_id =" + user_id, null);
        while (cursor.moveToNext()) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setId(cursor.getString(1));
            memberDTO.setName(cursor.getString(2));
            memberDTO.setEmail(cursor.getString(3));
            memberDTO.setPassword(cursor.getString(4));

            MemberDTO_list.add(memberDTO);
        }

        return MemberDTO_list;
    }
}
