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
        Spinner spinner_Coffee_Brand = view.findViewById(R.id.Frg_myrecipe2_Spinner2);
        Spinner spinner_Coffee_Variety = view.findViewById(R.id.Frg_myrecipe2_Spinner3);
        Spinner spinner_Coffee_Origin = view.findViewById(R.id.Frg_myrecipe2_Spinner4);
        Spinner spinner_Coffee_Processing = view.findViewById(R.id.Frg_myrecipe2_Spinner5);

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
        ArrayAdapter<CharSequence> Coffee_Name_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Coffee_name, android.R.layout.simple_spinner_dropdown_item);
        spinner_Coffee_Name.setAdapter(Coffee_Name_adapter);
        spinner_Coffee_Name.setSelection(0);

        ArrayAdapter<CharSequence> Coffee_Brand_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Coffee_Brand_Name, android.R.layout.simple_spinner_dropdown_item);
        spinner_Coffee_Brand.setAdapter(Coffee_Brand_adapter);
        spinner_Coffee_Brand.setSelection(0);

        ArrayAdapter<CharSequence> Coffee_Varety_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Coffee_Variety, android.R.layout.simple_spinner_dropdown_item);
        spinner_Coffee_Variety.setAdapter(Coffee_Varety_adapter);
        spinner_Coffee_Variety.setSelection(0);

        ArrayAdapter<CharSequence> Coffee_Origin_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Coffee_Origin, android.R.layout.simple_spinner_dropdown_item);
        spinner_Coffee_Origin.setAdapter(Coffee_Origin_adapter);
        spinner_Coffee_Origin.setSelection(0);

        ArrayAdapter<CharSequence> Coffee_Processing_adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Coffee_Processing, android.R.layout.simple_spinner_dropdown_item);
        spinner_Coffee_Processing.setAdapter(Coffee_Processing_adapter);
        spinner_Coffee_Processing.setSelection(0);

        return view;
    }
}
