package com.example.mvptutotial.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvptutotial.R;
import com.example.mvptutotial.databinding.ItemMoviesBinding;
import com.example.mvptutotial.models.NowPlayingModels.NowPlayingModel;
import com.example.mvptutotial.models.UpComingModels.UpComingModel;
import com.example.mvptutotial.view.ClickItemListener;

import java.text.DecimalFormat;
import java.util.List;

public class UpComingAdapter extends RecyclerView.Adapter<UpComingAdapter.MyViewHolder> {

    Context mContext;
    List<UpComingModel> list;

    public UpComingAdapter(Context mContext, List<UpComingModel> list) {
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
        UpComingModel model = list.get(position);
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String formattedValue = decimalFormat.format(model.getVote_average());
        float roundedValue = Float.parseFloat(formattedValue);
        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w500" + model.getPoster_path())
                .placeholder(R.drawable.image_top)
                .into(holder.binding.posterPath);
        holder.binding.originalTitle.setText(""+ model.getOriginal_title());
        holder.binding.voteAverage.setText(""+roundedValue +"/10");
        holder.itemView.setOnClickListener(v -> {
            if (clickItemListener != null) {
                clickItemListener.onItemClick(model.getId());
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
