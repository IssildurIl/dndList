package com.example.dndlist.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.dndlist.model.enums.EquipStatus;
import com.example.dndlist.model.enums.ItemType;

import lombok.Data;


@Data
@Entity
public class Item implements NamedEntity {
  @PrimaryKey
  private long id;
  private String name;
  private String description;
  private int cost;
  private double weight;
  private ItemType type;
  private EquipStatus equipStatus;
  private int amount;
}
