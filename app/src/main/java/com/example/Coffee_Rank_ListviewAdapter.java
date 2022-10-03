package com.example;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Coffee_Rank_ListviewAdapter extends BaseAdapter {
    private TextView CoffeeText;
    private ImageView CoffeeImage;

    private ArrayList<Coffee_Rank_Item> listVuewItemList = new ArrayList<Coffee_Rank_Item>();


    @Override
    public int getCount() {
        return Coffee_Rank_Item.size();
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
        return null;
    }


}
