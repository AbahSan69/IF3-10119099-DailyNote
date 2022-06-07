package com.example.if3_10119099_dailynote;

//NIM   = 10119099;
//Nama  = Sandi Komara;
//Kelas = IF3

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class ViewPager_activity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Model> modelArrayList;
    private Adapter adapter;
    private MaterialButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager = findViewById(R.id.viewPager);
        loadCards();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                String title = modelArrayList.get(position).getTitle();
                if(position == modelArrayList.size()-1){
                    button.setText("Started");
                }else {
                    button.setText("Next");
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager.getCurrentItem()+1<modelArrayList.size()){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }else{
                    //kembali ke main activity
                    startActivity(new Intent(ViewPager_activity.this, MainActivity.class));
                    finish();
                }
            }
        });
    }

    private void loadCards() {
        modelArrayList = new ArrayList<>();

        modelArrayList.add(new Model("What's Daily Activity Apps?","Merupakan aplikasi pencatat kegiatan sehari-hari.",R.drawable.logo));
        modelArrayList.add(new Model("Make Your Notes!","Anda bisa menulis, mengubah, menghapus catatan untuk kegiatan anda dengan mudah.",R.drawable.writing));
        modelArrayList.add(new Model("Watch Your List!","Anda bisa melihat berbagai catatan yang telah anda catat didalam Daily Activity Apps.",R.drawable.list));

        adapter = new Adapter(this,modelArrayList);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(100,0,100,0);
    }

}