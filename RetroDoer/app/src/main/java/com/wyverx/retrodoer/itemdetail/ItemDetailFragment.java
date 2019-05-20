package com.wyverx.retrodoer.itemdetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.data.models.Post;
import com.wyverx.retrodoer.dummy.DummyContent;
import com.wyverx.retrodoer.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemDetailFragment extends Fragment {

    private String mValues;
    private TextView mDetailTextView;


    public ItemDetailFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ItemDetailFragment.
     */
    public static ItemDetailFragment newInstance() {
        ItemDetailFragment fragment = new ItemDetailFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mValues = getArguments().getString("post body");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);
        mDetailTextView = view.findViewById(R.id.item_detail);
        mDetailTextView.setText(mValues);
        return view;
    }
}
