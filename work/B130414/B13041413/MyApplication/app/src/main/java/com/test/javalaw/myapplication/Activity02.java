package com.test.javalaw.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        Intent intent = new Intent();
        intent.putExtra("info", "Hello,this from Activity02!");
        setResult(101, intent);


        Button button2 = (Button) findViewById(R.id.button02);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String value = intent.getStringExtra("testIntent");
                TextView textView = (TextView) findViewById(R.id.textView2);
                textView.setText(value);
            }
        });

        Button buttonGetBundle = (Button) findViewById(R.id.buttonGetBundle);
        buttonGetBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                String userName = bundle.getString("userName");
                int nAge = bundle.getInt("age");
                TextView textView = (TextView) findViewById(R.id.textView2);
                textView.setText(userName + " 's age is" + nAge);

            }
        });

        Button buttonGetArrayList = (Button) findViewById(R.id.buttonGetArrayList);
        buttonGetArrayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                ArrayList arrayList = intent.getIntegerArrayListExtra("int");
                TextView textView = (TextView) findViewById(R.id.textView2);
                textView.setText(arrayList.toString());
            }
        });

        final Button buttonGetObject = (Button) findViewById(R.id.buttonGetObject);
        buttonGetObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Person person = (Person) intent.getSerializableExtra("person");
                TextView textView = (TextView) findViewById(R.id.textView2);
                textView.setText(person.getName() + "'s age is " + person.getAge());

            }
        });
    }

}
