package com.example.dndlist.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dndlist.model.User;

@Dao
public interface UserDao {
    @Query("DELETE FROM user")
    void deleteUser();

    @Query("SELECT * from user")
    User getUser();

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

    @Update
    void update(User user);
}
