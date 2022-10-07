package com.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BrandList_Fragment extends Fragment {

    private View view;
    private ListView BrandListView;
    private Coffee_Rank_ListviewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_brandlist, container, false);

        adapter = new Coffee_Rank_ListviewAdapter();

        BrandListView = view.findViewById(R.id.Frg_board_ListView);
        BrandListView.setAdapter(adapter);

        //adapter.addItem();

        return view;
    }

}
