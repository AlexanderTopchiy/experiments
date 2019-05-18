package com.wyverx.retrodoer.mainlist;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.dummy.DummyContent.DummyItem;
import com.wyverx.retrodoer.itemdetail.ItemDetailFragment;

public class MainActivity extends AppCompatActivity
        implements MainFragment.OnListFragmentInteractionListener {

    private static final int COLUMN_COUNT = 1;


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
        Bundle argsFromMain = new Bundle();
        argsFromMain.putString("item id", item.id);

        FragmentManager fragmentManager = getSupportFragmentManager();
        ItemDetailFragment itemDetailFragment = ItemDetailFragment.newInstance();
        itemDetailFragment.setArguments(argsFromMain);
        fragmentManager.beginTransaction()
                .replace(R.id.main_container, itemDetailFragment)
                .commit();
    }
}
