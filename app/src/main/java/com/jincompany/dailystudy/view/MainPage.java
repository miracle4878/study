package com.jincompany.dailystudy.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.jincompany.dailystudy.R;
import com.jincompany.dailystudy.utility.DateUtility;

/**
 * Created by Armor on 2015-12-03.
 */
public class MainPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        TextView date_text = (TextView) findViewById(R.id.date_text);
        DateUtility dateUtility = new DateUtility();

        date_text.setText(dateUtility.getNowDateWithFormat("yyyy.MM.dd"));

        //smsService 데이터를 가져와야함. 가져올 데이터는 발송된 전화번호를 통해 선택할 수 있어야함

    }
}
