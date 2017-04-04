package com.example.carlo.livestocktracker.adapters;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carlo.livestocktracker.fragments.AddUpdLivestockGoatFragment;
import com.example.carlo.livestocktracker.objects.Livestock;
import com.example.carlo.livestocktracker.R;

import java.util.ArrayList;

import static android.R.attr.fragment;

/**
 * Created by Carlo on 3/4/2017.
 */

public class LivestockAdapter extends  RecyclerView.Adapter<LivestockAdapter.ViewHolder> {
    private ArrayList<Livestock> livestockList;
    private Livestock livestock;
    private Context context;
    private Activity activity;

    public LivestockAdapter(Activity activity, ArrayList<Livestock> livestockList) {
        this.activity = activity;
        this.livestockList = livestockList;
        this.context = activity.getApplicationContext();

    }

    @Override
    public LivestockAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LivestockAdapter.ViewHolder holder, int position) {

//        livestock = livestockList.get(position);

//        Livestock lstock = itemList.get(position);
        holder.livestockTag.setText(livestockList.get(position).getTag());
        holder.livestockQrCode.setText(livestockList.get(position).getQrCode());
//        holder.livestockPhoto.setImageResource(R.drawable.goat410);
//        holder.Breed.setText(itemList.get(position).getBreed());
//        holder.Type.setText(itemList.get(position).getType());
//        holder.Weight.setText(itemList.get(position).getWeight());
//        holder.HouseNum.setText(itemList.get(position).getHouseNum());

    }

    @Override
    public int getItemCount() {
        return this.livestockList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView livestockTag;
        public TextView livestockQrCode;
        public ImageView livestockPhoto;
//        public TextView Breed;
//        public TextView Weight;
//        public TextView Type;
//        public TextView HouseNum;
        Context context;
        Livestock livestock = new Livestock();

        public ViewHolder (View view) {
            super(view);


            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){

                    int position = getAdapterPosition();

//                    Livestock livestock = new Livestock();

                    String qrCode = livestockQrCode.getText().toString();


                    android.app.FragmentManager fm = activity.getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, AddUpdLivestockGoatFragment.newInstance(livestockList.get(position)));
                    fragmentTransaction.commit();

                }
            });
//
            livestockTag = (TextView)view.findViewById(R.id.lstock_num);
            livestockQrCode = (TextView)view.findViewById(R.id.lstock_qrcode);
            livestockPhoto = (ImageView)view.findViewById(R.id.lstock_photo);

//            Breed = (TextView)view.findViewById(R.id.detail_label_breed);
//            Weight = (TextView)view.findViewById(R.id.detail_label_weight);
//            Type = (TextView)view.findViewById(R.id.detail_label_type);
//            HouseNum = (TextView)view.findViewById(R.id.detail_label_housenum);


        }
    }
}
