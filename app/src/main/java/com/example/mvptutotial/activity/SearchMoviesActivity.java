package com.example.mvptutotial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.mvptutotial.MainActivity;
import com.example.mvptutotial.adapters.GenresAdapter;
import com.example.mvptutotial.adapters.SearchAdapter;
import com.example.mvptutotial.models.GenresModels.RootGenres;
import com.example.mvptutotial.presenters.MainPresenter;
import com.example.mvptutotial.presenters.SearchMoviesPresenter;
import com.example.mvptutotial.view.SearchMoviesView;
import com.example.mvptutotial.databinding.ActivitySearchMoviesBinding;
import com.example.mvptutotial.models.SearchModels.RootSearch;

public class SearchMoviesActivity extends AppCompatActivity implements SearchMoviesView {
    ActivitySearchMoviesBinding binding;
    SearchMoviesPresenter presenter;
    SearchAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchMoviesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    public void initView(){
        presenter = new SearchMoviesPresenter(this,this,this);
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getListSearchMovies(binding.edSearch.getText().toString());
            }
        });

    }


    @Override
    public void onSearchSuccess(RootSearch search) {
        adapter = new SearchAdapter(SearchMoviesActivity.this,search.getResults());
        adapter.setOnItemClickListener(itemId -> {
            Intent intent = new Intent(SearchMoviesActivity.this, FavoriteActivity.class);
            intent.putExtra("itemId", itemId);
            startActivity(intent);
        });
        binding.rcSearch.setAdapter(adapter);
        binding.linearNotFound.setVisibility(View.GONE);
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