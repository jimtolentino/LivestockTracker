package com.example.carlo.livestocktracker.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carlo.livestocktracker.Livestock;
import com.example.carlo.livestocktracker.dbhandlers.LivestockDBHandler;
import com.example.carlo.livestocktracker.R;
import com.example.carlo.livestocktracker.adapters.LivestockAdapter;

import java.util.ArrayList;

/**
 * Created by Carlo on 3/4/2017.
 */

public class LivestockFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment_packages
        final View view = inflater.inflate(R.layout.fragment_livestock, container, false);
        initLivestockView(view);
        return view;
    }


    private void initLivestockView(View view){
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Livestock> livestockList = initLivestocks();

        LivestockAdapter adapter = new LivestockAdapter(getActivity(), livestockList);
        recyclerView.setAdapter(adapter);

    }



    private ArrayList<Livestock> initLivestocks(){

        LivestockDBHandler db = new LivestockDBHandler(getActivity());
//        db.addLivestock(new Livestock(1,"JT-137", R.drawable.goat410,"Goat","Boer","House # 8","40 kg"));

        ArrayList<Livestock> livestock = db.getAllLivestock();

//
//        ArrayList<Livestock> allItems = new ArrayList<Livestock>();
//        allItems.add(new Livestock("JT-100", R.drawable.goat410, "Goat", "Boer", "7","30 Kilos"));
//        allItems.add(new Livestock("JT-101", R.drawable.goat410, "Goat", "Boer", "7","30 Kilos"));
//        allItems.add(new Livestock("JT-102", R.drawable.goat410, "Goat", "Boer", "7","30 Kilos"));
//        allItems.add(new Livestock("JT-103", R.drawable.goat410, "Goat", "Boer", "7","30 Kilos"));
//        allItems.add(new Livestock("JT-104", R.drawable.goat410, "Goat", "Boer", "7","30 Kilos"));
//        allItems.add(new Livestock("JT-105", R.drawable.goat410, "Goat", "Boer", "7","30 Kilos"));
//        allItems.add(new Livestock("JT-106", R.drawable.goat410, "Goat", "Boer", "7","30 Kilos"));
//        allItems.add(new Livestock("JT-107", R.drawable.goat410, "Goat", "Boer", "7","30 Kilos"));
//        allItems.add(new Livestock("JT-108", R.drawable.goat410, "Goat", "Boer", "7","30 Kilos"));
//        allItems.add(new Livestock("JT-109", R.drawable.goat410, "Goat", "Boer", "7","30 Kilos"));
//        allItems.add(new Livestock("LB-100", R.drawable.goat410, "Goat", "Boer", "8","31 Kilos"));
//        allItems.add(new Livestock("LB-101", R.drawable.goat410, "Goat", "Boer", "8","31 Kilos"));
//        allItems.add(new Livestock("DP-100", R.drawable.goat410, "Goat", "Boer", "9","32 Kilos"));
//        allItems.add(new Livestock("DP-101", R.drawable.goat410, "Goat", "Boer", "9","32 Kilos"));
//        allItems.add(new Livestock("KT-100", R.drawable.goat410, "Goat", "Boer", "10","33 Kilos"));
//        allItems.add(new Livestock("KT-101", R.drawable.goat410, "Goat", "Boer", "10","33 Kilos"));
//
        return livestock;
    }
}
