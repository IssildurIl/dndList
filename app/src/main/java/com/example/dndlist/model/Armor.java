package com.example.dndlist.model;

import androidx.room.Entity;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Entity
public class Armor extends Item {
  private Set<Characteristic> characteristics;
  private Set<Characteristic> requirements;
}
