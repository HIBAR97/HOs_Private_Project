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

public class MyRecipe5_Fragment extends Fragment {
    private View view;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private MyRecipe4_Fragment myRecipe4_fragment;
    private MyRecipe6_1_Fragment myRecipe6_1_fragment;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_myrecipe5, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();

        myRecipe4_fragment = new MyRecipe4_Fragment();
        myRecipe6_1_fragment = new MyRecipe6_1_Fragment();

        //----------선언--------------//
        Button btn_Prev = view.findViewById(R.id.Frg_myrecipe5_Prev);
        Button btn_Next = view.findViewById(R.id.Frg_myrecipe5_Next);

        Spinner spinner_Temp = view.findViewById(R.id.Frg_myrecipe5_spinner1);
        Spinner spinner_Input_Water = view.findViewById(R.id.Frg_myrecipe5_spinner2);
        Spinner spinner_Water_Flow = view.findViewById(R.id.Frg_myrecipe5_spinner3);
        Spinner spinner_Extraction_Time = view.findViewById(R.id.Frg_myrecipe5_spinner4);

        //---------리스너----------//
        btn_Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe4_fragment).addToBackStack(null).commit();
            }
        });

        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe6_1_fragment).addToBackStack(null).commit();
            }
        });

        ArrayAdapter<CharSequence> spinner_Temp_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Temp, android.R.layout.simple_spinner_dropdown_item);
        spinner_Temp.setAdapter(spinner_Temp_adapter);
        spinner_Temp.setSelection(0);

        ArrayAdapter<CharSequence> spinner_Input_Water_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Input_Water, android.R.layout.simple_spinner_dropdown_item);
        spinner_Input_Water.setAdapter(spinner_Input_Water_adapter);
        spinner_Input_Water.setSelection(0);

        ArrayAdapter<CharSequence> spinner_Water_Flow_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Water_Flow, android.R.layout.simple_spinner_dropdown_item);
        spinner_Water_Flow.setAdapter(spinner_Water_Flow_adapter);
        spinner_Water_Flow.setSelection(0);

        ArrayAdapter<CharSequence> spinner_Extraction_Time_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Extration_Time, android.R.layout.simple_spinner_dropdown_item);
        spinner_Extraction_Time.setAdapter(spinner_Extraction_Time_adapter);
        spinner_Extraction_Time.setSelection(0);
        return view;
    }
}