package com.example.vrungel.itea_2018_base.main;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import butterknife.BindView;
import com.example.vrungel.itea_2018_base.Country;
import com.example.vrungel.itea_2018_base.CustomAdapter;
import com.example.vrungel.itea_2018_base.MyCustomEvent;
import com.example.vrungel.itea_2018_base.R;
import com.example.vrungel.itea_2018_base.TestDialogFragment;
import com.example.vrungel.itea_2018_base.base.BaseActivity;
import com.example.vrungel.itea_2018_base.utils.ItemClickSupport;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements IMainActivityView {
  private static final String APP_PREFERENCES = "APP_PREFERENCES";
  @BindView(R.id.rv) RecyclerView mRecyclerView;
  @BindView(R.id.srl) SwipeRefreshLayout mSwipeRefreshLayout;
  private List<Country> mCountries = new ArrayList<>();
  private MainActivityPresenter mPresenter;
  private IMainActivityView mIMainActivityView = new IMainActivityView() {
    @Override public void showMocks(List<Country> countries) {

    }

    @Override public void showText(String string) {

    }
  };

  private CustomAdapter mAdapter;
  private CustomRVAdapter mCustomRVAdapter;
  private int finalCounter;
  private TestDialogFragment mTestDialogFragment;
  private MyAsyncTask mMyAsyncTask;
  private Bus bus = new Bus();

  @Override public void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_main);
    super.onCreate(savedInstanceState);
    mPresenter = new MainActivityPresenter();
    bus.register(this);
    bus.post(new MyCustomEvent());

    //mPresenter.bind(new IMainActivityView() {
    //  @Override public void showMocks(List<Country> countries) {
    //    mCustomRVAdapter.setCountries(countries);
    //  }
    //});

    mPresenter.bind(this);
    //mPresenter.bind(mIMainActivityView);
    mCustomRVAdapter = new CustomRVAdapter();
    mRecyclerView.setLayoutManager(
        new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

    mRecyclerView.setAdapter(mCustomRVAdapter);

    mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh() {
        Toast.makeText(MainActivity.this, "onRefresh", Toast.LENGTH_SHORT).show();
        mPresenter.fetchMocks();
      }
    });

    mPresenter.fetchMocks();

    ItemClickSupport.addTo(mRecyclerView)
        .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
          @Override public void onItemClicked(RecyclerView recyclerView, int position, View v) {
            Toast.makeText(MainActivity.this, "onItemClicked " + position, Toast.LENGTH_SHORT)
                .show();

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            TestDialogFragment.newInstance(null).show(ft, "TestDialogFragment");
          }
        });

    mMyAsyncTask = (MyAsyncTask) getLastCustomNonConfigurationInstance();
    if (mMyAsyncTask == null) {
      mMyAsyncTask = new MyAsyncTask();
      mMyAsyncTask.execute("Stroka0");
    }
    // передаем в MyTask ссылку на текущее MainActivity
    mMyAsyncTask.link(this);
  }

  @Subscribe
  public void onEvent(MyCustomEvent s) {
    Log.wtf("MainActivity", String.valueOf(s.hashCode()));
  }

  public Object onRetainCustomNonConfigurationInstance() {
    // удаляем из MyTask ссылку на старое MainActivity
    mMyAsyncTask.unLink();
    return mMyAsyncTask;
  }

  @Override public void showMocks(List<Country> countries) {
    mCustomRVAdapter.setCountries(countries);
    mSwipeRefreshLayout.setRefreshing(false);
  }

  @Override public void showText(String string) {
    //nothing
  }

  static class MyAsyncTask extends AsyncTask<String, String, String> {
    WeakReference<MainActivity> activity;

    // получаем ссылку на MainActivity
    void link(MainActivity act) {
      activity = new WeakReference<>(act);
    }

    // обнуляем ссылку
    void unLink() {
      activity.clear();
    }

    @Override protected void onPreExecute() {
      super.onPreExecute();
      Log.wtf("MyAsyncTask", "onPreExecute");
    }

    @Override protected String doInBackground(String... strings) {
      Log.wtf("MyAsyncTask", "doInBackground " + strings[0]);
      publishProgress("\nStroka1", "\nStroka2");
      return "Result String";
    }

    @Override protected void onProgressUpdate(String... values) {
      super.onProgressUpdate(values);
      Toast.makeText(activity.get().getApplicationContext(),
          "onProgressUpdate " + values[0] + values[1], Toast.LENGTH_SHORT).show();
      Log.wtf("MyAsyncTask", "onProgressUpdate " + values[0] + values[1]);
    }

    @Override protected void onPostExecute(String result) {
      super.onPostExecute(result);
      Toast.makeText(activity.get().getApplicationContext(), "onPostExecute " + result,
          Toast.LENGTH_SHORT).show();
      Log.wtf("MyAsyncTask", "onPostExecute " + result);
    }
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    mPresenter.unBind();
    bus.unregister(this);
    //mTestDialogFragment.removeListeners();
  }

  //@OnClick(R.id.b1)
  //public void bClick(View v){
  //
  //}
  //
  //@OnTextChanged(value = R.id.et_search, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
  //public void filterText(Editable s) {
  //  mPresenter.filterByName(friendsAdapter.getAllList(), s.toString());
  //}
}
