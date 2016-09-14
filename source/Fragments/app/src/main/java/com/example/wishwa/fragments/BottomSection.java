package com.example.wishwa.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BottomSection extends Fragment {

    private static TextView topmeme;
    private static TextView bottomeme;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_section_fragment,container,false);
        topmeme = (TextView)view.findViewById(R.id.textView1);
        bottomeme=(TextView)view.findViewById(R.id.textView2);
        return view;
    }

    public void setmemetext(String top,String bottom){
        topmeme.setText(top);
        bottomeme.setText(bottom);

    }
}
