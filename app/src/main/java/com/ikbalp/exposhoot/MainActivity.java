package com.ikbalp.exposhoot;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/*
     Kamis, 25 Juni 2020
     Ikbal Padilah
     10117143 - IF4
*/


public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

    FragHome fragHome;
    FragCamera fragCamera;
    FragTips fragTips;
    FragSearch fragSearch;

    MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        final FragHome fragHome = new FragHome();
        final FragCamera fragCamera = new FragCamera();
        final FragTips fragTips = new FragTips();
        final FragSearch fragSearch = new FragSearch();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.home) {
                    setFragment(fragHome);
                    return  true;
                } else if (id == R.id.camera) {
                    setFragment(fragCamera);
                    return  true;
                } else if (id == R.id.tips) {
                    setFragment(fragTips);
                    return  true;
                } else if (id == R.id.search) {
                    setFragment(fragSearch);
                    return  true;
                }
                return false;
            }
        });




    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }
}
