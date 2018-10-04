package com.example.rapisodo.livedataviewmodel.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rapisodo.livedataviewmodel.R;
import com.example.rapisodo.livedataviewmodel.databinding.ItemCardBinding;
import com.example.rapisodo.livedataviewmodel.model.Card;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private ArrayList<Card> mArrayList;

    public CardAdapter(ArrayList<Card> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind.tvName.setText(mArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemCardBinding bind;

        public ViewHolder(View itemView) {
            super(itemView);
            bind = DataBindingUtil.bind(itemView);
        }
    }
}
