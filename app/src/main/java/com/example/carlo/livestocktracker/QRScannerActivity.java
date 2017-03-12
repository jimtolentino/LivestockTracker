//package com.example.carlo.livestocktracker;
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.os.Bundle;
//import android.util.Log;
//
//import android.view.View;
//import android.widget.Button;
//
//import com.google.zxing.Result;
//
//import me.dm7.barcodescanner.zxing.ZXingScannerView;
//
//
//
///**
// * Created by Carlo on 2/25/2017.
// */
//
//public class QRScannerActivity extends Activity implements ZXingScannerView.ResultHandler {
//
//    private ZXingScannerView mScannerView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
////
////        Button qrScan = (Button) findViewById(R.id.text_scan);
////        qrScan.setOnClickListener(mScanClickListener);
//    }
//
////    private View.OnClickListener mScanClickListener = new View.OnClickListener() {
////        @Override
////        public void onClick(View v) {
////            mScannerView = new ZXingScannerView(QRScannerActivity.this);
////            setContentView(mScannerView);
////            mScannerView.setResultHandler(QRScannerActivity.this);
////            mScannerView.startCamera();
////        }
////    };
//    public void onClick(View v){
//        mScannerView = new ZXingScannerView(this);
//        setContentView(mScannerView);
//        mScannerView.setResultHandler(this);
//        mScannerView.startCamera();
//        System.out.println("test");
//    }
//
//    @Override
//    protected void onPause(){
//        super.onPause();
//        mScannerView.stopCamera();
//    }
//
//    @Override
//    public void handleResult(Result result) {
//        Log.w("handleResult", result.getText());
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Scan Results");
//        builder.setMessage(result.getText());
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }
//}
