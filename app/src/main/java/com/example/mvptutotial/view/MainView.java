package com.example.mvptutotial.view;

import com.example.mvptutotial.models.GenresModels.RootGenres;
import com.example.mvptutotial.models.PopularModels.RootPopular;
import com.example.mvptutotial.models.NowPlayingModels.RootNowPlaying;
import com.example.mvptutotial.models.TopRatedModels.RootTopRated;
import com.example.mvptutotial.models.UpComingModels.RootUpComing;

public interface MainView {

    void onNowPlayingSuccess(RootNowPlaying rootNowPlaying);
    void onPopularSuccess(RootPopular popular);
    void onTopRatedSuccess(RootTopRated topRated);
    void onUpComingSuccess(RootUpComing upComing);
    void  onGenres(RootGenres genres);
    void onError(String msg);
    void  onFail(String msg);
}
