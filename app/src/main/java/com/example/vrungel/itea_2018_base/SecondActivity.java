package com.example.vrungel.itea_2018_base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by vrungel on 22.02.2018.
 */

public class SecondActivity extends AppCompatActivity {
  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.second_activity);

    TextView tvText = findViewById(R.id.tvText);
    tvText.setText(getIntent().getExtras().getBundle("key_bundle").getString("key_str", "def val"));
    int i = getIntent().getExtras().getBundle("key_bundle").getInt("key_str_int", 0);
    tvText.setText(tvText.getText().toString() + i);
    Person person = getIntent().getExtras().getBundle("key_bundle").getParcelable("person");
  }
}
