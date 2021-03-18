package com.example.dndlist.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dndlist.model.Character;

import java.util.List;

@Dao
public interface CharacterDao {

    @Query("SELECT * from Character")
    List<Character> getCharacter();

    @Query("SELECT * from Character WHERE id= :id")
    Character getCharacter(long id);

    @Insert
    long insert(Character character);

    @Delete
    void delete(Character character);

    @Update
    void update(Character character);
}
