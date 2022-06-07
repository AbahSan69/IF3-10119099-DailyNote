package com.example.if3_10119099_dailynote;

//NIM   = 10119099;
//Nama  = Sandi Komara;
//Kelas = IF3

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;


public class Splash_activity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }
        // set lama splash screen tampil
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash_activity.this, ViewPager_activity.class));
                finish();
            }
        }, 4000);
    }
}