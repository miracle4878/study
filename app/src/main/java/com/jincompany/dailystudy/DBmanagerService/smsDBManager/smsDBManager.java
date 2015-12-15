package com.jincompany.dailystudy.DBmanagerService.smsDBManager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.jincompany.dailystudy.sms.DTO.smsDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Armor on 2015-12-15.
 */
public class smsDBManager extends SQLiteOpenHelper {

    public smsDBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<smsDTO> selectSMSData() {
        SQLiteDatabase db = getReadableDatabase();

        List smsDTO_list = new ArrayList<>();

        Cursor cursor = db.rawQuery("select address, date_sent, body from smsService;", null);
        while (cursor.moveToNext()) {
            smsDTO smsDTO = new smsDTO();

            smsDTO.setAddress(cursor.getString(1));
            smsDTO.setDate_sent(cursor.getInt(2));
            smsDTO.setContent(cursor.getString(3));

            smsDTO_list.add(smsDTO);
        }

        return smsDTO_list;
    }
}
