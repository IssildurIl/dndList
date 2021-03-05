package com.example.dndlist.utils.RecycleView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dndlist.R;
import com.example.dndlist.model.Character;

import java.util.ArrayList;

public class RecycleViewAdaptor extends RecyclerView.Adapter<RecycleViewAdaptor.CustomViewHolder> {

    private ArrayList<Character> mExampleList;
    Context context;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public RecycleViewAdaptor(Context ct,ArrayList<Character> ExampleList){
        context=ct;
        mExampleList=ExampleList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleviewraw, parent, false);
        return new CustomViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Character currentItem = mExampleList.get(position);
        holder.tvName.setText(currentItem.getName());
        holder.tvRace.setText(currentItem.getRace());
        holder.tvLvl.setText(String.valueOf(currentItem.getLvl())+" lvl");
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvRace,tvLvl;
        ImageView mDeleteImage;
        public CustomViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            tvName = itemView.findViewById(R.id.textName);
            tvRace = itemView.findViewById(R.id.textRace);
            tvLvl = itemView.findViewById(R.id.textLvl);
            mDeleteImage = itemView.findViewById(R.id.delImg);
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) listener.onItemClick(position);
                }
            });
            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }
}