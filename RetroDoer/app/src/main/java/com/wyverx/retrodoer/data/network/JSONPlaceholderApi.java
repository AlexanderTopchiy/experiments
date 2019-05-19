package com.wyverx.retrodoer.data.network;

import com.wyverx.retrodoer.data.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholderApi {

    @GET("posts")
    Call<List<Post>> getAllPosts();
}
