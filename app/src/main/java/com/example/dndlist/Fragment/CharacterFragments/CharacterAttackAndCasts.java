package com.example.dndlist.Fragment.CharacterFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dndlist.R;
import com.example.dndlist.model.Character;
import com.example.dndlist.repository.DbUtil;


public class CharacterAttackAndCasts extends Fragment {


    TextView name, race;
    Character character;


    public CharacterAttackAndCasts() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_attack_and_casts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DbUtil.init(getContext());
        getActivity().findViewById(R.id.bottom_navigation).setVisibility(View.VISIBLE);
        name = view.findViewById(R.id.tvCharacterNameCastsFragment);
        race = view.findViewById(R.id.tvCharacterRaceCastsFragment);
        character = DbUtil.getCurrentCharacter();
        name.setText(character.getName());
        race.setText(character.getRace());
    }
}