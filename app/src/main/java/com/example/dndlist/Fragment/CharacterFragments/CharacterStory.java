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


public class CharacterStory extends Fragment {

    TextView name, race;
    Character character;

    EditText etCharacterStoryIdeals;
    EditText etCharacterStoryPersonalityTraits;
    EditText etCharacterStoryBonds;
    EditText etCharacterStoryFlaws;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_character_story, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DbUtil.init(getContext());
        getActivity().findViewById(R.id.bottom_navigation).setVisibility(View.VISIBLE);
        name = view.findViewById(R.id.tvCharacterNameStoryFragment);
        race = view.findViewById(R.id.tvCharacterRaceStoryFragment);
        character = DbUtil.getCurrentCharacter();
        name.setText(character.getName());
        race.setText(character.getRace());

        etCharacterStoryIdeals = view.findViewById(R.id.etCharacterStoryIdeals);
        etCharacterStoryPersonalityTraits = view.findViewById(R.id.etCharacterStoryPersonalityTraits);
        etCharacterStoryBonds = view.findViewById(R.id.etCharacterStoryBonds);
        etCharacterStoryFlaws = view.findViewById(R.id.etCharacterStoryFlaws);

        etCharacterStoryBonds.setText(character.getBonds());
        etCharacterStoryPersonalityTraits.setText(character.getPersonalTraits());
        etCharacterStoryIdeals.setText(character.getIdeals());
        etCharacterStoryFlaws.setText(character.getFlaws());
    }
}
