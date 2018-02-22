package com.example.vrungel.itea_2018_base;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button bStartNextActivity = findViewById(R.id.bStartNextActivity);
    bStartNextActivity.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {

        //Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        //Bundle bundle = new Bundle();
        //bundle.putString("key_str", "Activity 2!!!");
        //bundle.putInt("key_str_int", 11111);
        //bundle.putParcelable("person", new Person());
        //intent.putExtra("key_bundle",bundle);

        Intent intent = new Intent();
        //intent.setAction(AlarmClock.ACTION_SET_ALARM);
        //intent.putExtra(AlarmClock.EXTRA_MESSAGE, "My Message");
        //intent.putExtra(AlarmClock.EXTRA_HOUR, 21);
        //intent.putExtra(AlarmClock.EXTRA_MINUTES, 15);

        //Calendar cal = Calendar.getInstance();
        //intent.setAction(Intent.ACTION_EDIT);
        //intent.setData(CalendarContract.Events.CONTENT_URI);
        //intent.setType("vnd.android.cursor.item/event");
        //intent.putExtra(CalendarContract.Events.TITLE, "A Test Event");
        //intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, cal.getTimeInMillis());
        //intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
        //    cal.getTimeInMillis() + 60 * 60 * 1000);
        //intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
        //intent.putExtra(CalendarContract.Events.RRULE, "FREQ=YEARLY");

        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
      }
    });
  }
}
