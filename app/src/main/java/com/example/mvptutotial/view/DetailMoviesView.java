package com.example.mvptutotial.view;

import com.example.mvptutotial.models.DetailModels.RootDetail;
import com.example.mvptutotial.models.SearchModels.RootSearch;

public interface DetailMoviesView {
    void onDetailSuccess(RootDetail detail);
    void onError(String msg);
    void onFail(String msg);
}
