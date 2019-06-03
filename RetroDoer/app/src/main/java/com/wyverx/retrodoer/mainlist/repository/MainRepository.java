package com.wyverx.retrodoer.mainlist.repository;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.wyverx.retrodoer.data.models.Post;
import com.wyverx.retrodoer.data.network.NetworkService;
import com.wyverx.retrodoer.mainlist.MainContract;
import com.wyverx.retrodoer.mainlist.view.MainRecyclerViewAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository implements MainContract.Repository {

    public static MainRepository newInstance() {
        return new MainRepository();
    }


    @Override
    public void getDataFormApi(final RecyclerView recyclerView,
                               final MainRecyclerViewAdapter.ListFragmentListener listener) {
        NetworkService.getInstance()
                .getJSONApi()
                .getAllPosts()
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                        if (response.isSuccessful()) {
                            recyclerView.setAdapter(new MainRecyclerViewAdapter(response.body(), listener));
                        } else {
                            String mResposeCode = String.valueOf(response.code());
                            Log.d("Retrofit.onResponse", "Response code " + mResposeCode);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {
                        Log.d("Retrofit.onFailure", "Something went wrong...Please try later!");
                    }
                });
    }
}

