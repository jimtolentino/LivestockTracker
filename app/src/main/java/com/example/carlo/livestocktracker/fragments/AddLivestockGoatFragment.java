package com.example.carlo.livestocktracker.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carlo.livestocktracker.Livestock;
import com.example.carlo.livestocktracker.dbhandlers.LivestockDBHandler;
import com.example.carlo.livestocktracker.R;

/**
 * Created by Carlo on 3/4/2017.
 */

public class AddLivestockGoatFragment extends Fragment {

    private TextView tv_goatNum;
    private Button btn_addgoat;
    private EditText tId,tGoatNum,tType,tBreed,tHouseNum,tWeight;
    private ImageView tPhoto;
    private String sGoatNum,sType,sBreed,sHouseNum,sWeight;
    private int iId,iPhoto;

//    private ScannerFragment scannerFragment;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment_packages
        final View fragmentview = inflater.inflate(R.layout.fragment_addgoat, container, false);


////        scannerFragment = new ScannerFragment();
////        scannerFragment.handleResult(this);
////        tv_goatNum.setOnClickListener();



        return fragmentview;
    }

    @Override
    public void onViewCreated(View fragmentview, Bundle savedInstanceState) {
        // save views as variables in this method
        // "view" is the one returned from onCreateView
        btn_addgoat = (Button) fragmentview.findViewById(R.id.btn_addgoat);

        tId = (EditText)fragmentview.findViewById(R.id.tvf_lgid);
        tGoatNum = (EditText)fragmentview.findViewById(R.id.tvf_lgnum);
//        tPhoto = (ImageView)fragmentview.findViewById(R.id.iv_lstockpic);
        tType = (EditText)fragmentview.findViewById(R.id.sp_lgtype);
        tBreed = (EditText)fragmentview.findViewById(R.id.sp_lgbreed);
        tHouseNum = (EditText)fragmentview.findViewById(R.id.et_lghouseNum);
        tWeight = (EditText)fragmentview.findViewById(R.id.et_lgweight);



        btn_addgoat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                iId = Integer.parseInt(tId.getText().toString());
                sGoatNum = tGoatNum.getText().toString();
                sType = tType.getText().toString();
                sBreed = tBreed.getText().toString();
                sHouseNum = tHouseNum.getText().toString();
                sWeight = tWeight.getText().toString();

                Livestock livestock = new Livestock();

                livestock.setId(iId);
                livestock.setNum(sGoatNum);
                livestock.setType(sType);
                livestock.setBreed(sBreed);
                livestock.setHouseNum(sHouseNum);
                livestock.setWeight(sWeight);
//        iPhoto = Integer.parseInt(tPhoto.getI().toString());

                LivestockDBHandler db = new LivestockDBHandler(getActivity());
                db.addLivestock(livestock);
                Fragment fr = null;
                fr = new LivestockFragment();

                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fr);
                fragmentTransaction.commit();

            }
        });

    }


}
