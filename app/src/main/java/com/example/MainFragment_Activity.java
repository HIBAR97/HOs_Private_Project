package com.example;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainFragment_Activity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private CoffeeRanking_Fragment fragment_CoffeeRanking;
    private Extraction_Fragment fragment_Extraction;
    private Mypage_Fragment fragment_Mypage;
    private Home_Fragment fragment_Home;

    //---------------선언-------------------//
    ImageButton btn_SideMenu;
    Button btn_Rank;
    Button btn_Extrac;
    Button btn_MyPage;
    ImageButton btn_Home;
    NavigationView Navi_sideMenu;

    boolean SideVis = false;

    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mainfragment);


        //----------연결--------------//
        btn_SideMenu = findViewById(R.id.btn_MF_SideMenu);
        btn_Rank = findViewById(R.id.btn_MF_Rank);
        btn_Extrac = findViewById(R.id.btn_MF_Extrac);
        btn_MyPage = findViewById(R.id.btn_MF_MyPage);
        btn_Home = findViewById(R.id.btn_MF_Home);

        Navi_sideMenu = findViewById(R.id.Navi_MF_SideMenu);

        //--------플레그먼트 선언---------//

        fragment_CoffeeRanking = new CoffeeRanking_Fragment();
        fragment_Extraction = new Extraction_Fragment();
        fragment_Mypage = new Mypage_Fragment();
        fragment_Home = new Home_Fragment();

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.MF_FrameLayout, fragment_Home).commitAllowingStateLoss();

        //----------리스너 파트-------------//
        btn_SideMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SideVis == false) {
                    Navi_sideMenu.setVisibility(View.VISIBLE);
                    SideVis = true;
                }
                else if(SideVis == true) {
                    Navi_sideMenu.setVisibility(View.INVISIBLE);
                    SideVis = false;
                }
            }
        });

        btn_Rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, fragment_CoffeeRanking).commitAllowingStateLoss();
            }
        });

        btn_Extrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, fragment_Extraction).commitAllowingStateLoss();
            }
        });

        btn_MyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, fragment_Mypage).commitAllowingStateLoss();
            }
        });

        btn_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MF_FrameLayout, fragment_Home).commitAllowingStateLoss();
            }
        });


    }
}
