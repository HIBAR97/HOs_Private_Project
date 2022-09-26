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

        Spinner spinner_Ice_Hot = view.findViewById(R.id.Frg_myrecipe4_Spinner1);
        Spinner spinner_Size = view.findViewById(R.id.Frg_myrecipe4_Spinner2);
        Spinner spinner_Using_Coffee = view.findViewById(R.id.Frg_myrecipe4_Spinner3);
        Spinner spinner_Water_Mess = view.findViewById(R.id.Frg_myrecipe4_Spinner4);
        Spinner spinner_Blooming = view.findViewById(R.id.Frg_myrecipe4_Spinner5);
        Spinner spinner_Extrection_Num = view.findViewById(R.id.Frg_myrecipe4_Spinner6);

        //---------리스너----------//
        btn_Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe3_fragment).addToBackStack(null).commit();
            }
        });

        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe5_fragment).addToBackStack(null).commit();
            }
        });

        ArrayAdapter<CharSequence> spinner_Ice_Hot_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Hot_Ice, android.R.layout.simple_spinner_dropdown_item);
        spinner_Ice_Hot.setAdapter(spinner_Ice_Hot_adapter);
        spinner_Ice_Hot.setSelection(0);

        ArrayAdapter<CharSequence> spinner_Size_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Coffee_Size, android.R.layout.simple_spinner_dropdown_item);
        spinner_Size.setAdapter(spinner_Size_adapter);
        spinner_Size.setSelection(0);

        ArrayAdapter<CharSequence> spinner_Using_Coffee_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Used_Beans, android.R.layout.simple_spinner_dropdown_item);
        spinner_Using_Coffee.setAdapter(spinner_Using_Coffee_adapter);
        spinner_Using_Coffee.setSelection(0);

        ArrayAdapter<CharSequence> spinner_Water_Mess_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Water_mess, android.R.layout.simple_spinner_dropdown_item);
        spinner_Water_Mess.setAdapter(spinner_Water_Mess_adapter);
        spinner_Water_Mess.setSelection(0);

        ArrayAdapter<CharSequence> spinner_Blooming_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Blooming, android.R.layout.simple_spinner_dropdown_item);
        spinner_Blooming.setAdapter(spinner_Blooming_adapter);
        spinner_Blooming.setSelection(0);

        ArrayAdapter<CharSequence> spinner_Extrection_Num_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Extraction_Num, android.R.layout.simple_spinner_dropdown_item);
        spinner_Extrection_Num.setAdapter(spinner_Extrection_Num_adapter);
        spinner_Extrection_Num.setSelection(0);
        return view;
    }
}
