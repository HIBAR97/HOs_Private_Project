package com.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import javax.crypto.Mac;


public class Home_Fragment extends Fragment {

    private View view;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private CoffeeList_Fragment coffeeList_fragment;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //플레그먼트 컨테이너
        view = inflater.inflate(R.layout.fragment_home, container, false);

        view = inflater.inflate(R.layout.fragment_coffeelsit, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();

        coffeeList_fragment = new CoffeeList_Fragment();


        //----------선언--------------//
        RecyclerView Ad = view.findViewById(R.id.Frg_H_ad);
        RecyclerView brand = view.findViewById(R.id.Frg_H_brand);

        Button CfeList = view.findViewById(R.id.Btn_CfeList);
        Button RostaryList = view.findViewById(R.id.Btn_RostaryList);
        Button MyRecipe = view.findViewById(R.id.Btn_MyRecipe);
        Button RecipeRank = view.findViewById(R.id.Btn_RecipeRank);

        Button Live = view.findViewById(R.id.Btn_Live);
        Button Board = view.findViewById(R.id.Btn_Board);
        Button Machine = view.findViewById(R.id.Btn_Machine);

        //---------리스너----------//
        CfeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, coffeeList_fragment).commitAllowingStateLoss();

            }
        });

        RostaryList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        MyRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        RecipeRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Machine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }
}
