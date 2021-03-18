package com.example.dndlist.Fragment.CreateCharacterFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dndlist.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateChatacterInventory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateChatacterInventory extends Fragment {

    public CreateChatacterInventory() {

    }


    public static CreateChatacterInventory newInstance(String param1, String param2) {
        CreateChatacterInventory fragment = new CreateChatacterInventory();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_chatacter_inventory, container, false);
    }
}