package com.example.mvptutotial.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvptutotial.databinding.ItemGenresBinding;
import com.example.mvptutotial.models.GenresModels.GenresModel;

import java.util.List;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.MyViewHolder> {

    Context mContext;
    List<GenresModel> list;
    public GenresAdapter(Context mContext, List<GenresModel> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ItemGenresBinding.inflate(LayoutInflater.from(mContext),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GenresModel model = list.get(position);
        holder.binding.itemName.setText(""+model.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public final class MyViewHolder extends RecyclerView.ViewHolder{
        ItemGenresBinding binding;
        public MyViewHolder(@NonNull ItemGenresBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
