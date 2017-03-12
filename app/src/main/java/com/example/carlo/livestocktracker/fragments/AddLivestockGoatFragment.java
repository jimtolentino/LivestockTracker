package com.example.carlo.livestocktracker.fragments;

import android.app.Fragment;
import android.database.CursorJoiner;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.carlo.livestocktracker.R;

/**
 * Created by Carlo on 3/4/2017.
 */

public class AddLivestockGoatFragment extends Fragment {

    private TextView tv_goatNum;
//    private ScannerFragment scannerFragment;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment_packages
        final View fragmentview = inflater.inflate(R.layout.fragment_addgoat, container, false);
        tv_goatNum = (TextView) fragmentview.findViewById(R.id.tvf_lgnum);
//        scannerFragment = new ScannerFragment();
//        scannerFragment.handleResult(this);
//        tv_goatNum.setOnClickListener();

        return fragmentview;
    }




}
