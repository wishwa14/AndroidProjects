package com.example.wishwa.myapplication;

/**
 * Created by Wishwa on 05/09/2016.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MyAdapter extends BaseAdapter {

    String nameList[];
    int user[];
    LayoutInflater inflter;

    public MyAdapter(Context applicationContext, String[] nameList, int[] user) {

        this.nameList = nameList;
        this.user = user;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return nameList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_listview, null);
        TextView name = (TextView) view.findViewById(R.id.textView);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        name.setText(nameList[i]);
        icon.setImageResource(user[i]);
        return view;
    }
}