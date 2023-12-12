package com.example.mvptutotial.models.NowPlayingModels;

import java.util.List;

public class RootNowPlaying {
    private Dates dates;
    private int page;
    private List<NowPlayingModel> results;
    private int total_pages;
    private int total_results;

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<NowPlayingModel> getResults() {
        return results;
    }

    public void setResults(List<NowPlayingModel> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }
}
