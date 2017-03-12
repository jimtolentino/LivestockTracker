//package com.example.carlo.livestocktracker;
//
//import android.content.Context;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//public class ImageAdapter extends BaseAdapter {
//    private Context mContext;
//    private final Livestock[] livestock;
//
//    // Constructor
//    public ImageAdapter(Context c, Livestock[] livestock) {
//        mContext = c;
//        this.livestock = livestock;
//    }
//
//    public int getCount() {
//        return livestock.length;
//    }
//
//    public Object getItem(int position) {
//        return null;
//    }
//
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    // create a new ImageView for each item referenced by the Adapter
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        final Livestock lstock = livestock[position];
//
//
//        if (convertView == null) {
//            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
//            convertView = layoutInflater.inflate(R.layout.card_view_list, null);
//        }
//
//        final ImageView imageView = (ImageView)convertView.findViewById(R.id.goat_art);
//        final TextView nameTextView = (TextView)convertView.findViewById(R.id.tv_goatnum);
//
//        imageView.setImageResource(lstock.getImageResource());
//        nameTextView.setText(mContext.getString(lstock.getLStocknum()));
//        return imageView;
//    }
//
//    //Images in array
//
//}