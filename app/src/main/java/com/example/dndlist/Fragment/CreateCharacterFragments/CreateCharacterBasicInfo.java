package com.example.dndlist.Fragment.CreateCharacterFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.dndlist.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class CreateCharacterBasicInfo extends Fragment {

    FloatingActionButton goToCreateCharacterAboutFab;
    NavController navController;

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

        navController = Navigation.findNavController(view);
        goToCreateCharacterAboutFab = view.findViewById(R.id.goToCreateCharacterAboutInfoFab);

        goToCreateCharacterAboutFab.setOnClickListener(v -> {
            navController.navigate(R.id.action_createCharacterBasicInfo_to_createCharacterAboutInfo);
        });
    }
}