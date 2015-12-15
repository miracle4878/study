package com.jincompany.dailystudy.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Armor on 2015-12-10.
 */
public class DateUtility {

    public String getNowDateWithFormat(String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }
}
