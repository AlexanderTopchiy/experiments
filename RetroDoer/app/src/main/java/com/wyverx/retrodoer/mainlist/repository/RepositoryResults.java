package com.wyverx.retrodoer.mainlist.repository;

import com.wyverx.retrodoer.data.models.Post;
import com.wyverx.retrodoer.mainlist.repository.MainRepository;

import java.util.List;

public class RepositoryResults implements MainRepository.ResultsCallback {

    private List<Post> postsList;


    @Override
    public void onSuccess(List<Post> list) {
        postsList = list;
    }


    public List<Post> getPostsList() {
        return postsList;
    }
}
