package com.example.vrungel.itea_2018_base;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import butterknife.BindView;
import com.example.vrungel.itea_2018_base.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
  @BindView(R.id.lv) ListView mListView;
  private List<Country> mCountries = new ArrayList<>();

  private CustomAdapter mAdapter;

  @Override public void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_main);
    super.onCreate(savedInstanceState);

   mCountries = mDataManager.fetchMocks();
    mAdapter = new CustomAdapter(getApplicationContext(), R.layout.item_layout_custom, mCountries);
    mListView.setAdapter(mAdapter);
    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("https://ru.wikipedia.org/wiki/" + mAdapter.getCountries().get(i));
        intent.setData(uri);
        startActivity(intent);
      }
    });

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
