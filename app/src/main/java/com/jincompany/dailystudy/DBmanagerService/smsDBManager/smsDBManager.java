package com.jincompany.dailystudy.DBmanagerService.smsDBManager;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.jincompany.dailystudy.sms.DTO.SmsDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Armor on 2015-12-15.
 */
public class SmsDBManager {

    Cursor cur;

    public SmsDBManager(String smsURI, Context context) {
        cur = context.getContentResolver().query(Uri.parse(smsURI), null, null, null, null);
    }

    public List<SmsDTO> selectSMSData() {
        List<SmsDTO> smsDTO_list = new ArrayList();

        while (cur.moveToNext()) {
            SmsDTO smsDTO = new SmsDTO();

            smsDTO.setAddress(cur.getString(2));
            smsDTO.setDate_sent(cur.getInt(5));
            smsDTO.setContent(cur.getString(12));

            smsDTO_list.add(smsDTO);
        }
        return smsDTO_list;
    }
}
