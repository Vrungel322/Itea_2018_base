package com.example.vrungel.itea_2018_base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.ButterKnife;

/**
 * Created by vrungel on 22.03.2018.
 */

public class TestDialogFragment extends DialogFragment {

  private CustomListener listener;

  public TestDialogFragment() {
    // Required empty public constructor
  }

  public static TestDialogFragment newInstance(Bundle bundle) {
    Log.e("dialog", "newInstance");
    TestDialogFragment testDialogFragment = new TestDialogFragment();
    testDialogFragment.setArguments(bundle);
    return testDialogFragment;
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    Log.e("dialog", "onAttach");
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle bundle = getArguments();
    Log.e("dialog", "onCreate");
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    Log.e("dialog", "onCreateView");
    View view = inflater.inflate(R.layout.fragment_test_dialog, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    Log.e("dialog", "onViewCreated");

    Button etTextText = (Button) view.findViewById(R.id.bTest);
    etTextText.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        listener.doAction();
      }
    });
  }

  @Override public void onStart() {
    super.onStart();
    Log.e("dialog", "onStart");
  }

  @Override public void onResume() {
    super.onResume();
    Log.e("dialog", "onResume");
  }

  @Override public void onPause() {
    super.onPause();
    Log.e("dialog", "onPause");
  }

  @Override public void onStop() {
    super.onStop();
    Log.e("dialog", "onStop");
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    Log.e("dialog", "onDestroyView");
  }

  @Override public void onDestroy() {
    super.onDestroy();
    Log.e("dialog", "onDestroy");
  }

  @Override public void onDetach() {
    super.onDetach();
    Log.e("dialog", "onDetach");
  }

  public void setOnSomeItemClickListener(CustomListener listener) {
    this.listener = listener;
  }
  public void removeListeners(){
    this.listener = null;
  }
}
