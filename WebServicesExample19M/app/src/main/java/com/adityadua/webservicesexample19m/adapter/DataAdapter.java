package com.adityadua.webservicesexample19m.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.adityadua.webservicesexample19m.R;
import com.adityadua.webservicesexample19m.model.ItemData;

import java.util.List;

/**
 * Created by AdityaDua on 18/08/18.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    Context context;
    List<ItemData> data;
    ClickListener clickListener;

    public ClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public DataAdapter(Context context, List<ItemData> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row,null);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.name.setText(data.get(position).getName());
        holder.character.setText(data.get(position).getCharacter());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.itemClicked(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,order,character;
        RelativeLayout relativeLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            order = (TextView) itemView.findViewById(R.id.order);
            character = (TextView) itemView.findViewById(R.id.character);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.rlayout);

        }
    }

    public interface ClickListener{
        void itemClicked(View v,int position);
    }



}
