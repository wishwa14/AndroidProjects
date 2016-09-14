package com.example.wishwa.expandable_list_view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Wishwa on 06/09/2016.
 */

public class info {

    public static HashMap<String , List<String>> getinfo(){
        HashMap<String,List<String>> StudentDetails = new HashMap<String, List<String>>();





        List<String> First_Year = new ArrayList<String>();
        First_Year.add("Shehan");
        First_Year.add("Chamathka");
        First_Year.add("Anjana");
        First_Year.add("Ravindu");

        List<String> Second_Year= new ArrayList<String>();
        Second_Year.add("Nimasha");
        Second_Year.add("Buddhi");
        Second_Year.add("Gothami");
        Second_Year.add("Harini");

        List<String> Third_Year= new ArrayList<String>();
        Third_Year.add("Wishwa");
        Third_Year.add("Ashan");
        Third_Year.add("Pasan");
        Third_Year.add("Chamath");

        List<String> Fourth_year= new ArrayList<String>();
        Fourth_year.add("Raveen");
        Fourth_year.add("Lahiru");
        Fourth_year.add("Milindu");

        StudentDetails.put("Fourth Year",Fourth_year);
        StudentDetails.put("Third year",Third_Year);
        StudentDetails.put("Second Year",Second_Year);
        StudentDetails.put("First Year",First_Year);



        return  StudentDetails;

    }
}
