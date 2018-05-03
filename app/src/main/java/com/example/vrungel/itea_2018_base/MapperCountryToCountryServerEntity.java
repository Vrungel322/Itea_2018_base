package com.example.vrungel.itea_2018_base;

public class MapperCountryToCountryServerEntity implements Mapper<Country, CountryServerEntity> {

  private final String userId;

  public MapperCountryToCountryServerEntity(String userId) {
    this.userId = userId;
  }

  @Override public CountryServerEntity transform(Country a) {
    return new CountryServerEntity(
        a.getCountryName(),
        a.getCapitalName(),
        a.getFlagId(),
        userId);
  }
}
