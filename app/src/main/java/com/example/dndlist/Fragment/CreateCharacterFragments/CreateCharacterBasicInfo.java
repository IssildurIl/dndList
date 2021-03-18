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


public class CreateCharacterBasicInfo extends Fragment {

    private static final String TAG = CreateCharacterBasicInfo.class.getName();

    FloatingActionButton goToCreateCharacterAboutFab;
    NavController navController;

    EditText etCharacterName;
    EditText etCharacterRace;
    EditText etCharacterClass;
    EditText etCharacterAlignment;


    public CreateCharacterBasicInfo() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_character_basic_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DbUtil.init(getContext());
        navController = Navigation.findNavController(view);
        goToCreateCharacterAboutFab = view.findViewById(R.id.goToCreateCharacterAboutInfoFab);
        etCharacterName = view.findViewById(R.id.etCharacterName);
        etCharacterRace = view.findViewById(R.id.etCharacterRace);
        etCharacterClass = view.findViewById(R.id.etCharacterClass);
        etCharacterAlignment = view.findViewById(R.id.etCharacterAlignment);

        goToCreateCharacterAboutFab.setOnClickListener(v -> {

            Character character = new Character();
            character.setName(etCharacterName.getText().toString());
            character.setRace(etCharacterRace.getText().toString());
            character.setCharClass(etCharacterClass.getText().toString());
            character.setAlignment(etCharacterAlignment.getText().toString());
            new CreateCharacter().execute(character);
        });
    }

    private class CreateCharacter extends AsyncTask<Character, Void, Character> {

        @Override
        protected Character doInBackground(Character... characters) {
            Character character = characters[0];
            CharacterDao characterDao = DbUtil.getInstance().characterDao();
            character.setId(characterDao.insert(character));
            return character;
        }

        @Override
        protected void onPostExecute(Character character) {
            Log.d(TAG, "onPostExecute: " + character);
            DbUtil.setCurrentCharacter(character);
            navController.navigate(R.id.action_createCharacterBasicInfo_to_createCharacterAboutInfo);
        }
    }

}