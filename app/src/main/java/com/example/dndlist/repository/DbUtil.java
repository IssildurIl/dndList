package com.example.dndlist.repository;

import android.content.Context;

import com.example.dndlist.model.Character;
import com.example.dndlist.utils.MainDB;


public class DbUtil {

    private static MainDB INSTANCE;
    private static Character currentCharacter;

    public static MainDB getInstance() {
        return INSTANCE;
    }

    public static Character getCurrentCharacter() {
        return currentCharacter;
    }

    public static void setCurrentCharacter(Character currentCharacter) {
        DbUtil.currentCharacter = currentCharacter;
    }

    public static void init(Context context) {
        INSTANCE = MainDB.get(context);
    }
}
