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

public class MyRecipe_Fragment extends Fragment {

    private View view;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private MyRecipe2_Fragment myRecipe2_fragment;



    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_myrecipe, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();

        myRecipe2_fragment = new MyRecipe2_Fragment();

        //-------------- 선언 ---------------//
        Button BtnMake = view.findViewById(R.id.Frg_myrecipe_BtnMake);
        Button BtnList = view.findViewById(R.id.Frg_myrecipe_BtnList);

        //----------- 리스너 -----------------//
        BtnMake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe2_fragment).commitAllowingStateLoss();
            }
        });
        return view;
    }

}
