package com.example.vrungel.itea_2018_base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TableRow;
import android.widget.TextView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by vrungel on 20.02.2018.
 */

public class CustomUserInfoView extends TableRow {
  public ImageView ivPhoto;
  public TextView tvName;
  public TextView tvCountry;
  public RatingBar rbRating;

  public CustomUserInfoView(Context context) {
    super(context);
  }

  public CustomUserInfoView(Context context, AttributeSet attrs) {
    super(context, attrs);
    LayoutInflater inflater = (LayoutInflater) context.
        getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    TableRow trRoot = (TableRow) inflater.
        inflate(R.layout.custom_user_info_layout, this, true);


    ivPhoto = (ImageView) trRoot.findViewById(R.id.ivPhoto);
    tvName = (TextView) trRoot.findViewById(R.id.tvName);
    tvName.setText("Петро Петренко");
    tvCountry = (TextView) trRoot.findViewById(R.id.tvCountry);
    tvCountry.setText("Ukraine");
    rbRating = (RatingBar) trRoot.findViewById(R.id.rbRating);
    rbRating.setRating(3.7f);


    Picasso.with(context)
        .load(
            "http://sweetpanda.ru/wp-content/uploads/2017/02/stalo-izvestno-kogda-v-moskve-pojavjatsja-bolshie-pandy-sweetpanda.ru-001.jpg")
        .placeholder(R.drawable.ic_launcher_background)
        .into(ivPhoto, new Callback() {
          @Override public void onSuccess() {

          }

          @Override public void onError() {

          }
        });
  }
}