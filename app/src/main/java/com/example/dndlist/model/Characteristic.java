package com.example.dndlist.model;

import lombok.Data;
import androidx.room.PrimaryKey;
import lombok.Data;
import androidx.room.Entity;

import com.example.dndlist.model.enums.CharacteristicType;


@Data
@Entity
public class Characteristic implements NamedEntity {
  @PrimaryKey
  private long id;
  private String name;
  private CharacteristicType characteristicType;
  private int amount;
}
