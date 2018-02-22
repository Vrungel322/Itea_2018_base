package com.example.vrungel.itea_2018_base;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vrungel on 22.02.2018.
 */

public class Person implements Parcelable {
  private String name;
  private String LastName;

  public Person() {
  }

  protected Person(Parcel in) {
    name = in.readString();
    LastName = in.readString();
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(name);
    dest.writeString(LastName);
  }

  @Override public int describeContents() {
    return 0;
  }

  public static final Creator<Person> CREATOR = new Creator<Person>() {
    @Override public Person createFromParcel(Parcel in) {
      return new Person(in);
    }

    @Override public Person[] newArray(int size) {
      return new Person[size];
    }
  };
}
