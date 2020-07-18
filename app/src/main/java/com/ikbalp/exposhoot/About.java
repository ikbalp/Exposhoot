package com.ikbalp.exposhoot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

       //Init and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.about);

        //perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.camera:
                        startActivity(new Intent(getApplicationContext(),Camera.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.tips:
                        startActivity(new Intent(getApplicationContext(), Tips.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.about:
                        return true;

                }
                return false;
            }
        });

    }
}
