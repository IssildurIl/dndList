package com.example.dndlist.model;

import androidx.room.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@Entity
public class Skill extends Characteristic{
  private boolean isActive;
}
