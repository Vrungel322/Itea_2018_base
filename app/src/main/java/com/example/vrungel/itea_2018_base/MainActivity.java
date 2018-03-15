package com.example.vrungel.itea_2018_base;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import butterknife.BindView;
import com.example.vrungel.itea_2018_base.base.BaseActivity;
import com.example.vrungel.itea_2018_base.utils.ItemClickSupport;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
  @BindView(R.id.rv) RecyclerView mRecyclerView;
  @BindView(R.id.srl) SwipeRefreshLayout mSwipeRefreshLayout;
  private List<Country> mCountries = new ArrayList<>();

  private CustomAdapter mAdapter;
  private CustomRVAdapter mCustomRVAdapter;

  @Override public void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_main);
    super.onCreate(savedInstanceState);
    mCustomRVAdapter = new CustomRVAdapter();
    mRecyclerView.setLayoutManager(
        new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    //mRecyclerView.setLayoutManager(
    //    new GridLayoutManager(getApplicationContext(),3));
    mRecyclerView.setAdapter(mCustomRVAdapter);

    mCustomRVAdapter.setCountries(mDataManager.fetchMocks());

    mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh() {
        Toast.makeText(MainActivity.this, "onRefresh", Toast.LENGTH_SHORT).show();
        mSwipeRefreshLayout.setRefreshing(false);
      }
    });

    ItemClickSupport.addTo(mRecyclerView)
        .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
          @Override public void onItemClicked(RecyclerView recyclerView, int position, View v) {
            Toast.makeText(MainActivity.this, "onItemClicked " + position, Toast.LENGTH_SHORT).show();
          }
        }).setOnItemClickListener();

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
