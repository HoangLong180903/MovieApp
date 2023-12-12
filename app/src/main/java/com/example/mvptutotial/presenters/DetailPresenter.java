package com.example.mvptutotial.presenters;

import android.content.Context;
import android.util.Log;

import com.example.mvptutotial.activity.FavoriteActivity;
import com.example.mvptutotial.activity.SearchMoviesActivity;
import com.example.mvptutotial.models.DetailModels.RootDetail;
import com.example.mvptutotial.models.SearchModels.RootSearch;
import com.example.mvptutotial.retrofit.RetrofitClient;
import com.example.mvptutotial.view.DetailMoviesView;
import com.example.mvptutotial.view.SearchMoviesView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {

    DetailMoviesView moviesView;
    FavoriteActivity activity;
    Context mContext;

    private static final String API_KEY= "06fb1d9f7fc320e284ac118b63f16bd6";

    public DetailPresenter(DetailMoviesView moviesView, FavoriteActivity activity, Context mContext) {
        this.moviesView = moviesView;
        this.activity = activity;
        this.mContext = mContext;
    }

    public void getListSearchMovies(int path ){
        Call<RootDetail> call = RetrofitClient.getApiService(mContext).getDetailMovies(path,API_KEY);
        call.enqueue(new Callback<RootDetail>() {
            @Override
            public void onResponse(Call<RootDetail> call, Response<RootDetail> response) {
                if (response.isSuccessful()){
                    RootDetail rootSearch = response.body();
                    moviesView.onDetailSuccess(rootSearch);
                }else{
                    moviesView.onError(response.message());
                    Log.e("API_error",response.message());
                }
            }

            @Override
            public void onFailure(Call<RootDetail> call, Throwable t) {
                moviesView.onFail(t.getLocalizedMessage());
            }
        });
    }
}
