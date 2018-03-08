package com.example.vrungel.itea_2018_base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by vrungel on 01.03.2018.
 */
@ToString @AllArgsConstructor @NoArgsConstructor
public class Country {
  private @Getter @Setter String countryName;
  private @Getter @Setter String capitalName;
  private @Getter @Setter int flagId;
}
