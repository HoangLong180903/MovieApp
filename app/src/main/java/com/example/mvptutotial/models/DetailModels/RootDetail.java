package com.example.mvptutotial.models.DetailModels;

import com.example.mvptutotial.models.NowPlayingModels.Dates;

import java.util.List;

public class RootDetail {
    private List<GenresDetail> genres;
    private String homepage;
    private int id;
    private String original_title;
    private String overview;
    private String poster_path;
    private List<CompaniesDetail> production_companies;
    private String release_date;
    private int revenue;
    private int runtime;
    private String status;
    private String tagline;
    private float vote_average;

    public List<GenresDetail> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresDetail> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<CompaniesDetail> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<CompaniesDetail> production_companies) {
        this.production_companies = production_companies;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }
}
