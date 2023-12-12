package com.example.mvptutotial.view;

import com.example.mvptutotial.models.SearchModels.RootSearch;

public interface SearchMoviesView {
    void onSearchSuccess(RootSearch search);
    void onError(String msg);
    void onFail(String msg);
}
