package com.wyverx.retrodoer.data.repository;

import android.util.Log;

import com.wyverx.retrodoer.data.models.Post;
import com.wyverx.retrodoer.data.network.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    public interface ResponseCallback {
        void onSuccess(List<Post> list);
    }


    private final NetworkService api;


    private MainRepository() {
        api = NetworkService.getInstance();
    }


    public static MainRepository newInstance() {
        return new MainRepository();
    }


    public void getDataFromApi(final ResponseCallback callback) {
        api.getJSONApi()
            .getAllPosts()
            .enqueue(new Callback<List<Post>>() {
                @Override
                public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.body());
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


