package com.example;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
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
        fragmentManager = getSupportFragmentManager();

        fragment_CoffeeRanking = new CoffeeRanking_Fragment();
        fragment_Extraction = new Extraction_Fragment();
        fragment_Mypage = new Mypage_Fragment();
        fragment_Home = new Home_Fragment();

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
    /***
     *  -> 사이드 네브바 세팅
     *   - 클릭 아이콘 설정
     *   - 아이템 클릭 이벤트 설정
     */
    public void settingSideNavBar()
    {
        // 툴바 생성
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        // 사이드 메뉴를 오픈하기위한 아이콘 추가
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_48);

        // 사이드 네브바 구현
//        DrawerLayout drawLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainFragment_Activity.this,
                drawLayout,
                toolbar,
                R.string.open,
                R.string.closed
        );

        // 사이드 네브바 클릭 리스너
        drawLayout.addDrawerListener(actionBarDrawerToggle);

        // -> 사이드 네브바 아이템 클릭 이벤트 설정
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if (id == R.id.menu_item1){
                    Toast.makeText(getApplicationContext(), "메뉴아이템 1 선택", Toast.LENGTH_SHORT).show();
                }else if(id == R.id.menu_item2){
                    Toast.makeText(getApplicationContext(), "메뉴아이템 2 선택", Toast.LENGTH_SHORT).show();
                }else if(id == R.id.menu_item3){
                    Toast.makeText(getApplicationContext(), "메뉴아이템 3 선택", Toast.LENGTH_SHORT).show();
                }


                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }


    /***
     *  -> 뒤로가기시, 사이드 네브바 닫는 기능
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

