package com.jincompany.dailystudy;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.jincompany.dailystudy.member.Member;

public class MainActivity extends AppCompatActivity {

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


    }

    public void enterClicked(View view) {
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
            Member m = new Member();
            if (m.isMember(userId) && m.isPassPassword(userId,userPassword) ) {
                Toast.makeText(context, "greeting", Toast.LENGTH_SHORT).show();
            }
        }


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