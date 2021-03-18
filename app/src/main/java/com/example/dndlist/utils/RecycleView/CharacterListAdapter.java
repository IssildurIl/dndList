package com.example.dndlist.utils.RecycleView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dndlist.R;
import com.example.dndlist.model.Character;
import com.example.dndlist.repository.DbUtil;

import java.util.ArrayList;
import java.util.List;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterViewHolder> {


    private static final String TAG = CharacterListAdapter.class.getName();

    private final List<Character> characterList;
    NavController navController;

    public CharacterListAdapter(List<Character> mDataSet, NavController controller) {
        this.characterList = new ArrayList<>(mDataSet);
        this.navController = controller;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character_item, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + " set.");
        if (characterList == null || characterList.isEmpty()) {
            return;
        }
        Character character = characterList.get(position);
        holder.setCharacterName(character.getName());
        holder.setCharacterLvl(character.getLvl() + " lvl");
        holder.setCharacterRace(character.getRace());

        holder.itemView.setOnClickListener(v -> {
            DbUtil.setCurrentCharacter(character);
            navController.navigate(R.id.action_charactersMenu_to_charactersStats);
        });
    }

    @Override
    public int getItemCount() {
        if (characterList == null) {
            return 0;
        }
        return characterList.size();
    }
}
