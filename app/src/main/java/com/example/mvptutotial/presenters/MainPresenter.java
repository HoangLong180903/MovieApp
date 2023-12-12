package com.example.mvptutotial.presenters;

import android.content.Context;
import android.util.Log;

import com.example.mvptutotial.MainActivity;
import com.example.mvptutotial.view.MainView;
import com.example.mvptutotial.models.GenresModels.RootGenres;
import com.example.mvptutotial.models.PopularModels.RootPopular;
import com.example.mvptutotial.models.NowPlayingModels.RootNowPlaying;
import com.example.mvptutotial.models.TopRatedModels.RootTopRated;
import com.example.mvptutotial.models.UpComingModels.RootUpComing;
import com.example.mvptutotial.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    MainActivity activity;
    MainView mainView;
    Context mContext;
    private static final String API_KEY= "06fb1d9f7fc320e284ac118b63f16bd6";
    private static final String language= "en-US";

    public MainPresenter(MainActivity activity, MainView mainView, Context mContext) {
        this.activity = activity;
        this.mainView = mainView;
        this.mContext = mContext;
        getListUpComing();
        getListTopRated();
        getListPopular();
        getListGenres();
        getListNowPlaying();
    }

    public void getListNowPlaying(){
        Call<RootNowPlaying> call = RetrofitClient.getApiService(mContext).getListNowPlaying(API_KEY);
        call.enqueue(new Callback<RootNowPlaying>() {
            @Override
            public void onResponse(Call<RootNowPlaying> call, Response<RootNowPlaying> response) {
                if (response.isSuccessful()){
                    RootNowPlaying rootNowPlaying = response.body();
                    mainView.onNowPlayingSuccess(rootNowPlaying);
                }else{
                    mainView.onError(response.message());
                    Log.e("API_error",response.message());
                }
            }

            @Override
            public void onFailure(Call<RootNowPlaying> call, Throwable t) {
                mainView.onFail(t.getLocalizedMessage());
                Log.e("API_fail",t.getLocalizedMessage());

            }
        });
    }

    public void getListGenres(){
        Call<RootGenres> call = RetrofitClient.getApiService(mContext).getListGenres(API_KEY);
        call.enqueue(new Callback<RootGenres>() {
            @Override
            public void onResponse(Call<RootGenres> call, Response<RootGenres> response) {
                if (response.isSuccessful()){
                    RootGenres genres = response.body();
                    mainView.onGenres(genres);
                }else{
                    mainView.onError(response.message());
                    Log.e("API_error",response.message());
                }
            }

            @Override
            public void onFailure(Call<RootGenres> call, Throwable t) {
                mainView.onFail(t.getLocalizedMessage());
                Log.e("API_fail",t.getLocalizedMessage());

            }
        });
    }

    public void getListPopular(){
        Call<RootPopular> call = RetrofitClient.getApiService(mContext).getListPopular(API_KEY);
        call.enqueue(new Callback<RootPopular>() {
            @Override
            public void onResponse(Call<RootPopular> call, Response<RootPopular> response) {
                if (response.isSuccessful()){
                    RootPopular popular = response.body();
                    mainView.onPopularSuccess(popular);
                }else{
                    mainView.onError(response.message());
                    Log.e("API_error",response.message());
                }
            }

            @Override
            public void onFailure(Call<RootPopular> call, Throwable t) {

            }
        });
    }

    public void getListTopRated(){
        Call<RootTopRated> call = RetrofitClient.getApiService(mContext).getListTopRated(API_KEY);
        call.enqueue(new Callback<RootTopRated>() {
            @Override
            public void onResponse(Call<RootTopRated> call, Response<RootTopRated> response) {
                if (response.isSuccessful()){
                    RootTopRated popular = response.body();
                    mainView.onTopRatedSuccess(popular);
                }else{
                    mainView.onError(response.message());
                    Log.e("API_error",response.message());
                }
            }

            @Override
            public void onFailure(Call<RootTopRated> call, Throwable t) {

            }
        });
    }


    public void getListUpComing(){
        Call<RootUpComing> call = RetrofitClient.getApiService(mContext).getListUpComing(API_KEY);
        call.enqueue(new Callback<RootUpComing>() {
            @Override
            public void onResponse(Call<RootUpComing> call, Response<RootUpComing> response) {
                if (response.isSuccessful()){
                    RootUpComing upComing = response.body();
                    mainView.onUpComingSuccess(upComing);
                }else{
                    mainView.onError(response.message());
                    Log.e("API_error",response.message());
                }
            }

            @Override
            public void onFailure(Call<RootUpComing> call, Throwable t) {

            }
        });
    }



}
