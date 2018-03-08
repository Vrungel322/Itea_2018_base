package com.example.vrungel.itea_2018_base.data;

import com.example.vrungel.itea_2018_base.Country;
import com.example.vrungel.itea_2018_base.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrungel on 08.03.2018.
 */

public class RepositoryMockCountries implements IRepositoryMock<Country> {

  @Override public List<Country> fetchMocks() {
    List<Country> contries = new ArrayList<>();
    String countryNames[] = {
        "Швеция", "Япония", "Польша", "Украина", "Португалия", "Великобритания", "Греция", "Чехия",
        "Швейцария", "Испания"
    };
    String capitalNames[] = {
        "Стокгольм", "Токио", "Варшава", "Киев", "Лассабон", "Лондон", "Афины", "Прага", "Берн",
        "Мадрид"
    };
    int flags[] = {
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background
    };
    for (int i = 0; i < 9; i++) {
      contries.add(new Country(countryNames[i], capitalNames[i], flags[i]));
    }
    return contries;
  }
}
