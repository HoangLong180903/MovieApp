package com.example.mvptutotial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mvptutotial.activity.FavoriteActivity;
import com.example.mvptutotial.activity.SearchMoviesActivity;
import com.example.mvptutotial.adapters.PopularAdapter;
import com.example.mvptutotial.adapters.TopRatedAdapter;
import com.example.mvptutotial.adapters.UpComingAdapter;
import com.example.mvptutotial.models.GenresModels.RootGenres;
import com.example.mvptutotial.models.PopularModels.RootPopular;
import com.example.mvptutotial.models.NowPlayingModels.RootNowPlaying;
import com.example.mvptutotial.adapters.GenresAdapter;
import com.example.mvptutotial.adapters.NowPlayingAdapter;
import com.example.mvptutotial.databinding.ActivityMainBinding;
import com.example.mvptutotial.models.TopRatedModels.RootTopRated;
import com.example.mvptutotial.models.UpComingModels.RootUpComing;
import com.example.mvptutotial.presenters.MainPresenter;
import com.example.mvptutotial.view.MainView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements MainView {
    ActivityMainBinding binding;
    MainPresenter presenter;
    NowPlayingAdapter nowPlayingAdapter;
    GenresAdapter genresAdapter;
    PopularAdapter popularAdapter;
    TopRatedAdapter topRatedAdapter;
    UpComingAdapter upComingAdapter;
    boolean nightMode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        action();
    }

    private void initView(){
        presenter = new MainPresenter(this,this,this);
    }

    private void action(){
        binding.navBottom.setItemIconTintList(null);
        binding.navBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (R.id.feed == item.getItemId()){
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                }else if (R.id.search == item.getItemId()){
                    startActivity(new Intent(MainActivity.this, SearchMoviesActivity.class));
                }
                return false;
            }
        });

        sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE);
        nightMode = sharedPreferences.getBoolean("nightMode",false);
        if (nightMode){
            binding.switchButton.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        binding.switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nightMode) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("nightMode", false);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("nightMode", true);
                }
                editor.apply();
            }
        });

    }

    @Override
    public void onNowPlayingSuccess(RootNowPlaying rootNowPlaying) {
        nowPlayingAdapter = new NowPlayingAdapter(MainActivity.this, rootNowPlaying.getResults());
        nowPlayingAdapter.setOnItemClickListener(itemId -> {
            Intent intent = new Intent(MainActivity.this, FavoriteActivity.class);
            intent.putExtra("itemId", itemId);
            startActivity(intent);
        });
        binding.rcNowPlaying.setAdapter(nowPlayingAdapter);
    }

    @Override
    public void onPopularSuccess(RootPopular popular) {
        popularAdapter = new PopularAdapter(MainActivity.this,popular.getResults());
        popularAdapter.setOnItemClickListener(itemId -> {
            Intent intent = new Intent(MainActivity.this, FavoriteActivity.class);
            intent.putExtra("itemId", itemId);
            startActivity(intent);
        });
        binding.rcPopular.setAdapter(popularAdapter);
    }

    @Override
    public void onTopRatedSuccess(RootTopRated topRated) {
        topRatedAdapter = new TopRatedAdapter(MainActivity.this,topRated.getResults());
        binding.rcTopRated.setAdapter(topRatedAdapter);
        topRatedAdapter.setOnItemClickListener(itemId -> {
            Intent intent = new Intent(MainActivity.this, FavoriteActivity.class);
            intent.putExtra("itemId", itemId);
            startActivity(intent);
        });
    }

    @Override
    public void onUpComingSuccess(RootUpComing upComing) {
        upComingAdapter = new UpComingAdapter(MainActivity.this,upComing.getResults());
        binding.rcUpComing.setAdapter(upComingAdapter);
        upComingAdapter.setOnItemClickListener(itemId -> {
            Intent intent = new Intent(MainActivity.this, FavoriteActivity.class);
            intent.putExtra("itemId", itemId);
            startActivity(intent);
        });
    }


    @Override
    public void onGenres(RootGenres genres) {
        genresAdapter = new GenresAdapter(MainActivity.this,genres.getGenres());
        binding.rcGenres.setAdapter(genresAdapter);
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
    }
}