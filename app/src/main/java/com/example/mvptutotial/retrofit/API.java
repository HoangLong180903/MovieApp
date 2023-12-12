package com.example.mvptutotial.retrofit;

import com.example.mvptutotial.models.DetailModels.RootDetail;
import com.example.mvptutotial.models.GenresModels.RootGenres;
import com.example.mvptutotial.models.PopularModels.RootPopular;
import com.example.mvptutotial.models.NowPlayingModels.RootNowPlaying;
import com.example.mvptutotial.models.SearchModels.RootSearch;
import com.example.mvptutotial.models.TopRatedModels.RootTopRated;
import com.example.mvptutotial.models.UpComingModels.RootUpComing;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    @GET("/3/genre/movie/list")
    Call<RootGenres> getListGenres(@Query("api_key") String key);
    @GET("/3/movie/now_playing")
    Call<RootNowPlaying> getListNowPlaying(@Query("api_key") String key);
    @GET("/3/movie/popular")
    Call<RootPopular> getListPopular(@Query("api_key") String key);
    @GET("/3/movie/top_rated")
    Call<RootTopRated> getListTopRated(@Query("api_key") String key);
    @GET("/3/movie/upcoming")
    Call<RootUpComing> getListUpComing(@Query("api_key") String key);

    @GET("/3/search/movie")
    Call<RootSearch> getListSearch(@Query("api_key") String key , @Query("query") String qr);

    @GET("/3/movie/{movie_id}")
    Call<RootDetail> getDetailMovies(@Path("movie_id") int movieId, @Query("api_key") String key );

}
