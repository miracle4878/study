package com.jincompany.dailystudy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jincompany.dailystudy.member.Member;
import com.jincompany.dailystudy.view.Sign;

public class MainActivity extends AppCompatActivity {

    private Button join_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button enter_btn = (Button) findViewById(R.id.enter);
        enter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = ((EditText) findViewById(R.id.userId)).getText().toString();
                String userPassword = ((EditText) findViewById(R.id.userPassword)).getText().toString();
                Context context = getApplicationContext();

                boolean validate = true;

                if (userId.isEmpty()) {
                    Toast.makeText(context, "input id", Toast.LENGTH_SHORT).show();
                    validate = false;
                }
                if (userPassword.isEmpty()) {
                    Toast.makeText(context, "input password", Toast.LENGTH_SHORT).show();
                    validate = false;
                }
                if (validate) {
                    Member member_info = new Member(context);
                    if (member_info.isLoginCheck(userId, userPassword)) {
                        Toast.makeText(context, "greeting", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(context, "join us", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void joinClicked(View view) {
        join_btn = (Button) findViewById(R.id.join);

        startActivity(new Intent(MainActivity.this, Sign.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
