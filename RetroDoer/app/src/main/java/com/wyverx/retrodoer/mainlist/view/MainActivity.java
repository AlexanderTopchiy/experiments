package com.wyverx.retrodoer.mainlist.view;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.data.models.Post;
import com.wyverx.retrodoer.itemdetails.ItemDetailsFragment;

public class MainActivity extends AppCompatActivity
        implements MainFragment.OnListFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            initMainFragment();
        }
    }


    @Override
    public void onListFragmentInteraction(Post item) {
        moveToItemDetailsFragment(item);
    }


    private void initMainFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        MainFragment mainFragment = MainFragment.newInstance();
        fragmentManager.beginTransaction()
                .replace(R.id.main_container, mainFragment)
                .addToBackStack("MainFragment")
                .commit();
    }


    private void moveToItemDetailsFragment(Post item) {
        Bundle argsFromMain = new Bundle();
        argsFromMain.putString("post body", item.getPostBody());

        FragmentManager fragmentManager = getSupportFragmentManager();
        ItemDetailsFragment itemDetailsFragment = ItemDetailsFragment.newInstance();
        itemDetailsFragment.setArguments(argsFromMain);
        fragmentManager.beginTransaction()
                .replace(R.id.main_container, itemDetailsFragment)
                .addToBackStack("ItemDetailsFragment")
                .commit();
    }
}
