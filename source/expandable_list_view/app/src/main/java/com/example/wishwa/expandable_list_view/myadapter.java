package com.example.wishwa.expandable_list_view;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Wishwa on 06/09/2016.
 */

public class myadapter extends BaseExpandableListAdapter {

    private Context ctx;
    private HashMap<String,List<String>>Student_Year;
    private List<String>Student_List;

    public myadapter(Context ctx,HashMap<String,List<String>>Movies_category,List<String>Movies_List){
        this.ctx=ctx;
        this.Student_Year=Movies_category;
        this.Student_List=Movies_List;

    }

    @Override
    public int getGroupCount() {
        return Student_List.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return Student_Year.get(Student_List.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return Student_List.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return Student_Year.get(Student_List.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String group_title=(String) getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater inflater =(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.parent,parent,false);
        }
        TextView parent_textview = (TextView) convertView.findViewById(R.id.parent);

        parent_textview.setTypeface(null, Typeface.BOLD);
        parent_textview.setText(group_title);


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String child_title=(String) getChild(groupPosition,childPosition);
        if(convertView==null){
            LayoutInflater inflater =(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child,parent,false);
        }
        TextView child_textview = (TextView) convertView.findViewById(R.id.child);
        child_textview.setText(child_title);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
