package com.wyverx.retrodoer.mainlist;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.data.models.Post;
import com.wyverx.retrodoer.itemdetail.ItemDetailFragment;

public class MainActivity extends AppCompatActivity
        implements MainFragment.OnListFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            MainFragment mainFragment = MainFragment.newInstance();
            fragmentManager.beginTransaction()
                    .replace(R.id.main_container, mainFragment)
                    .addToBackStack("MainFragment")
                    .commit();
        }
    }


    @Override
    public void onListFragmentInteraction(Post item) {
        Bundle argsFromMain = new Bundle();
        argsFromMain.putString("post body", item.getPostBody());

        FragmentManager fragmentManager = getSupportFragmentManager();
        ItemDetailFragment itemDetailFragment = ItemDetailFragment.newInstance();
        itemDetailFragment.setArguments(argsFromMain);
        fragmentManager.beginTransaction()
                .replace(R.id.main_container, itemDetailFragment)
                .addToBackStack("ItemDetailFragment")
                .commit();
    }
}
