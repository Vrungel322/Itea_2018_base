package com.example.vrungel.itea_2018_base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.wtf("Tag", "onCreate");

    findViewById(R.id.tvNewActivity).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(), SecondActivity.class));
        finish();
      }
    });
  }

  @Override protected void onStart() {
    super.onStart();
    Log.wtf("Tag", "onStart");
  }

  @Override protected void onResume() {
    super.onResume();
    Log.wtf("Tag", "onResume");
  }

  @Override protected void onPause() {
    super.onPause();
    Log.wtf("Tag", "onPause");
  }

  @Override protected void onStop() {
    super.onStop();
    Log.wtf("Tag", "onStop");
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    Log.wtf("Tag", "onDestroy");
  }

  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    Log.wtf("Tag", "onSaveInstanceState");
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    Log.wtf("Tag", "onRestoreInstanceState");
  }
}
