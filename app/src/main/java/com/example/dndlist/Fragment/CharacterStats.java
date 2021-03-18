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
import com.example.dndlist.repository.DbUtil;
import com.example.dndlist.utils.FragmentAdaptor.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textview.MaterialTextView;


public class CharacterStats extends Fragment {
    private final static String TAG = "CreateCharacter";
    TabLayout charsAndModsTabLayout, saveAndStatTabLayout;
    ViewPager vpCharacteristicsAndMods, vpThrowsAndStats;
    MaterialTextView name, race;
    Character character;
    NavController navController;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_character_stats, container, false);

        vpCharacteristicsAndMods = view.findViewById(R.id.vpCharacteristicsAndMods);
        vpThrowsAndStats = view.findViewById(R.id.vpThrowsAndStats);
        charsAndModsTabLayout = view.findViewById(R.id.charsAndMods);
        saveAndStatTabLayout = view.findViewById(R.id.saveAndStat);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpCharacteristicsAndMods(vpCharacteristicsAndMods);
        setUpThrowsAndStats(vpThrowsAndStats);
        charsAndModsTabLayout.setupWithViewPager(vpCharacteristicsAndMods);
        saveAndStatTabLayout.setupWithViewPager(vpThrowsAndStats);
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

    private void setUpCharacteristicsAndMods(ViewPager vp) {
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager());
        fragmentAdapter.addFragment(new CharactersCharList(), "Характеристики");
        fragmentAdapter.addFragment(new ModificatorsCharList(), "Модификаторы");
        vp.setAdapter(fragmentAdapter);
    }

    private void setUpThrowsAndStats(ViewPager vp1) {
        FragmentAdapter adaptor = new FragmentAdapter(getChildFragmentManager());
        adaptor.addFragment(new SaveDropsCharList(), "Спасброски");
        adaptor.addFragment(new ExtraStatsCharList(), "Доп Статы");
        vp1.setAdapter(adaptor);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DbUtil.init(getContext());
        getActivity().findViewById(R.id.bottom_navigation).setVisibility(View.VISIBLE);
        navController = Navigation.findNavController(view);
        name = view.findViewById(R.id.tvCharacterNameStatsFragment);
        race = view.findViewById(R.id.tvCharacterRaceStatsFragment);
        character = DbUtil.getCurrentCharacter();
        name.setText(character.getName());
        race.setText(character.getRace());
    }



    public void checkLength(EditText et){
        et.setOnFocusChangeListener((v, hasFocus) -> {
            if (v == et && !hasFocus && et.length()==0) {
                et.setError("Пустая строка");
            }
        });
    }
}
