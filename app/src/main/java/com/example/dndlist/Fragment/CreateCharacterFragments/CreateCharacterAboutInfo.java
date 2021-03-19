package com.example.dndlist.Fragment.CreateCharacterFragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.dndlist.R;
import com.example.dndlist.dao.CharacterDao;
import com.example.dndlist.model.Character;
import com.example.dndlist.repository.DbUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class CreateCharacterAboutInfo extends Fragment {
    private static final String TAG = CreateCharacterAboutInfo.class.getName();
    NavController navController;
    EditText etCreateCharacterAboutIdeals;
    EditText etCreateCharacterAboutPersonalityTraits;
    EditText etCreateCharacterAboutBonds;
    EditText etCreateCharacterAboutFlaws;
    FloatingActionButton fabCreateCharacterAboutComplete;


    public CreateCharacterAboutInfo() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_character_about_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Character character = DbUtil.getCurrentCharacter();
        Log.d(TAG, "onViewCreated: " + character.toString());
        DbUtil.init(getContext());
        navController = Navigation.findNavController(view);
        etCreateCharacterAboutIdeals = view.findViewById(R.id.etCreateCharacterAboutIdeals);
        etCreateCharacterAboutPersonalityTraits = view.findViewById(R.id.etCreateCharacterAboutPersonalityTraits);
        etCreateCharacterAboutBonds = view.findViewById(R.id.etCreateCharacterAboutBonds);
        etCreateCharacterAboutFlaws = view.findViewById(R.id.etCreateCharacterAboutFlaws);
        fabCreateCharacterAboutComplete = view.findViewById(R.id.fabCreateCharacterAboutComplete);

        fabCreateCharacterAboutComplete.setOnClickListener(v -> {
            character.setIdeals(etCreateCharacterAboutIdeals.getText().toString());
            character.setPersonalTraits(etCreateCharacterAboutPersonalityTraits.getText().toString());
            character.setBonds(etCreateCharacterAboutBonds.getText().toString());
            character.setFlaws(etCreateCharacterAboutFlaws.getText().toString());
            new UpdateCharacter().execute(character);
        });
    }

    private class UpdateCharacter extends AsyncTask<Character, Void, Character> {

        @Override
        protected Character doInBackground(Character... characters) {
            Character character = characters[0];
            CharacterDao characterDao = DbUtil.getInstance().characterDao();
            characterDao.update(character);
            return character;
        }

        @Override
        protected void onPostExecute(Character character) {
            Log.d(TAG, "onPostExecute: " + character);
            DbUtil.setCurrentCharacter(character);
            navController.navigate(R.id.action_createCharacterAboutInfo_to_characterStats);
        }
    }
}