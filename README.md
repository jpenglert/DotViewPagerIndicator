# DotViewPagerIndicator
A simple ViewPager indicator displaying colored dots for android.
Shows how many pages are in the ViewPager and indicates the current page.

[ ![Download](https://api.bintray.com/packages/jpenglert/maven/com.jenglert.dotviewpagerindicator/images/download.svg) ](https://bintray.com/jpenglert/maven/com.jenglert.dotviewpagerindicator/_latestVersion)

![DotViewPagerIndicator Sample Screenshot][1]

## Usage

### build.gradle

```groovy
dependencies {
   compile 'com.jenglert:dotviewpagerindicator:1.0.0'
}
```

### MainActivity.java

```java
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.jenglert.dotviewpagerindicator.DotViewPagerIndicator;

public class MainActivity extends AppCompatActivity {

  private ViewPager mViewPager;
  private ExamplePagerAdapter mPagerAdapter;
  private DotViewPagerIndicator mViewPagerIndicator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mViewPager = (ViewPager)findViewById(R.id.view_pager);
    mPagerAdapter = new ExamplePagerAdapter(getSupportFragmentManager());
    mViewPager.setAdapter(mPagerAdapter);

    mViewPagerIndicator = (DotViewPagerIndicator)findViewById(R.id.dotviewpagerindicator);
    mViewPagerIndicator.setViewPager(mViewPager);
  }
  
  ...
}
```
[1]: https://raw.githubusercontent.com/jpenglert/DotViewPagerIndicator/master/example/screenshot.png
