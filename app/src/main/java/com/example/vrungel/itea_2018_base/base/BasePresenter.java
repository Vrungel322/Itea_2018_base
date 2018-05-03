package com.example.vrungel.itea_2018_base.base;

import com.arellomobile.mvp.MvpPresenter;
import com.example.vrungel.itea_2018_base.data.DataManager;

abstract public class BasePresenter<V extends IView> extends MvpPresenter<V> {
  //@Nullable @Getter private V v;
  protected DataManager mDataManager = new DataManager();

  //public void bind(V v) {
  //  this.v = v;
  //}

  //public void unBind() {
  //  this.v = null;
  //}
}
