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

public class MyRecipe2_Fragment extends Fragment {

    private View view;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private MyRecipe_Fragment myRecipe_fragment;
    private MyRecipe3_Fragment myRecipe3_fragment;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_myrecipe2, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();

        myRecipe_fragment = new MyRecipe_Fragment();
        myRecipe3_fragment = new MyRecipe3_Fragment();


        //----------선언--------------//
        Button btn_Prev = view.findViewById(R.id.Frg_myrecipe2_Prev);
        Button btn_Next = view.findViewById(R.id.Frg_myrecipe2_Next);

        Spinner spinner_Coffee_Name = view.findViewById(R.id.Frg_myrecipe2_Spinner1);

        //---------리스너----------//
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe3_fragment).addToBackStack(null).commit();
            }
        });

        btn_Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe_fragment).addToBackStack(null).commit();
            }
        });

        //---------스피너 어뎁터----------//
        ArrayAdapter<CharSequence> Coffee_Name_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Coffee_naeme, android.R.layout.simple_spinner_dropdown_item);
        spinner_Coffee_Name.setAdapter(Coffee_Name_adapter);
        spinner_Coffee_Name.setSelection(0);

        return view;
    }
}
