package com.example.dndlist.model;

import androidx.room.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@Entity
public class LimitedPoint extends Characteristic {
  private int minValue;
  private int maxValue;
}
