package com.example.vrungel.itea_2018_base.main;

import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.example.vrungel.itea_2018_base.base.BasePresenter;

@InjectViewState
public class MainActivityPresenter extends BasePresenter<IMainActivityView>
    implements IMainActivityPesenter {

  public MainActivityPresenter(String str) {
    super();
    Log.wtf("TAG", str);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    fetchMocks();
  }

  @Override public void fetchMocks() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    getViewState().showMocks(mDataManager.fetchMocks());
    Log.wtf("TAG", String.valueOf(mDataManager.fetchMocks().size()));
  }
   //public void sendCountries(){
   // mDataManager.send(mDataManager.fetchMocks());
   //}

  @Override public void onDestroy() {
    super.onDestroy();
  }
}


