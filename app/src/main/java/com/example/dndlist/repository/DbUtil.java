package com.example.dndlist.repository;

import android.content.Context;

import com.example.dndlist.utils.MainDB;


public class DbUtil {

    private static MainDB INSTANCE;

    public static MainDB getInstance() {
        return INSTANCE;
    }


    public static void init(Context context) {
        INSTANCE = MainDB.get(context);
    }
}
