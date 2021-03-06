package com.example.carlo.livestocktracker.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlo.livestocktracker.R;
import com.example.carlo.livestocktracker.adapters.LivestockAdapter;
import com.example.carlo.livestocktracker.dbhandlers.LivestockDBHandler;
import com.example.carlo.livestocktracker.objects.Livestock;
import com.google.zxing.Result;

import java.util.ArrayList;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by Carlo on 3/4/2017.
 */

public class ScannerFragment extends Fragment implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    private LinearLayout qrCameraLayout;
    private TextView tv_goatNum;
    private String tvResult;
    private ArrayList<Livestock> livestockList;
    private Fragment fr = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView =  inflater.inflate(R.layout.fragment_scanner, container, false);

        qrCameraLayout = (LinearLayout) fragmentView.findViewById(R.id.ll_qrcamera);

        mScannerView = new ZXingScannerView(getActivity().getApplicationContext());

        mScannerView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

//        mScannerView.setResultHandler(new ZXingScannerView.ResultHandler() {
//            @Override
//            public void handleResult(Result rawResult) {
//                Toast.makeText(getActivity(), "Contents = " + rawResult.getText() + ", Format = " + rawResult.getBarcodeFormat().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

        qrCameraLayout.addView(mScannerView);

        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }


    @Override
    public void handleResult (Result result) {
//        Toast.makeText(getActivity(), "Contents = " + result.getText() + ", Format = " + result.getBarcodeFormat().toString(), Toast.LENGTH_SHORT).show();

        LivestockDBHandler db = new LivestockDBHandler(getActivity());

        fr = new LivestockFragment();

        String qrCode = result.getText();

        if (db.CheckIsDataAlreadyInDBorNot(qrCode)) {

            Livestock livestock  = db.getLivestock(qrCode);

            FragmentManager fm = getFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, AddUpdLivestockGoatFragment.newInstance(livestock));
            fragmentTransaction.commit();

        }else {
            Livestock livestock = new Livestock();

            livestock.setQrCode(result.getText());

            FragmentManager fm = getFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, AddUpdLivestockGoatFragment.newInstance(livestock));
            fragmentTransaction.commit();
        }


    }

}
