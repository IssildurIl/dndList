package com.example.dndlist.Fragment.VIewPagerFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.dndlist.R;

import java.util.concurrent.atomic.AtomicInteger;


public class SaveDropsCharList extends Fragment {

    RadioButton rbStr, rbDex, rbBody, rbIntel, rbChar, rbWisdom;

    int numberOfChecked = 0;

    public SaveDropsCharList() {


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.view_pager_save_drops, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rbSettings(view);
        NavController navController = Navigation.findNavController(view);

    }

    public void rbSettings(View view){
        rbStr = view.findViewById(R.id.rbStr);
        rbCheckedAciton(rbStr);
        rbDex = view.findViewById(R.id.rbDex);
        rbCheckedAciton(rbDex);
        rbBody = view.findViewById(R.id.rbBody);
        rbCheckedAciton(rbBody);
        rbIntel = view.findViewById(R.id.rbIntel);
        rbCheckedAciton(rbIntel);
        rbChar = view.findViewById(R.id.rbChar);
        rbCheckedAciton(rbChar);
        rbWisdom = view.findViewById(R.id.rbWisd);
        rbCheckedAciton(rbWisdom);
    }

    public void rbCheckedAciton(RadioButton rb) {
       AtomicInteger odd = new AtomicInteger();
       rb.setOnClickListener(v -> {
           odd.set(odd.get() + 1);
           rb.setChecked(odd.get() % 2 != 0);
           if (rb.isChecked()){
               numberOfChecked++;
           }
           if (numberOfChecked >= 3) {
               rb.setChecked(false);
           }
           if (!rb.isChecked()){
               numberOfChecked--;
           }
       });
    }

}