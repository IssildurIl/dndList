package com.example.dndlist.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dndlist.R;
import com.example.dndlist.dao.CharacterDao;
import com.example.dndlist.model.Character;
import com.example.dndlist.repository.DbUtil;
import com.example.dndlist.utils.RecycleView.CharacterListAdapter;

import java.util.List;

public class CharactersMenu extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CharacterListAdapter characterListAdapter;
    NavController navController;


    public CharactersMenu() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_characters_menu, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        view.findViewById(R.id.fab).setOnClickListener(v -> navController.navigate(R.id.action_charactersMenu_to_createCharacterBasicInfo));

        DbUtil.init(getContext());
        setUpRecyclerView(view);
    }

    private void setUpRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.charactersRecyclerView);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        new RecyclerViewSetter().execute();
    }

    private class RecyclerViewSetter extends AsyncTask<Void, Void, List<Character>> {

        @Override
        protected List<Character> doInBackground(Void... voids) {
            CharacterDao dao = DbUtil.getInstance().characterDao();
            return dao.getCharacter();
        }

        @Override
        protected void onPostExecute(List<Character> characters) {
            characterListAdapter = new CharacterListAdapter(characters, navController);
            recyclerView.setAdapter(characterListAdapter);
        }
    }

}