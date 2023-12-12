package com.example.mvptutotial.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvptutotial.R;
import com.example.mvptutotial.databinding.ItemCompaniesBinding;
import com.example.mvptutotial.databinding.ItemMoviesBinding;
import com.example.mvptutotial.models.DetailModels.CompaniesDetail;
import com.example.mvptutotial.models.UpComingModels.UpComingModel;

import java.text.DecimalFormat;
import java.util.List;

public class CompaniesDetailAdapter extends RecyclerView.Adapter<CompaniesDetailAdapter.MyViewHolder> {

    Context mContext;
    List<CompaniesDetail> list;

    public CompaniesDetailAdapter(Context mContext, List<CompaniesDetail> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ItemCompaniesBinding.inflate(LayoutInflater.from(mContext),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CompaniesDetail model = list.get(position);
        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w500" + model.getLogo_path())
                .placeholder(R.drawable.image_top)
                .into(holder.binding.logoPath);
        holder.binding.originCountry.setText(""+ model.getOrigin_country());
        holder.binding.companiesName.setText(""+model.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public final class MyViewHolder extends RecyclerView.ViewHolder{
        ItemCompaniesBinding binding;
        public MyViewHolder(@NonNull ItemCompaniesBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
