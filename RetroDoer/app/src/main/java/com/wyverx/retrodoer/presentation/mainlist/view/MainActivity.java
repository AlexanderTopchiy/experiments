package com.wyverx.retrodoer.presentation.mainlist.view;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wyverx.retrodoer.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            initMainFragment();
        }
    }


    private void initMainFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        MainFragment mainFragment = MainFragment.newInstance();
        fragmentManager.beginTransaction()
                .replace(R.id.main_container, mainFragment)
                .addToBackStack("MainFragment")
                .commit();
    }
}
