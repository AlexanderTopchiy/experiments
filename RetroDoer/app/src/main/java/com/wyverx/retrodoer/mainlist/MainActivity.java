package com.wyverx.retrodoer.mainlist;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.dummy.DummyContent.DummyItem;

public class MainActivity extends AppCompatActivity
        implements MainFragment.OnListFragmentInteractionListener {

    public static final int COLUMN_COUNT = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        MainFragment mainFragment = MainFragment.newInstance(COLUMN_COUNT);
        fragmentManager.beginTransaction()
                .replace(R.id.main_container, mainFragment)
                .commit();
    }


    @Override
    public void onListFragmentInteraction(DummyItem item) {

    }
}
