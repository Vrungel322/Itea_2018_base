package com.example.vrungel.itea_2018_base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;

/**
 * Created by vrungel on 08.03.2018.
 */

public abstract class BaseActivity extends MvpAppCompatActivity {

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ButterKnife.bind(this);
  }
}
