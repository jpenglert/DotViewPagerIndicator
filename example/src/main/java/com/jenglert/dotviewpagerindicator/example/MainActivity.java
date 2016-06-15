package com.jenglert.dotviewpagerindicator.example;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jenglert.dotviewpagerindicator.DotViewPagerIndicator;

public class MainActivity extends AppCompatActivity {

  private ViewPager mViewPager;
  private ExamplePagerAdapter mPagerAdapter;
  private DotViewPagerIndicator mViewPagerIndicator;

  @SuppressWarnings("ConstantConditions")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mViewPager = (ViewPager)findViewById(R.id.view_pager);
    mPagerAdapter = new ExamplePagerAdapter(getSupportFragmentManager());
    mViewPager.setAdapter(mPagerAdapter);

    mViewPagerIndicator = (DotViewPagerIndicator)findViewById(R.id.dotviewpagerindicator);
    mViewPagerIndicator.setViewPager(mViewPager);

    mPagerAdapter.registerDataSetObserver(new DataSetObserver() {
      @Override
      public void onChanged() {
        if (mViewPager.getCurrentItem() >= mPagerAdapter.getCount()) {
          mViewPager.setCurrentItem(Math.max(0, mPagerAdapter.getCount() - 1));
        }
      }
    });

    Button addButton = (Button)findViewById(R.id.add_fragment_button);
    addButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mPagerAdapter.addPage();
      }
    });

    Button removeButton = (Button)findViewById(R.id.remove_fragment_button);
    removeButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mPagerAdapter.removePage();
      }
    });
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    mViewPager.removeOnPageChangeListener(mViewPagerIndicator);
  }

  @Override
  public void onBackPressed() {
    if (mViewPager.getCurrentItem() == 0) {
      // If the user is currently looking at the first step, allow the system to handle the
      // Back button. This calls finish() on this activity and pops the back stack.
      super.onBackPressed();
    }
    else {
      // Otherwise, select the previous step.
      mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
    }
  }

  private class ExamplePagerAdapter extends FragmentStatePagerAdapter {

    private int mCount;

    public ExamplePagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      return ViewPagerFragment.newInstance("Fragement " + (position + 1));
    }

    @Override
    public int getCount() {
      return mCount;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      super.destroyItem(container, position, object);

    }

    public void addPage() {
      mCount += 1;
      notifyDataSetChanged();
    }

    public void removePage() {
      mCount = Math.max(0, mCount - 1);
      notifyDataSetChanged();
    }
  }
}
