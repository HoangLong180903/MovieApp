package com.example.mvptutotial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mvptutotial.R;
import com.example.mvptutotial.adapters.CompaniesDetailAdapter;
import com.example.mvptutotial.adapters.GenresDetailAdapter;
import com.example.mvptutotial.databinding.ActivityFavoriteBinding;
import com.example.mvptutotial.models.DetailModels.GenresDetail;
import com.example.mvptutotial.models.DetailModels.RootDetail;
import com.example.mvptutotial.presenters.DetailPresenter;
import com.example.mvptutotial.view.DetailMoviesView;

import java.text.DecimalFormat;

public class FavoriteActivity extends AppCompatActivity implements DetailMoviesView {
    DetailPresenter presenter;
    ActivityFavoriteBinding binding;
    CompaniesDetailAdapter companiesAdapter;
    GenresDetailAdapter genresDetailAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavoriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView(){
        presenter = new DetailPresenter(this,this,this);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("itemId")) {
            int itemId = intent.getIntExtra("itemId", -1);
            presenter.getListSearchMovies(itemId);
        } else {
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
        }
        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onDetailSuccess(RootDetail detail) {
        genresDetailAdapter = new GenresDetailAdapter(FavoriteActivity.this,detail.getGenres());
        companiesAdapter = new CompaniesDetailAdapter(FavoriteActivity.this,detail.getProduction_companies());
        binding.rcCompanies.setAdapter(companiesAdapter);
        binding.rcGenresDetail.setAdapter(genresDetailAdapter);
        binding.originalTitle.setText(""+detail.getOriginal_title());
        binding.overview.setText(""+detail.getOverview());
        Glide.with(this).load("https://image.tmdb.org/t/p/w500"+detail.getPoster_path()).into(binding.posterPath);
        binding.releaseDate.setText("Ngày phát hành: "+detail.getRelease_date());
        binding.revenue.setText("Doanh thu: "+detail.getRevenue()+" $");
        binding.runtime.setText("Thời gian: "+detail.getRuntime()+" min");
        binding.tagline.setText(""+detail.getTagline());
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String formattedValue = decimalFormat.format(detail.getVote_average());
        float roundedValue = Float.parseFloat(formattedValue);
        binding.voteAverage.setText(""+roundedValue+"/10");
        if (detail.getStatus().equals("Released")){
            binding.status.setTextColor(Color.GREEN);
        }else{
            binding.status.setTextColor(Color.RED);
        }
        binding.status.setText(""+detail.getStatus());
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onFail(String msg) {

    }
}