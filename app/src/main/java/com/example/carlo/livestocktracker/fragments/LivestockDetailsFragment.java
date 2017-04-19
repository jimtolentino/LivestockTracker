package com.example.carlo.livestocktracker.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlo.livestocktracker.objects.Livestock;
import com.example.carlo.livestocktracker.dbhandlers.LivestockDBHandler;
import com.example.carlo.livestocktracker.R;

import java.util.Random;

import static android.R.attr.id;
import static android.R.id.message;

/**
 * Created by Carlo on 3/4/2017.
 */

public class LivestockDetailsFragment extends Fragment {

    private TextView tv_goatNum;
    private Button btn_save;
    private ImageButton btn_changePhoto, btn_deleteLivestock;
    private EditText name,tag,weight,dateOfBirth,type,breed,offSpringCounter,status,houseNumber,qrCode,comments, medicalHistories,farm,investor;
    private ImageView sPhoto;
    private String qrCode1;
    private static final String LIVESTOCK = "livestock_object";
    private Fragment fr = null;
    String logTag = "error AddLivestock";
    String logTag1 = "error Oncreate";

    public static LivestockDetailsFragment newInstance(Livestock livestock){
        LivestockDetailsFragment fragment = new LivestockDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(LIVESTOCK, livestock);
        fragment.setArguments(bundle);
        return fragment;
    }

//    private ScannerFragment scannerFragment;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentview = inflater.inflate(R.layout.fragment_detail_livestock, container, false);
        //Inflate the layout for this fragment_packages
        try {

            Bundle bundle = this.getArguments();
            Livestock livestock = (Livestock) bundle.getSerializable(LIVESTOCK);

            sPhoto = (ImageView) fragmentview.findViewById(R.id.iv_lstockpic);
            btn_changePhoto = (ImageButton) fragmentview.findViewById(R.id.button_addphoto);
            btn_deleteLivestock = (ImageButton) fragmentview.findViewById(R.id.button_deletelstock);
            name = (EditText) fragmentview.findViewById(R.id.tvf_lgname);
            tag = (EditText) fragmentview.findViewById(R.id.tvf_lgtag);
            type = (EditText) fragmentview.findViewById(R.id.sp_lgtype);
            breed = (EditText) fragmentview.findViewById(R.id.sp_lgbreed);
            houseNumber = (EditText) fragmentview.findViewById(R.id.et_lghouseNum);
            weight = (EditText) fragmentview.findViewById(R.id.et_lgweight);
            //        dateOfBirth = (EditText)fragmentview.findViewById(R.id.et_lgdateofbirth);
            offSpringCounter = (EditText) fragmentview.findViewById(R.id.et_lgoffspringctr);
            status = (EditText) fragmentview.findViewById(R.id.et_lgstatus);
            qrCode = (EditText) fragmentview.findViewById(R.id.et_lgqrcode);
            //

            name.setText(livestock.getName());
            //  sPhoto.setImageResource(livestock.getPhoto());
            tag.setText(livestock.getTag());
            type.setText(livestock.getType());
            breed.setText(livestock.getBreed());
            houseNumber.setText(livestock.getHouseNumber());
            weight.setText(livestock.getWeight() != null ? livestock.getWeight().toString(): "");
            offSpringCounter.setText(livestock.getOffSpringCounter() != null ? livestock.getOffSpringCounter().toString(): "");
            status.setText(livestock.getStatus());
            qrCode.setText(livestock.getQrCode());

        } catch (Exception e){
            Log.e(logTag1, e.getMessage());
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return fragmentview;
    }

    @Override
    public void onViewCreated(View fragmentview, Bundle savedInstanceState) {
        // save views as variables in this method
        // "view" is the one returned from onCreateView
        btn_save = (Button) fragmentview.findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) throws android.database.SQLException {

//                    Toast.makeText(dtoFactory, "Test 0", Toast.LENGTH_LONG).show();
                try {

                    if (validate() == false) {
                        Livestock livestock = new Livestock();

                        livestock.setId(new Random().nextInt(10));
                        livestock.setName(name.getText().toString());
                        livestock.setTag(tag.getText().toString());
                        livestock.setWeight(Double.parseDouble(weight.getText().toString()));
                        //                    livestock.setDateOfBirth(dateOfBirth.getText().toString());
                        livestock.setType(type.getText().toString());
                        livestock.setBreed(breed.getText().toString());
                        livestock.setOffSpringCounter(Integer.parseInt(offSpringCounter.getText().toString()));
                        livestock.setStatus(status.getText().toString());
                        livestock.setHouseNumber(houseNumber.getText().toString());
                        //                    livestock.setComments(comments.getText().toString());
                        //                    livestock.setMedicalHistories(medicalHistories.getText().toString());
                        //                    livestock.setDisplayPicture(displayPicture.getText().toString());
                        //                    livestock.setFarm(farm.getText().toString());
                        //                    livestock.setInvestor(investor.getText().toString());
                        livestock.setQrCode(qrCode.getText().toString());

                        LivestockDBHandler db = new LivestockDBHandler(getActivity());

                        qrCode1 = qrCode.getText().toString();

                        fr = new LivestockFragment();

                        if (db.CheckIsDataAlreadyInDBorNot(qrCode1) == false) {
                            livestock.setId(new Random().nextInt(10));
                            db.addLivestock(livestock);
                            Toast.makeText(getActivity(), livestock.getTag() + " is added!",
                                    Toast.LENGTH_LONG).show();
                            FragmentManager fm = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                            fragmentTransaction.replace(R.id.fragment_container, fr);
                            fragmentTransaction.commit();

                        } else {

                            if(db.CheckIsActive(qrCode1)){
                                db.updateLivestock(livestock);
                                Toast.makeText(getActivity(), livestock.getTag() + " is updated!",
                                        Toast.LENGTH_LONG).show();
                                FragmentManager fm = getFragmentManager();
                                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                fragmentTransaction.replace(R.id.fragment_container, fr);
                                fragmentTransaction.commit();
                            } else{
                                Toast.makeText(getActivity(), "Inactive livestock cannot be updated.", Toast.LENGTH_LONG).show();
                            }

                        }
                    }
                }catch (Exception e){
                    Log.e(logTag, e.getMessage());
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_changePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                fr = new CapturePhotoFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fr);
                fragmentTransaction.commit();
            }
        });

        btn_deleteLivestock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LivestockDBHandler db = new LivestockDBHandler(getActivity());

                String qrCode1 = qrCode.getText().toString();

                db.deleteLivestock(qrCode1);
                fr = new LivestockFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fr);
                fragmentTransaction.commit();

            }
        });

    }

    private boolean validate(){
        boolean errors = false;
        if(name.getText().toString().matches("")){
            name.setError("Please enter Name.");
            errors = true;
        }
        else if(tag.getText().toString().matches("")){
            tag.setError("Please enter Ear Tag Number.");
            errors = true;
        }
        else if(weight.getText().toString().matches("")){
            weight.setError("Please enter Weight.");
            errors = true;
        }
        else if(type.getText().toString().matches("")){
            type.setError("Please enter Type.");
            errors = true;
        }
        else if(breed.getText().toString().matches("")){
            breed.setError("Please enter Breed.");
            errors = true;
        }
        else if(offSpringCounter.getText().toString().matches("")){
            offSpringCounter.setError("Please enter Offspring Counter.");
            errors = true;
        }
        else if(status.getText().toString().matches("")){
            status.setError("Please enter Status.");
            errors = true;
        }
        else if(houseNumber.getText().toString().matches("")){
            houseNumber.setError("Please enter House Number.");
            errors = true;
        }

        return errors;

    }


}
