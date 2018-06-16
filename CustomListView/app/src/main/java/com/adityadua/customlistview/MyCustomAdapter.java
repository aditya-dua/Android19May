package com.adityadua.customlistview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AdityaDua on 10/06/18.
 */

public class MyCustomAdapter extends ArrayAdapter<String> {

    Activity context;
    String [] titleStr;
    String [] subTitleStr;
    Integer [] imgResLink;


    public MyCustomAdapter(Activity context,String [] titleStr,String [] subTitleStr,Integer [] imgResLink){

        super(context,R.layout.row,titleStr);

        this.context = context;
        this.titleStr = titleStr;
        this.subTitleStr = subTitleStr;
        this.imgResLink = imgResLink;

    }


    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.row,null,true);

        TextView titleTV = (TextView) rowView.findViewById(R.id.titleTV);
        TextView subTitleTV = (TextView) rowView.findViewById(R.id.subTitleTV);
        ImageView imageView = (ImageView)rowView.findViewById(R.id.iconIV);

        titleTV.setText(titleStr[position]);
        subTitleTV.setText(subTitleStr[position]);
        imageView.setImageResource(imgResLink[position]);




        return rowView;
    }
}
