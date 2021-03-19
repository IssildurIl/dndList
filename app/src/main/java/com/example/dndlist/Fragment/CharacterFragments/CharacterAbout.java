package com.example.dndlist.Fragment.CharacterFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dndlist.R;
import com.example.dndlist.model.Character;
import com.example.dndlist.repository.DbUtil;


public class CharacterAbout extends Fragment {


    TextView name, race;
    Character character;

    EditText etCharacterName, etCharacterRace, etCharacterClass, etCharacterAlignment;

    public CharacterAbout() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_about, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DbUtil.init(getContext());
        getActivity().findViewById(R.id.bottom_navigation).setVisibility(View.VISIBLE);
        name = view.findViewById(R.id.tvCharacterNameAboutFragment);
        race = view.findViewById(R.id.tvCharacterRaceAboutFragment);
        character = DbUtil.getCurrentCharacter();
        name.setText(character.getName());
        race.setText(character.getRace());

        etCharacterName = view.findViewById(R.id.etCharacterName);
        etCharacterRace = view.findViewById(R.id.etCharacterRace);
        etCharacterClass = view.findViewById(R.id.etCharacterClass);
        etCharacterAlignment = view.findViewById(R.id.etCharacterAlignment);

        etCharacterName.setText(character.getName());
        etCharacterRace.setText(character.getRace());
        etCharacterClass.setText(character.getCharClass());
        etCharacterAlignment.setText(character.getAlignment());
    }
}