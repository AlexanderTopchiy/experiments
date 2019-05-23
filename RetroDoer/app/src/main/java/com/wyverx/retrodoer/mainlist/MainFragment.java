package com.wyverx.retrodoer.mainlist;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.data.models.Post;
import com.wyverx.retrodoer.data.network.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class MainFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MainFragment() {
    }


    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            getDataFromApi(recyclerView);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public void getDataFromApi(final RecyclerView recyclerView) {
        NetworkService.getInstance()
                .getJSONApi()
                .getAllPosts()
                .enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    recyclerView.setAdapter(new MainRecyclerViewAdapter(response.body(), mListener));
                } else {
                    String mResposeCode = String.valueOf(response.code());
                    Toast.makeText(getContext(),
                            "Response code " + mResposeCode,
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getContext(),
                        "Something went wrong...Please try later!",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Post item);
    }
}
