package com.adityadua.recyclerviewandroiddemo;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 21/07/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private ItemData[] itemDatas;

   public MyAdapter(ItemData[] itemDatas){
       this.itemDatas = itemDatas;

   }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,null);
        ViewHolder vh = new ViewHolder(view);

        return  vh;


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.textViewTitle.setText(itemDatas[position].getName());
        holder.textViewFeatures.setText(itemDatas[position].getFeatures());
        holder.imageViewIcon.setImageResource(itemDatas[position].getUrl());

        holder.textViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Clicked On ::"+itemDatas[position].getName(),Snackbar.LENGTH_LONG)
                        .setAction("Action Here ",null).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemDatas.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewTitle;
        public ImageView imageViewIcon;
        public TextView textViewFeatures;


        public ViewHolder(View itemView) {
            super(itemView);

            textViewTitle = (TextView)itemView.findViewById(R.id.textView);
            imageViewIcon = (ImageView)itemView.findViewById(R.id.imageView);
            textViewFeatures = (TextView)itemView.findViewById(R.id.textView2);
        }
    }
}
