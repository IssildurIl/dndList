package com.example.dndlist.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dndlist.R;
import com.example.dndlist.utils.RecycleView.ExampleItem;
import com.example.dndlist.utils.RecycleView.RecycleViewAdaptor;

import java.util.ArrayList;

public class ChooseCharacter extends Fragment {

    RecyclerView mRecyclerView;
    private ArrayList<ExampleItem> mExampleList;
    private RecycleViewAdaptor mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

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
        mRecyclerView = (RecyclerView)view.findViewById(R.id.chars_rec);
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
        NavController navController = Navigation.findNavController(view);
        view.findViewById(R.id.fab).setOnClickListener(view1 -> navController.navigate(R.id.go_to_createCharacter));
        mAdapter.setOnItemClickListener(position -> navController.navigate(R.id.go_to_characterList));
    }

    public void buildRecyclerView() { //НЕ ТРОГАТЬ
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new RecycleViewAdaptor(getContext(),mExampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem("Vasya","gobbo","3lvl"));
        mExampleList.add(new ExampleItem("V","g","3lvl"));

    }
}