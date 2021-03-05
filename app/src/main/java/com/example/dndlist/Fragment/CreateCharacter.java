package com.example.dndlist.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import com.example.dndlist.Fragment.FragmentInFragment.CharactersCharList;
import com.example.dndlist.Fragment.FragmentInFragment.ExtraStatsCharList;
import com.example.dndlist.Fragment.FragmentInFragment.ModificatorsCharList;
import com.example.dndlist.Fragment.FragmentInFragment.SaveDropsCharList;
import com.example.dndlist.R;
import com.example.dndlist.model.Character;
import com.example.dndlist.utils.FragmentAdaptor.FragmentAdaptor;
import com.google.android.material.tabs.TabLayout;


public class CreateCharacter extends Fragment {
    TabLayout charsAndModsTabLayout,saveAndStatTabLayout;
    ViewPager vp,vp1;
    View customFragment;
    EditText name, lvl, race;


    @Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        customFragment= inflater.inflate(R.layout.fragment_create_character, container, false);
        vp = customFragment.findViewById(R.id.vp);
        vp1 = customFragment.findViewById(R.id.vp1);
        charsAndModsTabLayout = customFragment.findViewById(R.id.charsAndMods);
        saveAndStatTabLayout = customFragment.findViewById(R.id.saveAndStat);
        return customFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpViewPager(vp);
        setUpViewPager1(vp1);
        charsAndModsTabLayout.setupWithViewPager(vp);
        saveAndStatTabLayout.setupWithViewPager(vp1);
        charsAndModsTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        saveAndStatTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setUpViewPager(ViewPager vp) {
        FragmentAdaptor adaptor = new FragmentAdaptor(getChildFragmentManager());
        adaptor.addFragment(new CharactersCharList(),"Характеристики");
        adaptor.addFragment(new ModificatorsCharList(),"Модификаторы");
        vp.setAdapter(adaptor);
    }
    private void setUpViewPager1(ViewPager vp1) {
        FragmentAdaptor adaptor1 = new FragmentAdaptor(getChildFragmentManager());
        adaptor1.addFragment(new SaveDropsCharList(),"Спасброски");
        adaptor1.addFragment(new ExtraStatsCharList(),"Доп Статы");
        vp1.setAdapter(adaptor1);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);

        name = view.findViewById(R.id.textName);
        race = view.findViewById(R.id.textRace);
        lvl = view.findViewById(R.id.textLvl);

        view.findViewById(R.id.redCharBtn).setOnClickListener(view1 ->{
            createChar();
            navController.navigate(R.id.go_to_chooseCharacter);
        });
    }

    private void createChar() {
        ChooseCharacter chooseCharacter = new ChooseCharacter();
        chooseCharacter.CreateCustomList("Eblan","Eblanovich",3);
//        Character character = new Character();name.getText().toString(),race.getText().toString(),Integer.parseInt(lvl.getText().toString())
//        character.setName(name.getText().toString());
//        character.setRace(race.getText().toString());
//        character.setLvl(Integer.parseInt(String.valueOf(lvl)));
    }


}