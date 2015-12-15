package com.jincompany.dailystudy.member;

import android.content.Context;

import com.jincompany.dailystudy.DBmanagerService.DBManager;
import com.jincompany.dailystudy.member.DTO.MemberDTO;

import java.util.List;

/**
 * Created by Armor on 2015-11-19.
 */
public class MemberService {

    MemberDTO memberDTO = new MemberDTO();
    private final DBManager dbManager;

    public MemberService(Context context) {
        dbManager = new DBManager(context, "MEMBER.db", null, 1);
    }

    public boolean isLoginCheck(String id, String password) {
        List<MemberDTO> l = dbManager.selectUserInfoWithUserId("MEMBER_LIST", id);

        for (MemberDTO d : l) {
            if (d.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
