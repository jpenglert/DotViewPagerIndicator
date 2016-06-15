package com.jenglert.dotviewpagerindicator.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewPagerFragment extends Fragment {

  private static final String ARG_TITLE = "title";

  private String mTitle;

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param title Parameter 1.
   * @return A new instance of fragment Slide1Fragment.
   */
  public static ViewPagerFragment newInstance(String title) {
    ViewPagerFragment fragment = new ViewPagerFragment();

    Bundle args = new Bundle();
    args.putString(ARG_TITLE, title);
    fragment.setArguments(args);

    return fragment;
  }

  public ViewPagerFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mTitle = getArguments().getString(ARG_TITLE);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_viewpager, container, false);

    TextView textView = (TextView)view.findViewById(R.id.fragment_title);
    textView.setText(mTitle);

    return view;
  }
}
