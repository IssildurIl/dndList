package com.example.dndlist.utils.RecycleView;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dndlist.R;
import com.example.dndlist.model.Character;

import java.util.ArrayList;

public class RecycleViewAdaptor extends RecyclerView.Adapter<RecycleViewAdaptor.CustomViewHolder> {

    private ArrayList<Character> mExampleList;
    Context context;
    private OnItemClickListener mListener;
    public static int odd = 0 ;

    public interface OnItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position);
        void onCorrectClick(int position);
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
        holder.tvLvl.setText(currentItem.getLvl() +" lvl");
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }




    public class CustomViewHolder extends RecyclerView.ViewHolder{
        EditText tvName,tvRace,tvLvl;
        ImageView mDeleteImage,mCorrImg;

        public CustomViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            tvName = itemView.findViewById(R.id.nameText);
            tvRace = itemView.findViewById(R.id.raceText);
            tvLvl = itemView.findViewById(R.id.lvlText);
            mCorrImg = itemView.findViewById(R.id.corrImg);
            mDeleteImage = itemView.findViewById(R.id.delImg);
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
            mDeleteImage.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onDeleteClick(position);
                    }
                }
            });
            mCorrImg.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onCorrectClick(position);
                        odd = odd+1;
                        if ( odd % 2 == 0 ) {
                            unlockEditText(tvName);
                            unlockEditText(tvRace);
                            unlockEditText(tvLvl);
                        }
                        else{
                            lockEditText(tvName);
                            lockEditText(tvRace);
                            lockEditText(tvLvl);
                        }
                    }
                }
            });

        }
    }

    protected static void lockEditText(EditText text){
        text.setFocusableInTouchMode(false);
        text.setFocusable(false);
    }
    protected static void unlockEditText(EditText text){
        text.setFocusableInTouchMode(true);
        text.setFocusable(true);
    }
}