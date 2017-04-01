package com.example.carlo.livestocktracker.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.carlo.livestocktracker.R;

/**
 * Created by Carlo on 4/1/2017.
 */

public class CapturePhotoFragment extends Fragment {

    private FrameLayout qrCameraLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment_packages
        final View view = inflater.inflate(R.layout.fragment_capturephoto, container, false);

        qrCameraLayout = (FrameLayout) view.findViewById(R.id.camera_preview);

        return view;
    }

}

