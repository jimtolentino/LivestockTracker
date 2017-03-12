package com.example.carlo.livestocktracker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carlo.livestocktracker.Livestock;
import com.example.carlo.livestocktracker.R;
import com.example.carlo.livestocktracker.RecyclerViewHolders;

import java.util.ArrayList;

/**
 * Created by Carlo on 3/4/2017.
 */

public class LivestockAdapter extends  RecyclerView.Adapter<RecyclerViewHolders> {
    private ArrayList<Livestock> itemList;
    private Context context;

    public LivestockAdapter(Context context, ArrayList<Livestock> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
////        View layoutView = LayoutInflater.from(context).inflate(R.layout.card_view_list, parent, false);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView, context, itemList);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {

//        Livestock lstock = itemList.get(position);
        holder.livestockNum.setText(itemList.get(position).getNum());
        holder.livestockPhoto.setImageResource(itemList.get(position).getPhoto());
//        holder.Breed.setText(itemList.get(position).getBreed());
//        holder.Type.setText(itemList.get(position).getType());
//        holder.Weight.setText(itemList.get(position).getWeight());
//        holder.HouseNum.setText(itemList.get(position).getHouseNum());

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }



}
