package com.example.vrungel.itea_2018_base;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import butterknife.BindView;
import com.example.vrungel.itea_2018_base.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
  private static final String APP_PREFERENCES = "APP_PREFERENCES";
  @BindView(R.id.rv) RecyclerView mRecyclerView;
  @BindView(R.id.srl) SwipeRefreshLayout mSwipeRefreshLayout;
  private List<Country> mCountries = new ArrayList<>();

  private CustomAdapter mAdapter;
  private CustomRVAdapter mCustomRVAdapter;
  private int finalCounter;
  private TestDialogFragment mTestDialogFragment;

  @Override public void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_main);
    super.onCreate(savedInstanceState);
    //mCustomRVAdapter = new CustomRVAdapter();
    //mRecyclerView.setLayoutManager(
    //    new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    //mRecyclerView.setLayoutManager(
    //    new GridLayoutManager(getApplicationContext(),3));
    //mRecyclerView.setAdapter(mCustomRVAdapter);

    //mCustomRVAdapter.setCountries(mDataManager.fetchMocks());

    //mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
    //  @Override public void onRefresh() {
    //    Toast.makeText(MainActivity.this, "onRefresh", Toast.LENGTH_SHORT).show();
    //    mSwipeRefreshLayout.setRefreshing(false);
    //  }
    //});
    //
    //ItemClickSupport.addTo(mRecyclerView)
    //    .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
    //      @Override public void onItemClicked(RecyclerView recyclerView, int position, View v) {
    //        Toast.makeText(MainActivity.this, "onItemClicked " + position, Toast.LENGTH_SHORT)
    //            .show();
    //
    //
    //        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    //        TestDialogFragment.newInstance(null).show(ft, "TestDialogFragment");
    //      }
    //    });
    //
    //getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE).edit()
    //    .putString("t", "temp")
    //    .apply();
    //
    //getPreferences(Context.MODE_PRIVATE).edit()
    //    .putString("t", "temp")
    //    .apply();

    //mCountries = mDataManager.fetchMocks();
    //mAdapter = new CustomAdapter(getApplicationContext(), R.layout.item_layout_custom, mCountries);
    //mListView.setAdapter(mAdapter);
    //mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    //  @Override public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    //    //Intent intent = new Intent(Intent.ACTION_VIEW);
    //    //Uri uri = Uri.parse("https://ru.wikipedia.org/wiki/" + mAdapter.getCountries().get(i));
    //    //intent.setData(uri);
    //    //startActivity(intent);
    //
    //    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
    //    builder.setTitle("Title")
    //        .setIcon(R.drawable.ic_launcher_background)
    //        .setMessage("Body of test Alert Dialog. Close dialog?")
    //        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
    //          @Override public void onClick(DialogInterface dialogInterface, int i) {
    //            Toast.makeText(MainActivity.this, "Positive Btn", Toast.LENGTH_SHORT).show();
    //          }
    //        })
    //        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
    //          @Override public void onClick(DialogInterface dialogInterface, int i) {
    //            Toast.makeText(MainActivity.this, "Negative Btn", Toast.LENGTH_SHORT).show();
    //          }
    //        })
    //        .setNeutralButton("Not now", new DialogInterface.OnClickListener() {
    //          @Override public void onClick(DialogInterface dialogInterface, int i) {
    //            Toast.makeText(MainActivity.this, "Neutral Btn", Toast.LENGTH_SHORT).show();
    //          }
    //        })
    //        .setCancelable(false)
    //        .create()
    //        .show();
    //  }
    //});

    //EditText t=new EditText();
    //t.addTextChangedListener(new TextWatcher() {
    //  @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    //
    //  }
    //
    //  @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    //
    //  }
    //
    //  @Override public void afterTextChanged(Editable editable) {
    //
    //  }
    //});

    //Runnable action = new Runnable() {
    //  @Override public void run() {
    //
    //  }
    //};
    //mRecyclerView.post(action);
    ////mRecyclerView.removeCallbacks(action);
    //
    //Runnable runnable = new Runnable() {
    //  @Override public void run() {
    //    while (finalCounter <= 10) {
    //      //runOnUiThread(new Runnable() {
    //      //  @Override public void run() {
    //      //    tv.setText("" + finalCounter++);
    //      //  }
    //      //});
    //      try {
    //        Thread.sleep(500);
    //      } catch (InterruptedException e) {
    //        e.printStackTrace();
    //      }
    //    }
    //  }
    //};
    //Thread thread = new Thread(runnable);
    //thread.start();

    //mTestDialogFragment = TestDialogFragment.newInstance(null);
    //mTestDialogFragment.setOnSomeItemClickListener(new CustomListener() {
    //  @Override public void doAction() {
    //    Toast.makeText(getApplicationContext(), "ButtonClicked", Toast.LENGTH_SHORT).show();
    //  }
    //});
    //FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    //mTestDialogFragment.show(ft, "TestDialogFragment");

    MyAsyncTask myAsyncTask = new MyAsyncTask();
    myAsyncTask.execute("Stroka0");
  }

  class MyAsyncTask extends AsyncTask<String, String, String> {
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
      Toast.makeText(getApplicationContext(), "onProgressUpdate " + values[0] + values[1],
          Toast.LENGTH_SHORT).show();
      Log.wtf("MyAsyncTask", "onProgressUpdate " + values[0] + values[1]);
    }

    @Override protected void onPostExecute(String result) {
      super.onPostExecute(result);
      Toast.makeText(getApplicationContext(), "onPostExecute " + result, Toast.LENGTH_SHORT).show();
      Log.wtf("MyAsyncTask", "onPostExecute " + result);
    }
  }

  @Override protected void onDestroy() {
    super.onDestroy();
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
