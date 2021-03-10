package com.example.dndlist.Fragment;

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

import com.example.dndlist.R;
import com.example.dndlist.model.Character;
import com.example.dndlist.utils.RecycleView.ExampleItem;
import com.example.dndlist.utils.RecycleView.RecycleViewAdaptor;

import java.util.ArrayList;

public class ChooseCharacter extends Fragment {

    RecyclerView mRecyclerView;
    private ArrayList<Character> mExampleList;
    private RecycleViewAdaptor mAdapter;
    FragmentManager myFragmentManager;
    private RecyclerView.LayoutManager mLayoutManager;
    final static String KEY_MSG_1 = "FRAGMENT1_MSG";
    final static String TAG_1 = "FRAGMENT_1";
    FragmentManager childFragMang;
    public ChooseCharacter() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        childFragMang =getChildFragmentManager();
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
        //view.findViewById(R.id.fab).setOnClickListener(view1 -> navController.navigate(R.id.go_to_createCharacter));
        view.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = 0;
                insertItem(position);
                position+=1;
            }
        });

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

    public void buildRecyclerView() { //НЕ ТРОГАТЬ
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new RecycleViewAdaptor(getContext(),mExampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
    public void createExampleList() {
        mExampleList = new ArrayList<>();
//        mExampleList.add(new Character("Vasya","gobbo",3));
//        mExampleList.add(new Character("V","g",3));
    }
    public void CreateCustomList(String name,String race, Integer pos){
        mExampleList = new ArrayList<>();
        mExampleList.add(new Character(name,race,pos));
        mAdapter.notifyDataSetChanged();
    }

    public void insertItem(int position) {
        mExampleList.add(position, new Character());
        mAdapter.notifyItemInserted(position);
    }
    public void removeItem(int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }
}