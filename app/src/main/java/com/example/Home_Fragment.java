package com.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;


public class Home_Fragment extends Fragment {

    private View view;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private CoffeeList_Fragment coffeeList_fragment;
    private BrandList_Fragment brandList_fragment;
    private MyRecipe_Fragment myRecipe_fragment;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //플레그먼트 컨테이너
        view = inflater.inflate(R.layout.fragment_home, container, false);


        fragmentManager = getActivity().getSupportFragmentManager();

        coffeeList_fragment = new CoffeeList_Fragment();
        brandList_fragment = new BrandList_Fragment();
        myRecipe_fragment = new MyRecipe_Fragment();


        //----------선언--------------//
        RecyclerView Ad = view.findViewById(R.id.Frg_H_ad);
        RecyclerView brand = view.findViewById(R.id.Frg_H_brand);

        Button CfeList = (Button)view.findViewById(R.id.Btn_CfeList);
        Button BrandList = view.findViewById(R.id.Btn_BrandList);
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

        BrandList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, brandList_fragment).commitAllowingStateLoss();
            }
        });

        MyRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe_fragment).commitAllowingStateLoss();
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
