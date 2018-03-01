package com.example.vrungel.itea_2018_base;

/**
 * Created by vrungel on 01.03.2018.
 */

public class Country {
  private String countryName;
  private String capitalName;
  private int flagId;

  public Country(String countryName, String capitalName, int flagId) {
    this.countryName = countryName;
    this.capitalName = capitalName;
    this.flagId = flagId;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public String getCapitalName() {
    return capitalName;
  }

  public void setCapitalName(String capitalName) {
    this.capitalName = capitalName;
  }

  public int getFlagId() {
    return flagId;
  }

  public void setFlagId(int flagId) {
    this.flagId = flagId;
  }
}
