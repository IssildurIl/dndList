package com.example.dndlist.utils;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.dndlist.dao.CharacterDao;
import com.example.dndlist.dao.UserDao;
import com.example.dndlist.model.Character;
import com.example.dndlist.model.User;

@Database(entities = {User.class, Character.class}, version = 3)
public abstract class MainDB extends RoomDatabase {

    private static final String DB_NAME = "events.db";
    private static volatile MainDB INSTANCE = null;

    public synchronized static MainDB get(Context context) {
        if (INSTANCE == null) {
            INSTANCE = create(context, false);
        }
        return (INSTANCE);
    }

    private static MainDB create(Context context, boolean memoryOnly) {
        Builder<MainDB> builder;
        if (memoryOnly) {
            builder = Room.inMemoryDatabaseBuilder(context.getApplicationContext(),
                    MainDB.class);
        } else {
            builder = Room.databaseBuilder(context.getApplicationContext(), MainDB.class,
                    DB_NAME)
                    .fallbackToDestructiveMigration();
        }
        return (builder.build());
    }

    public abstract UserDao userDAO();

    public abstract CharacterDao characterDao();

}
