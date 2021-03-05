package com.example.dndlist.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.dndlist.model.enums.DiceType;

import lombok.Data;


@Data
@Entity
public class Dice implements IEntity {
  @PrimaryKey
  private long id;
  private DiceType diceType;
  private int count;
  private int bonus;
}
