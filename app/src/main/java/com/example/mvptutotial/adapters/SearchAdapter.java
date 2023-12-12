package com.example.mvptutotial.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvptutotial.R;
import com.example.mvptutotial.databinding.ItemSearchBinding;
import com.example.mvptutotial.models.SearchModels.SearchModel;
import com.example.mvptutotial.view.ClickItemListener;

import java.text.DecimalFormat;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {

    Context mContext;
    List<SearchModel> list;
    public SearchAdapter(Context mContext, List<SearchModel> list) {
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
        return new MyViewHolder(ItemSearchBinding.inflate(LayoutInflater.from(mContext),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SearchModel results = list.get(position);
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
        ItemSearchBinding binding;
        public MyViewHolder(@NonNull ItemSearchBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
