package com.wyverx.retrodoer.data.models;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("userId")
    private int userId;

    @SerializedName("id")
    private int postId;

    @SerializedName("title")
    private String postTitle;

    @SerializedName("body")
    private String postBody;


    public Post(int userId, int postId, String postTitle, String postBody) {
        this.userId = userId;
        this.postId = postId;
        this.postTitle = postTitle;
        this.postBody = postBody;
    }


    public int getUserId() {
        return userId;
    }

    public int getPostId() {
        return postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostBody() {
        return postBody;
    }
}
