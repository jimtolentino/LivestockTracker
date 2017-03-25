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

import static android.R.attr.id;
import static android.R.id.message;

/**
 * Created by Carlo on 3/4/2017.
 */

public class AddUpdLivestockGoatFragment extends Fragment {

    private TextView tv_goatNum;
    private Button btn_save;
    private EditText tId,tGoatNum,tType,tBreed,tHouseNum,tWeight;
    private ImageView tPhoto, sPhoto;
    private String sGoatNum,sType,sBreed,sHouseNum,sWeight;
    private static final String LIVESTOCK = "livestock_object";
    private int iId,iPhoto;
    private ImageView imageView;
    //private EditText et_id, et_goatNum, et_breed, et_type, et_weight, et_houseNum;
    private boolean vFlag;

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
        tId = (EditText)fragmentview.findViewById(R.id.tvf_lgid);
        tGoatNum = (EditText)fragmentview.findViewById(R.id.tvf_lgnum);
        tBreed = (EditText)fragmentview.findViewById(R.id.sp_lgbreed);
        tType = (EditText)fragmentview.findViewById(R.id.sp_lgtype);
        tWeight = (EditText)fragmentview.findViewById(R.id.et_lgweight);
        tHouseNum = (EditText)fragmentview.findViewById(R.id.et_lghouseNum);

        tId.setText(""+livestock.getId());
        tGoatNum.setText(livestock.getNum());
      //  sPhoto.setImageResource(livestock.getPhoto());
        tType.setText(livestock.getType());
        tBreed.setText(livestock.getBreed());
        tHouseNum.setText(livestock.getHouseNum());
        tWeight.setText(livestock.getWeight());

        return fragmentview;

    }

    @Override
    public void onViewCreated(View fragmentview, Bundle savedInstanceState) {
        // save views as variables in this method
        // "view" is the one returned from onCreateView
        btn_save = (Button) fragmentview.findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (validate()== false) {
                    Livestock livestock = new Livestock();

                    livestock.setId(Integer.parseInt(tId.getText().toString()));
                    livestock.setNum(tGoatNum.getText().toString());
                    livestock.setType(tType.getText().toString());
                    livestock.setBreed(tBreed.getText().toString());
                    livestock.setHouseNum(tHouseNum.getText().toString());
                    livestock.setWeight(tWeight.getText().toString());
                    LivestockDBHandler db = new LivestockDBHandler(getActivity());

                    Fragment fr = null;
                    fr = new LivestockFragment();

                    if (db.CheckIsDataAlreadyInDBorNot(iId) == false) {
                        db.addLivestock(livestock);

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
            }
        });

    }

    private boolean validate(){
        boolean errors = false;
        if(tId.getText().toString().matches("")){
            tId.setError("Please enter ID.");
            errors = true;
        }
        else if(tGoatNum.getText().toString().matches("")){
            tGoatNum.setError("Please enter goat number.");
            errors = true;
        }
        else if(tType.getText().toString().matches("")){
            tType.setError("Please enter type of livestock.");
            errors = true;
        }
        else if(tBreed.getText().toString().matches("")){
            tBreed.setError("Please enter breed.");
            errors = true;
        }
        else if(tHouseNum.getText().toString().matches("")){
            tHouseNum.setError("Please enter house number.");
            errors = true;
        }
        else if(tWeight.getText().toString().matches("")){
            tWeight.setError("Please enter weight of the livestock.");
            errors = true;
        }
        return errors;

    }


}
