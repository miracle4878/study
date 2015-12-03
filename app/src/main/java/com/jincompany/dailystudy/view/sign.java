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

        final DBManager dbManager = new DBManager(getApplicationContext(), "MEMBER.db", null, 1);

        Button sign_btn = (Button) findViewById(R.id.sign_in);
        sign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputted_id = ((EditText) findViewById(R.id.inputted_id)).getText().toString();
                String inputted_password = ((EditText) findViewById(R.id.inputted_password)).getText().toString();
                String inputted_name = ((EditText) findViewById(R.id.inputted_name)).getText().toString();

                dbManager.insert("insert into MEMBER_LIST values(null, '" + inputted_id + "', '" + inputted_name + "', '" + inputted_id + "', '" + inputted_password + "');");

                Toast.makeText(getApplicationContext(),"가입완료 \n id:" + inputted_id,Toast.LENGTH_LONG).show();

                finish();
            }
        });

        Button back_btn = (Button) findViewById(R.id.back);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
