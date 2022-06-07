package com.example.if3_10119099_dailynote;

//NIM   = 10119099;
//Nama  = Sandi Komara;
//Kelas = IF3

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ProfilFragment profilFragment = new ProfilFragment();
    CatatanFragment catatanFragment = new CatatanFragment();
    InfoFragment infoFragment = new InfoFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.botNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentOrientation,profilFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.profil:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentOrientation,profilFragment).commit();
                        return true;

                    case R.id.catatan:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentOrientation,catatanFragment).commit();
                        return true;

                    case R.id.info:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentOrientation,infoFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}