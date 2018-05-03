package com.example.vrungel.itea_2018_base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class CountryServerEntity {
  private @Getter @Setter String countryName;
  private @Getter @Setter String capitalName;
  private @Getter @Setter int flagId;
  private @Getter @Setter String token;
}
