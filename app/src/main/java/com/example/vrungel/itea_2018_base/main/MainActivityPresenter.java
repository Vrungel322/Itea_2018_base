package com.example.vrungel.itea_2018_base.main;

import android.util.Log;
import com.example.vrungel.itea_2018_base.base.BasePresenter;

public class MainActivityPresenter extends BasePresenter<IMainActivityView>
    implements IMainActivityPesenter {

  @Override public void fetchMocks() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    getV().showMocks(mDataManager.fetchMocks());
    Log.wtf("TAG", String.valueOf(mDataManager.fetchMocks().size()));
  }
}
