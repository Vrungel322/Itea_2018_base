package com.example.vrungel.itea_2018_base.data;

import com.example.vrungel.itea_2018_base.Country;
import java.util.List;

/**
 * Created by vrungel on 08.03.2018.
 */

public class DataManager {
  private RepositoryMockCountries mRepositoryMockCountries;

  public DataManager() {
    mRepositoryMockCountries = new RepositoryMockCountries();
  }

  public List<Country> fetchMocks() {
    return mRepositoryMockCountries.fetchMocks();
  }

  //public void send(List<Country> countries) {
  //  List<CountryServerEntity> serverEntities = new ArrayList<CountryServerEntity>();
  //  for (Country c : countries) {
  //    serverEntities.add(
  //        new MapperCountryToCountryServerEntity("userId").transform(c)
  //    );
  //  }
  //  restApi.send(serverEntities);
  //}
}
