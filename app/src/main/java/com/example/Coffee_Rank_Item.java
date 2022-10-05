package com.example;

public class Coffee_Rank_Item {

    private int iconDrawable;
    private String Coffee_text;

    public void setTitle(String title){
        Coffee_text = title;
    }

    public void setIcon(int icon){iconDrawable = icon;}

    public String getTitle(){return this.Coffee_text;}

    public int getIcon() {
        return this.iconDrawable;
    }

}
