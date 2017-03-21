package com.example.carlo.livestocktracker.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlo.livestocktracker.objects.Livestock;
import com.example.carlo.livestocktracker.dbhandlers.LivestockDBHandler;
import com.example.carlo.livestocktracker.R;

/**
 * Created by Carlo on 3/4/2017.
 */

public class AddUpdLivestockGoatFragment extends Fragment {

    private TextView tv_goatNum;
    private Button btn_addgoat;
    private EditText tId,tGoatNum,tType,tBreed,tHouseNum,tWeight;
    private ImageView tPhoto, sPhoto;
    private String sGoatNum,sType,sBreed,sHouseNum,sWeight;
    private static final String LIVESTOCK = "livestock_object";
    private int iId,iPhoto;

    private ImageView imageView;
    private EditText et_id, et_goatNum, et_breed, et_type, et_weight, et_houseNum;

    public static AddUpdLivestockGoatFragment newInstance(Livestock livestock){
        AddUpdLivestockGoatFragment fragment = new AddUpdLivestockGoatFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(LIVESTOCK, livestock);
        fragment.setArguments(bundle);
        return fragment;
    }

//    private ScannerFragment scannerFragment;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment_packages
        final View fragmentview = inflater.inflate(R.layout.fragment_addupdategoat, container, false);

        Bundle bundle = this.getArguments();
        Livestock livestock = (Livestock) bundle.getSerializable(LIVESTOCK);

        sPhoto = (ImageView) fragmentview.findViewById(R.id.iv_lstockpic);
        et_id = (EditText)fragmentview.findViewById(R.id.tvf_lgid);
        et_goatNum = (EditText)fragmentview.findViewById(R.id.tvf_lgnum);
        et_breed = (EditText)fragmentview.findViewById(R.id.sp_lgbreed);
        et_type = (EditText)fragmentview.findViewById(R.id.sp_lgtype);
        et_weight = (EditText)fragmentview.findViewById(R.id.et_lgweight);
        et_houseNum = (EditText)fragmentview.findViewById(R.id.et_lghouseNum);

        et_id.setText(""+livestock.getId());
        et_goatNum.setText(""+livestock.getNum());
      //  sPhoto.setImageResource(livestock.getPhoto());
        et_type.setText(""+livestock.getType());
        et_breed.setText(""+livestock.getBreed());
        et_houseNum.setText(""+livestock.getHouseNum());
        et_weight.setText(""+livestock.getWeight());

        return fragmentview;

    }

    @Override
    public void onViewCreated(View fragmentview, Bundle savedInstanceState) {
        // save views as variables in this method
        // "view" is the one returned from onCreateView
        btn_addgoat = (Button) fragmentview.findViewById(R.id.btn_save);

        tId = (EditText)fragmentview.findViewById(R.id.tvf_lgid);
        tGoatNum = (EditText)fragmentview.findViewById(R.id.tvf_lgnum);
        tPhoto = (ImageView)fragmentview.findViewById(R.id.iv_lstockpic);
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

                Fragment fr = null;
                fr = new LivestockFragment();

                if(db.CheckIsDataAlreadyInDBorNot(iId)== false){
                    db.addLivestock(livestock);
//test mo nga kung saan papasok -g wait
                    Toast.makeText(getActivity(), livestock.getNum() + " is added!",
                            Toast.LENGTH_LONG).show();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fr);
                    fragmentTransaction.commit();
//
                } else {
                    db.updateLivestock(livestock);
                    Toast.makeText(getActivity(), livestock.getNum() + " is updated!",
                            Toast.LENGTH_LONG).show();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fr);
                    fragmentTransaction.commit();

                }


            }
        });

    }


}
