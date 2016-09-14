package com.example.wishwa.expandable_list_view;

import android.app.Activity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {

    HashMap<String,List<String>>Student_Year;
    List<String> student_list;
    ExpandableListView exp_list;
    myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exp_list = (ExpandableListView) findViewById(R.id.exp_list);
        Student_Year = info.getinfo();
        student_list = new ArrayList<String>(Student_Year.keySet());
        adapter = new myadapter(this,Student_Year,student_list);
        exp_list.setAdapter(adapter);
    }
}
