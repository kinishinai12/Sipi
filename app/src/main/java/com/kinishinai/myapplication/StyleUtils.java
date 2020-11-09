package com.kinishinai.myapplication;

import java.util.ArrayList;

public class StyleUtils {
    private static StyleUtils instance;

    private StyleUtils(){
        if(null == allCitationStyle){
            allCitationStyle = new ArrayList<>();
            initData();
        }
    }

    private void initData() {
        allCitationStyle.add(new Styles(1,"APA","Book","7th edition", R.drawable.apa));
        allCitationStyle.add(new Styles(2,"APA","Website","7th edition", R.drawable.apa));
        allCitationStyle.add(new Styles(3,"APA","Journal","7th edition", R.drawable.apa));
        allCitationStyle.add(new Styles(4,"APA","Video","7th edition", R.drawable.apa));
        allCitationStyle.add(new Styles(5,"MLA","Book","8th edition", R.drawable.mla));
        allCitationStyle.add(new Styles(6,"MLA","Website","8th edition", R.drawable.mla));
        allCitationStyle.add(new Styles(7,"MLA","Journal","8th edition", R.drawable.mla));
        allCitationStyle.add(new Styles(8,"MLA","Video","8th edition", R.drawable.mla));
    }

    private static ArrayList<Styles> allCitationStyle;

    public static StyleUtils getInstance(){
        if(null != instance)
            return instance;
        else{
            instance = new StyleUtils();
            return instance;
        }
    }

    public static ArrayList<Styles> getAllCitationStyle() {
        return allCitationStyle;
    }
}
