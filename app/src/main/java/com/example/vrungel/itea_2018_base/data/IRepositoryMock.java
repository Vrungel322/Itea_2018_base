package com.example.vrungel.itea_2018_base.data;

import java.util.List;

/**
 * Created by vrungel on 08.03.2018.
 */

public interface IRepositoryMock<T> {
  List<T> fetchMocks();
}
