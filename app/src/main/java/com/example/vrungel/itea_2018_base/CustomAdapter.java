package com.example.vrungel.itea_2018_base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrungel on 01.03.2018.
 */

public class CustomAdapter extends ArrayAdapter<Country> {
  private Context context;
  private List<Country> countries = new ArrayList<>();

  public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Country> objects) {
    super(context, resource, objects);
    this.context = context;
    this.countries = objects;
  }

  public List<Country> getCountries() {
    return countries;
  }

  @NonNull @Override
  public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View rootView = null;
    if (convertView == null) {
      Log.wtf("getView", "temp " + position);
      LayoutInflater inflater =
          (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      rootView = inflater.inflate(R.layout.item_layout_custom, parent, false);
    } else {
      rootView = convertView;
    }

    ImageView ivFlag = (ImageView) rootView.findViewById(R.id.ivFlag);
    ivFlag.setImageResource(countries.get(position).getFlagId());

    TextView tvCountryName = (TextView) rootView.findViewById(R.id.tvCountry);
    tvCountryName.setText(countries.get(position).getCountryName());

    return rootView;
  }
}
