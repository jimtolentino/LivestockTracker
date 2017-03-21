//package com.example.carlo.livestocktracker.fragments;
//
//import android.app.Fragment;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.ImageView;
//
//import com.example.carlo.livestocktracker.R;
//import com.example.carlo.livestocktracker.objects.Livestock;
//
///**
// * Created by Carlo on 3/19/2017.
// */
//
//public class LivestockDetailsFragment extends Fragment {
//
//    private static final String LIVESTOCK = "livestock_object";
//    private Livestock livestock;
//    private ImageView imageView;
//    private EditText tv_id, tv_goatNum, tv_breed, tv_type, tv_weight, tv_houseNum;
//
//    public static LivestockDetailsFragment newInstance(Livestock livestock){
//        LivestockDetailsFragment fragment = new LivestockDetailsFragment();
//        Bundle bundle = new Bundle();
//        bundle.putSerializable(LIVESTOCK, livestock);
//        fragment.setArguments(bundle);
//        return fragment;
//    }
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.fragment_detail_livestock);
//        final View fragmentview = inflater.inflate(R.layout.fragment_addupdategoat, container, false);
//
//        Bundle bundle = this.getArguments();
//        Livestock livestock = (Livestock) bundle.getSerializable(LIVESTOCK);
//
//        imageView = (ImageView) fragmentview.findViewById(R.id.iv_lstockpic);
//        tv_id = (EditText)fragmentview.findViewById(R.id.tvf_lgid);
//        tv_goatNum = (EditText)fragmentview.findViewById(R.id.tvf_lgnum);
//        tv_breed = (EditText)fragmentview.findViewById(R.id.sp_lgbreed);
//        tv_type = (EditText)fragmentview.findViewById(R.id.sp_lgtype);
//        tv_weight = (EditText)fragmentview.findViewById(R.id.et_lgweight);
//        tv_houseNum = (EditText)fragmentview.findViewById(R.id.et_lghouseNum);
//
//        tv_id.setText(""+livestock.getId());
//        tv_goatNum.setText(""+livestock.getNum());
//        imageView.setImageResource(livestock.getPhoto());
//        tv_type.setText(""+livestock.getType());
//        tv_breed.setText(""+livestock.getBreed());
//        tv_houseNum.setText(""+livestock.getHouseNum());
//        tv_weight.setText(""+livestock.getWeight());
//
//        return fragmentview;
//
//    }
//
//}
