package com.example.mvptutotial.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvptutotial.MainActivity;
import com.example.mvptutotial.R;
import com.example.mvptutotial.activity.FavoriteActivity;
import com.example.mvptutotial.databinding.ItemMoviesBinding;
import com.example.mvptutotial.models.PopularModels.PopularModel;
import com.example.mvptutotial.view.ClickItemListener;

import java.text.DecimalFormat;
import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.MyViewHolder>  {

    Context mContext;
    List<PopularModel> list;

    public PopularAdapter(Context mContext, List<PopularModel> list) {
        this.mContext = mContext;
        this.list = list;
    }
    private ClickItemListener clickItemListener;
    public void setOnItemClickListener(ClickItemListener listener) {
        this.clickItemListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ItemMoviesBinding.inflate(LayoutInflater.from(mContext),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PopularModel results = list.get(position);
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String formattedValue = decimalFormat.format(results.getVote_average());
        float roundedValue = Float.parseFloat(formattedValue);
        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w500" + results.getPoster_path())
                .placeholder(R.drawable.image_top)
                .into(holder.binding.posterPath);
        holder.binding.originalTitle.setText(""+results.getOriginal_title());
        holder.binding.voteAverage.setText(""+roundedValue +"/10");
        holder.itemView.setOnClickListener(v -> {
            if (clickItemListener != null) {
                clickItemListener.onItemClick(results.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public final class MyViewHolder extends RecyclerView.ViewHolder{
        ItemMoviesBinding binding;
        public MyViewHolder(@NonNull ItemMoviesBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
