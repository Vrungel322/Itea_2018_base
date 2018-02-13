package com.example.vrungel.itea_2018_base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button bLogin = (Button) findViewById(R.id.bLogin);
    final TextView tvLoginResult = (TextView) findViewById(R.id.tvLoginResult);
    bLogin.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Log.wtf("TAG", "onClick");
        Toast.makeText(MainActivity.this, "TEST TEXT",Toast.LENGTH_SHORT).show();
        tvLoginResult.setText("TEST TEXT");
      }
    });
  }
}
