package com.example.wishwa.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TopSection extends Fragment {

    private static EditText toptext;
    private static EditText bottomtext;

   Topsectionlistener activitycommander;

    public interface Topsectionlistener{
        public void creatememe(String top,String bottom) ;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activitycommander = (Topsectionlistener)activity;

        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment,container,false);
        toptext = (EditText) view.findViewById(R.id.toptext);
        bottomtext = (EditText)view.findViewById(R.id.bottomtext);
        final Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        buttonclicked(v);

                    }
                }

        );
        return view;
    }

    public void buttonclicked(View view){

        activitycommander.creatememe(toptext.getText().toString(),bottomtext.getText().toString());

    }
}
