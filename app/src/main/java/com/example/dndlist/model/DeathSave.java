package com.example.dndlist.model;

import androidx.room.PrimaryKey;
import lombok.Data;
import androidx.room.Entity;

@Data
@Entity
public class DeathSave implements IEntity {
  @PrimaryKey
  private long id;
  private int successes;
  private int failures;
  private int maxValue;
}
