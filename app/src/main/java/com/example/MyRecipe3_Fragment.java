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

public class MyRecipe3_Fragment extends Fragment {

    private View view;


    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private MyRecipe2_Fragment myRecipe2_fragment;
    private MyRecipe4_Fragment myRecipe4_fragment;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_myrecipe3, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();

        myRecipe2_fragment = new MyRecipe2_Fragment();
        myRecipe4_fragment = new MyRecipe4_Fragment();

        //----------선언--------------//
        Button btn_Prev = view.findViewById(R.id.Frg_myrecipe3_Prev);
        Button btn_Next = view.findViewById(R.id.Frg_myrecipe3_Next);

        //---------리스너----------//
        btn_Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe2_fragment).addToBackStack(null).commit();
            }
        });

        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe4_fragment).addToBackStack(null).commit();
            }
        });

        return view;
    }
}
