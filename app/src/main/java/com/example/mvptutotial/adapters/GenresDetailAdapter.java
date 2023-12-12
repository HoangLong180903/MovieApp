package com.example.mvptutotial.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvptutotial.databinding.ItemGenresBinding;
import com.example.mvptutotial.databinding.ItemGenresDetailBinding;
import com.example.mvptutotial.models.DetailModels.GenresDetail;
import com.example.mvptutotial.models.GenresModels.GenresModel;

import java.util.List;

public class GenresDetailAdapter extends RecyclerView.Adapter<GenresDetailAdapter.MyViewHolder> {

    Context mContext;
    List<GenresDetail> list;
    public GenresDetailAdapter(Context mContext, List<GenresDetail> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ItemGenresDetailBinding.inflate(LayoutInflater.from(mContext),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GenresDetail model = list.get(position);
        holder.binding.itemDetailName.setText(""+model.getName()+", ");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public final class MyViewHolder extends RecyclerView.ViewHolder{
        ItemGenresDetailBinding binding;
        public MyViewHolder(@NonNull ItemGenresDetailBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
