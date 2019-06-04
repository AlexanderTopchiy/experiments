package com.wyverx.retrodoer.presentation.itemdetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wyverx.retrodoer.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemDetailsFragment extends Fragment {

    private String mValues;
    private TextView mDetailTextView;


    public ItemDetailsFragment() {
    }


    public static ItemDetailsFragment newInstance() {
        return new ItemDetailsFragment();
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
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);
        mDetailTextView = view.findViewById(R.id.item_detail);
        mDetailTextView.setText(mValues);
        return view;
    }
}
