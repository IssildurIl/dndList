package com.example.dndlist.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.dndlist.model.enums.AttackForm;
import com.example.dndlist.model.enums.DamageType;

import java.util.Set;

import lombok.Data;


@Data
@Entity
public class Action implements NamedEntity {
  @PrimaryKey
  private long id;
  private String name;
  private Dice damage;
  private double range;
  private Set<Item> ammo;
  private DamageType damageType;
  private String description;
  private AttackForm attackForm;
}
