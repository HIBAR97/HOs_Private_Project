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

public class MyRecipe4_Fragment extends Fragment {

    private View view;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private MyRecipe3_Fragment myRecipe3_fragment;
    private MyRecipe5_Fragment myRecipe5_fragment;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_myrecipe4, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();

        myRecipe3_fragment = new MyRecipe3_Fragment();
        myRecipe5_fragment = new MyRecipe5_Fragment();

        //----------선언--------------//
        Button btn_Prev = view.findViewById(R.id.Frg_myrecipe4_Prev);
        Button btn_Next = view.findViewById(R.id.Frg_myrecipe4_Next);

        //---------리스너----------//
        btn_Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe3_fragment).commitAllowingStateLoss();
            }
        });

        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe5_fragment).commitAllowingStateLoss();
            }
        });
        return view;
    }
}
