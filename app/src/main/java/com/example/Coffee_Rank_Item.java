package com.example;

public class Coffee_Rank_Item {

    public static int getIconDrawable() {
        return iconDrawable;
    }

    public static void setIconDrawable(int iconDrawable) {
        Coffee_Rank_Item.iconDrawable = iconDrawable;
    }

    private static int iconDrawable;

    public static String getCoffee_text() {
        return Coffee_text;
    }

    public void setCoffee_text(String coffee_text) {
        Coffee_text = coffee_text;
    }

    private static String Coffee_text;

}
