/*
 * Copyright (C) 2016 WITC 
 */

package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Rene Bylander 
 * @created: Mar 29, 2016
 */
public class ListData {
    
    private static final ArrayList<String> months = new ArrayList<>(20);
    private static final ArrayList<Integer> years = new ArrayList<>();
    private static final ArrayList<String> phoneTypes = new ArrayList<>();
    
    public static ArrayList<String> getMonths(){
        fillMonths();
        return months;
    }
    public static ArrayList<Integer> getYears(){
        fillYears();
        return years;
    }

    public static ArrayList<String> getPhoneTypes() {
        fillPhoneTypes();
        return phoneTypes;
    }
    
    private static void fillMonths(){
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December"); 
        
        
    }
    private static void fillYears(){
        //Java 8
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        //pre-Java 8 (import java.util.calendar)
        //Calendar calendar = Calendar.getInstance();
        //int year = calendar.get(Calendar.YEAR);

        for(int i = 0; i < 2; i++){
            years.add(year--);
        } 
        years.add(year);
    }

    private static void fillPhoneTypes() {
        phoneTypes.add("Primary");
        phoneTypes.add("Secondary");
        phoneTypes.add("Other");
        
    }
}
