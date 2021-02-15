package com.example.dndlist.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dndlist.R;

public class RecycleViewAdaptor extends RecyclerView.Adapter<RecycleViewAdaptor.CustomViewHolder> {


    String charName[],charRace[],charLvl[];
    Context context;

    public RecycleViewAdaptor(Context ct,String Name[], String Race[], String Lvl[]){
        context=ct;
        charName = Name;
        charRace=Race;
        charLvl=Lvl;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycleviewraw,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tvName.setText(charName[position]);
        holder.tvRace.setText(charRace[position]);
        holder.tvLvl.setText(charLvl[position]);
    }

    @Override
    public int getItemCount() {
        return charName.length;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvRace,tvLvl;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.textName);
            tvRace = itemView.findViewById(R.id.textRace);
            tvLvl = itemView.findViewById(R.id.textLvl);
        }
    }
}
