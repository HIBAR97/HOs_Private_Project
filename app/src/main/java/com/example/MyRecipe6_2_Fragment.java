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

public class MyRecipe6_2_Fragment extends Fragment {
    private View view;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private MyRecipe6_1_Fragment myRecipe6_1_fragment;
    private MyRecipe6_3_Fragment myRecipe6_3_fragment;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_myrecipe6_2, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();

        myRecipe6_1_fragment = new MyRecipe6_1_Fragment();
        myRecipe6_3_fragment = new MyRecipe6_3_Fragment();

        //----------선언--------------//
        Button btn_Prev = view.findViewById(R.id.Frg_myrecipe6_2_Prev);
        Button btn_Next = view.findViewById(R.id.Frg_myrecipe6_2_Next);

        Spinner spinner_Temp = view.findViewById(R.id.Frg_myrecipe6_2_spinner1);
        Spinner spinner_Water = view.findViewById(R.id.Frg_myrecipe6_2_spinner2);
        Spinner spinner_Water_Flow = view.findViewById(R.id.Frg_myrecipe6_2_spinner3);
        Spinner spinner_Extraction_Time = view.findViewById(R.id.Frg_myrecipe6_2_spinner4);

        //---------리스너----------//
        btn_Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe6_1_fragment).addToBackStack(null).commit();
            }
        });

        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, myRecipe6_3_fragment).addToBackStack(null).commit();
            }
        });

        //---------스피너 어뎁터----------//
        ArrayAdapter<CharSequence> Temp_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Temp, android.R.layout.simple_spinner_dropdown_item);
        spinner_Temp.setAdapter(Temp_adapter);
        spinner_Temp.setSelection(0);

        ArrayAdapter<CharSequence> Water_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Water_mess, android.R.layout.simple_spinner_dropdown_item);
        spinner_Water.setAdapter(Water_adapter);
        spinner_Water.setSelection(0);

        ArrayAdapter<CharSequence> Water_Flow_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Water_Flow, android.R.layout.simple_spinner_dropdown_item);
        spinner_Water_Flow.setAdapter(Water_Flow_adapter);
        spinner_Water_Flow.setSelection(0);

        ArrayAdapter<CharSequence> Extraction_Time = ArrayAdapter.createFromResource(view.getContext(), R.array.Extration_Time, android.R.layout.simple_spinner_dropdown_item);
        spinner_Extraction_Time.setAdapter(Extraction_Time);
        spinner_Extraction_Time.setSelection(0);

        return view;
    }
}

