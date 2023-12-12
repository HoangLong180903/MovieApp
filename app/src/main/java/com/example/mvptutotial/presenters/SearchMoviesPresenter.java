package com.example.mvptutotial.presenters;

import android.content.Context;
import android.util.Log;

import com.example.mvptutotial.models.GenresModels.RootGenres;
import com.example.mvptutotial.models.SearchModels.RootSearch;
import com.example.mvptutotial.models.UpComingModels.RootUpComing;
import com.example.mvptutotial.retrofit.RetrofitClient;
import com.example.mvptutotial.view.SearchMoviesView;
import com.example.mvptutotial.activity.SearchMoviesActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchMoviesPresenter {

    SearchMoviesView moviesView;
    SearchMoviesActivity activity;
    Context mContext;

    private static final String API_KEY= "06fb1d9f7fc320e284ac118b63f16bd6";

    public SearchMoviesPresenter(SearchMoviesView moviesView, SearchMoviesActivity activity, Context mContext) {
        this.moviesView = moviesView;
        this.activity = activity;
        this.mContext = mContext;
    }


    public void getListSearchMovies(String s){
        Call<RootSearch> call = RetrofitClient.getApiService(mContext).getListSearch(API_KEY,s);
        call.enqueue(new Callback<RootSearch>() {
            @Override
            public void onResponse(Call<RootSearch> call, Response<RootSearch> response) {
                if (response.isSuccessful()){
                    RootSearch rootSearch = response.body();
                    moviesView.onSearchSuccess(rootSearch);
                }else{
                    moviesView.onError(response.message());
                    Log.e("API_error",response.message());
                }
            }

            @Override
            public void onFailure(Call<RootSearch> call, Throwable t) {
                moviesView.onFail(t.getLocalizedMessage());
            }
        });
    }


}
