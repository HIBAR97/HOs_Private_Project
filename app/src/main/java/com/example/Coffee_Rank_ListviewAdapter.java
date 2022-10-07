package com.example;

import android.content.Context;
import android.view.LayoutInflater;
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

    private ArrayList<Coffee_Rank_Item> listViewItemList = new ArrayList<Coffee_Rank_Item>();

    public Coffee_Rank_ListviewAdapter(){

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        if (converView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            converView = inflater.inflate(R.layout.listview_coffee_ranking, parent, false);
        }

        CoffeeText = converView.findViewById(R.id.LV_Coffee_txt);
        CoffeeImage = converView.findViewById(R.id.LV_Coffee_IV);

        Coffee_Rank_Item listViewItem = listViewItemList.get(position);
        
        CoffeeText.setText(Coffee_Rank_Item.getCoffee_text());
        CoffeeImage.setImageResource(Coffee_Rank_Item.getIconDrawable());

        return converView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }


    public void addItem(String title, int Image) {
        Coffee_Rank_Item Coffee_Rank_Item = new Coffee_Rank_Item();

        Coffee_Rank_Item.setCoffee_text(title);
        Coffee_Rank_Item.setIconDrawable(Image);

        listViewItemList.add(Coffee_Rank_Item);

    }
}
