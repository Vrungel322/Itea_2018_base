package com.example.vrungel.itea_2018_base.main;

import com.example.vrungel.itea_2018_base.Country;
import com.example.vrungel.itea_2018_base.base.IView;
import java.util.List;

public interface IMainActivityView extends IView {
  void showMocks(List<Country> countries);
}
