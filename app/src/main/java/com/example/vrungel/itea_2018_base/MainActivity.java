package com.example.vrungel.itea_2018_base;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private ListView mListView;
  private List<Country> mCountries = new ArrayList<>();
  static String countryNames[] = {
      "Швеция", "Япония", "Польша", "Украина", "Португалия", "Великобритания", "Греция", "Чехия",
      "Швейцария", "Испания"
  };
  static String capitalNames[] = {
      "Стокгольм", "Токио", "Варшава", "Киев", "Лассабон", "Лондон", "Афины", "Прага", "Берн",
      "Мадрид"
  };
  static int flags[] = {
      R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
      R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
      R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
      R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
      R.drawable.ic_launcher_background
  };
  private CustomAdapter mAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    for (int i = 0; i < 9; i++) {
      mCountries.add(new Country(countryNames[i], capitalNames[i], flags[i]));
    }

    mListView = findViewById(R.id.lv);
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
  }
}
