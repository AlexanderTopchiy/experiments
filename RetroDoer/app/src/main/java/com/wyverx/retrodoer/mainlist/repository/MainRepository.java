package com.wyverx.retrodoer.mainlist.repository;

import android.util.Log;

import com.wyverx.retrodoer.data.models.Post;
import com.wyverx.retrodoer.data.network.NetworkService;
import com.wyverx.retrodoer.mainlist.MainContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository implements MainContract.Repository {

    public static MainRepository newInstance() {
        return new MainRepository();
    }


    @Override
    public void getDataFormApi(final ResultsCallback resultsCallback) {
        NetworkService.getInstance()
                .getJSONApi()
                .getAllPosts()
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                        if (response.isSuccessful()) {
                            resultsCallback.onSuccess(response.body());
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


    public interface ResultsCallback {
        // This is callback interface for Retrofit onResponse method
        void onSuccess(List<Post> list);
    }
}
