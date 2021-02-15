package com.example.dndlist.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dndlist.R;
import com.example.dndlist.utils.RecycleViewAdaptor;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChooseCharacter#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseCharacter extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String charName[],charRace[],charLvl[];
    RecyclerView recyclerView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChooseCharacter() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ChooseCharacter newInstance(String param1, String param2) {
        ChooseCharacter fragment = new ChooseCharacter();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        charRace = getResources().getStringArray(R.array.chars);
        charName = getResources().getStringArray(R.array.race);
        charLvl = getResources().getStringArray(R.array.lvl);

        View view = inflater.inflate(R.layout.fragment_choose_character, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.chars_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecycleViewAdaptor rva = new RecycleViewAdaptor(getActivity(),charName,charRace,charLvl);
        recyclerView.setAdapter(rva);
        return view;
    }
}