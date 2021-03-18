package com.example.dndlist.utils.RecycleView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dndlist.R;

public class CharacterViewHolder extends RecyclerView.ViewHolder {

    TextView characterNameRecyclerView;
    TextView characterRaceRecyclerView;
    TextView characterLvlRecyclerView;

    public CharacterViewHolder(@NonNull View itemView) {
        super(itemView);
        characterNameRecyclerView = itemView.findViewById(R.id.characterNameRecyclerView);
        characterRaceRecyclerView = itemView.findViewById(R.id.characterRaceRecyclerView);
        characterLvlRecyclerView = itemView.findViewById(R.id.characterLvlRecyclerView);
    }

    public void setCharacterLvl(String lvl) {
        this.characterLvlRecyclerView.setText(lvl);
    }

    public void setCharacterRace(String race) {
        this.characterRaceRecyclerView.setText(race);
    }

    public void setCharacterName(String name) {
        this.characterNameRecyclerView.setText(name);
    }
}
