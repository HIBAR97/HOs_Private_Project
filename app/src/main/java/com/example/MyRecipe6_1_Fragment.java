package com.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MyRecipe6_1_Fragment extends Fragment {
    private View view;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private MyRecipe5_Fragment myRecipe5_fragment;
    private MyRecipe6_2_Fragment myRecipe6_2_fragment;

    String[] Temp = {"90","91","92","93","94","95","96"};

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_myrecipe6_1, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();

        myRecipe5_fragment = new MyRecipe5_Fragment();
        myRecipe6_2_fragment = new MyRecipe6_2_Fragment();


        //----------선언--------------//
        Button btn_Prev = view.findViewById(R.id.Frg_myrecipe6_1_Prev);
        Button btn_Next = view.findViewById(R.id.Frg_myrecipe6_1_Next);
        Spinner spinner_Temp = view.findViewById(R.id.Frg_myrecipe6_Spinner1);

        //---------리스너----------//
        btn_Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe5_fragment).addToBackStack(null).commit();
            }
        });

        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe6_2_fragment).addToBackStack(null).commit();
            }
        });

        //---------어뎁터----------//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.fragment_myrecipe6_1, spinner_Temp);
//        spinner_Temp.setAdapter(adapter);
//        spinner_Temp.setSelection(0);

        return view;
    }
}
