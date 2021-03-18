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

import com.example.dndlist.Fragment.VIewPagerFragment.CharactersCharList;
import com.example.dndlist.Fragment.VIewPagerFragment.ExtraStatsCharList;
import com.example.dndlist.Fragment.VIewPagerFragment.ModificatorsCharList;
import com.example.dndlist.Fragment.VIewPagerFragment.SaveDropsCharList;
import com.example.dndlist.R;
import com.example.dndlist.model.Character;
import com.example.dndlist.utils.FragmentAdaptor.FragmentAdaptor;
import com.google.android.material.tabs.TabLayout;


public class CreateCharacter extends Fragment {
    private final static String TAG = "CreateCharacter";
    TabLayout charsAndModsTabLayout, saveAndStatTabLayout;
    ViewPager vp, vp1;
    View customFragment;
    public static int odd = 0;
    EditText name, race, hptext, actext, initext, speedtext, xptext;

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
        iniView(view);
        checkLength(name);
        checkLength(race);
        //checkLength(lvl);
        view.findViewById(R.id.saveCharBtn).setOnClickListener(view1 -> {
            Character character = new Character();
            character.setName(name.getText().toString());
            if (name.length() == 0 || race.length() == 0 /*|| lvl.length() == 0*/) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("arg1", character.getName());
            bundle.putString("arg2", character.getRace());
            bundle.putInt("arg3", character.getLvl());
            //navController.navigate(R.id.go_to_chooseCharacter, bundle);
        });

        view.findViewById(R.id.redCharBtn).setOnClickListener(view2 ->{
            odd = odd+1;
            redaction(odd % 2 == 0);
        });
    }

    public void redaction(boolean bool){
        name.setEnabled(bool);
        //lvl.setEnabled(bool);
        race.setEnabled(bool);
        hptext.setEnabled(bool);
        actext.setEnabled(bool);
        initext.setEnabled(bool);
        speedtext.setEnabled(bool);
        xptext.setEnabled(bool);
        charsAndModsTabLayout.setEnabled(bool);
        saveAndStatTabLayout.setEnabled(bool);
    }

    public void iniView(View view){
        name = view.findViewById(R.id.charNameView);
        race = view.findViewById(R.id.charRaceView);

    }

    public void checkLength(EditText et){
        et.setOnFocusChangeListener((v, hasFocus) -> {
            if (v == et && !hasFocus && et.length()==0) {
                et.setError("Пустая строка");
            }
        });
    }
}
