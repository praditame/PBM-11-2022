package com.example.pertemuan11;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView nav;
    FloatingActionButton fab;
    Fragment fragment;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav = findViewById(R.id.navView);
//        fab = findViewById(R.id.floating_action_button);
        fm = getSupportFragmentManager();

        //showing at first run
        fm.beginTransaction().replace(R.id.frame, new FragmentMovie()).commit();

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, MovieDetailActivity.class));
//            }
//        });

        //event click nav-view
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //halaman fragment (isinya: e.g. list data, form, dll)

                //membuat fragment kosong
                fragment = null;

                //cek menu mana yg diklik (movies | tv ?)
                switch (item.getItemId()) {
                    case R.id.menu_movie:
                        //panggil halaman fragment movie
                        fragment = new FragmentMovie();
                        fm.beginTransaction().replace(R.id.frame
                                , fragment).commit();

                        return true;
                    case R.id.menu_tv:
//                        fragment = new BlankFragment();
//                        fm.beginTransaction().replace(R.id.frame
//                                , fragment).commit();
                        break;
                }

                return true;
            }
        });


    }
}