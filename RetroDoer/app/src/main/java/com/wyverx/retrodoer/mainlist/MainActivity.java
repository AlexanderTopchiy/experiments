package com.wyverx.retrodoer.mainlist;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wyverx.retrodoer.MainFragment;
import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.dummy.DummyContent;

public class MainActivity extends AppCompatActivity
        implements MainFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        MainFragment mainFragment = new MainFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.main_container, mainFragment)
                .commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
