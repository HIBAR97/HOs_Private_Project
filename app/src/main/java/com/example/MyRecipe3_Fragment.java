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

        Spinner spinner_Recommend_Water = view.findViewById(R.id.Frg_myrecipe3_Spinner1);
        Spinner spinner_Crushing_Degree = view.findViewById(R.id.Frg_myrecipe3_Spinner2);
        Spinner spinner_Roasting = view.findViewById(R.id.Frg_myrecipe3_Spinner3);
        Spinner spinner_Production_Year = view.findViewById(R.id.Frg_myrecipe3_Spinner4);

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

        ArrayAdapter<CharSequence> Coffee_Recommend_Water_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Recommend_Water, android.R.layout.simple_spinner_dropdown_item);
        spinner_Recommend_Water.setAdapter(Coffee_Recommend_Water_adapter);
        spinner_Recommend_Water.setSelection(0);

        ArrayAdapter<CharSequence> Coffee_Crushing_Degree_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Crushing_Degree, android.R.layout.simple_spinner_dropdown_item);
        spinner_Crushing_Degree.setAdapter(Coffee_Crushing_Degree_adapter);
        spinner_Crushing_Degree.setSelection(0);

        ArrayAdapter<CharSequence> Coffee_Roasting_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Roasting, android.R.layout.simple_spinner_dropdown_item);
        spinner_Roasting.setAdapter(Coffee_Roasting_adapter);
        spinner_Roasting.setSelection(0);


        ArrayAdapter<CharSequence> Coffee_Production_Year_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Production_Year, android.R.layout.simple_spinner_dropdown_item);
        spinner_Production_Year.setAdapter(Coffee_Production_Year_adapter);
        spinner_Production_Year.setSelection(0);
        return view;
    }
}
