package com.example.dndlist.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dndlist.R;
import com.example.dndlist.model.Character;
import com.example.dndlist.utils.RecycleView.ExampleItem;
import com.example.dndlist.utils.RecycleView.RecycleViewAdaptor;

import java.util.ArrayList;

public class ChooseCharacter extends Fragment {

    RecyclerView mRecyclerView;
    private ArrayList<Character> mExampleList;
    private RecycleViewAdaptor mAdapter;
    public int position=0;
    public ChooseCharacter() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return Recycle(inflater,container);
    }

    public View Recycle(LayoutInflater inflater,ViewGroup container){
        View view = inflater.inflate(R.layout.fragment_choose_character, container, false);
        mRecyclerView = view.findViewById(R.id.chars_rec);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecycleViewAdaptor rva = new RecycleViewAdaptor(getContext(),mExampleList);
        mRecyclerView.setAdapter(rva);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createExampleList();
        buildRecyclerView();
        if(getArguments() != null) {
            Character character = new Character();
            String arg1Value = getArguments().getString("arg1");
            String arg2Value = getArguments().getString("arg2");
            int arg3Value = getArguments().getInt("arg3");
            character.setName(arg1Value);
            character.setRace(arg2Value);
            character.setLvl(arg3Value);
            mExampleList.add(position, character);
            mAdapter.notifyItemInserted(position);
        }
        NavController navController = Navigation.findNavController(view);
        view.findViewById(R.id.fab).setOnClickListener(v -> navController.navigate(R.id.go_to_createCharacter));

        mAdapter.setOnItemClickListener(new RecycleViewAdaptor.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                navController.navigate(R.id.go_to_createCharacter);
            }
            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }

            @Override
            public void onCorrectClick(int position) {
            }
        });
    }

    public void buildRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new RecycleViewAdaptor(getContext(),mExampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
    public void createExampleList() {
        mExampleList = new ArrayList<>();
    }

    public void removeItem(int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

}