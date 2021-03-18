package com.example.dndlist.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import lombok.Data;

@Data
@Entity
public class User implements NamedEntity, Serializable {
  @PrimaryKey(autoGenerate = true)
  private long id;
  private String name;
  private String email;
  private String password;
}
