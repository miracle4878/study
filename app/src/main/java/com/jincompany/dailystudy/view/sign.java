package com.jincompany.dailystudy.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jincompany.dailystudy.DBmanagerService.DBManager;
import com.jincompany.dailystudy.R;

/**
 * Created by Armor on 2015-11-30.
 */
public class Sign extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);

        final DBManager dbManager = new DBManager(getApplicationContext(), "jin.db", null, 1);

        Button btnInsert = (Button) findViewById(R.id.sign_in);
        btnInsert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // insert into 테이블명 values (값, 값, 값...);
                String inpputted_id = ((EditText) findViewById(R.id.inputted_id)).getText().toString();
                String inputted_password = ((EditText) findViewById(R.id.inputted_password)).getText().toString();
                String inputted_name = ((EditText) findViewById(R.id.inputted_name)).getText().toString();

                dbManager.insert("insert into MEMBER_LIST values(null, '" + inpputted_id + "', '" + inputted_name + "', '" + inpputted_id + "', '" + inputted_password + "');");
            }
        });
    }


}
