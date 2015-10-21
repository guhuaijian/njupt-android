package com.test.javalaw.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity01 extends AppCompatActivity {
    final static String LOG_TAG = "MainActivity";
    final static int REQUEST_CODE_ACTIVITY02 = 200;

    private TextView mTextViewResultInfo = null;
    private Button mBtnStartAnotherActivity = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01);
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

        mTextViewResultInfo = (TextView) findViewById(R.id.textView);
        mBtnStartAnotherActivity = (Button) findViewById(R.id.btn_start_another_activity);
        mBtnStartAnotherActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity01.this, Activity02.class);
                startActivityForResult(intent, REQUEST_CODE_ACTIVITY02);
            }
        });


        Button button1 = (Button) findViewById(R.id.button01);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("testIntent", "123");
                intent.setClass(Activity01.this, Activity02.class);
                startActivity(intent);
            }
        });


        Button buttonBundle = (Button) findViewById(R.id.buttonBundle);
        buttonBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("userName", "zhang san");
                bundle.putInt("age", 20);
                intent.putExtras(bundle);
                intent.setClass(Activity01.this, Activity02.class);
                startActivity(intent);
            }
        });

        Button buttonArrayList = (Button) findViewById(R.id.buttonArrayList);
        buttonArrayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(1);
                arrayList.add(2);
                arrayList.add(3);
                intent.putIntegerArrayListExtra("int", arrayList);
                intent.setClass(Activity01.this, Activity02.class);
                startActivity(intent);
            }
        });

        Button buttonObject = (Button) findViewById(R.id.buttonObject);
        buttonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                person.setAge(20);
                person.setName("liuzhiwie");
                Intent intent = new Intent();
                intent.putExtra("person", person);
                intent.setClass(Activity01.this, Activity02.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_acitivity01, menu);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ACTIVITY02) {
            mTextViewResultInfo.setText(data.getStringExtra("info") + ";requestCode:" + requestCode + ";resultCode" + resultCode);
        }
    }
}
