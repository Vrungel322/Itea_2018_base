package com.example.vrungel.itea_2018_base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.example.vrungel.itea_2018_base.data.DataManager;

/**
 * Created by vrungel on 08.03.2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ButterKnife.bind(this);
  }
}
