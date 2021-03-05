package com.example.dndlist.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.dndlist.utils.RecycleView.ExampleItem;

import java.util.Set;

import lombok.Data;

@Data
@Entity
public class Character implements NamedEntity, Parcelable {
  @PrimaryKey
  private long id;
  private String name;
  private String charClass;
  private int lvl;
  private Set<Characteristic> characteristicsList;
  private DeathSave deathSave;
  private Dice hitDice;
  private Set<Item> inventory;
  private Set<Action> actions;
  private String race;
  private String alignment;
  private String personalTraits;
  private String ideals;
  private String bonds;
  private String flaws;


  public Character() { }

  public Character(String name, String race, int lvl) {
    this.name= name;
    this.race = race;
    this.lvl = lvl;
  }

  protected Character(Parcel in) {
    name = in.readString();
    race = in.readString();
    lvl = Integer.parseInt(in.readString());
  }

  public static final Parcelable.Creator<Character> CREATOR = new Parcelable.Creator<Character>() {
    @Override
    public Character createFromParcel(Parcel in) {
      return new Character(in);
    }
    @Override
    public Character[] newArray(int size) {
      return new Character[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }


  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(name);
    dest.writeString(race);
    dest.writeString(String.valueOf(lvl));
  }

}
