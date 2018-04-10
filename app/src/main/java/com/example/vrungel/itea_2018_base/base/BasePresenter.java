package com.example.vrungel.itea_2018_base.base;

import android.support.annotation.Nullable;
import com.example.vrungel.itea_2018_base.data.DataManager;
import lombok.Getter;

abstract public class BasePresenter<V extends IView> {
  @Nullable @Getter private V v;
  protected DataManager mDataManager = new DataManager();

  public void bind(V v) {
    this.v = v;
  }

  public void unBind() {
    this.v = null;
  }
}
