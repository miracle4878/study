package com.jincompany.dailystudy.member;

import com.jincompany.dailystudy.member.DTO.MemberDTO;

/**
 * Created by Armor on 2015-11-19.
 */
public class Member {
    MemberDTO memberDTO= new MemberDTO();

    public boolean isMember(String id){

        return true;
    }

    public boolean isPassPassword(String id,String password){

        return true;
    }
}
