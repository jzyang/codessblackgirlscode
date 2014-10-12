package com.codess.microsoft.blackgirlscode;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julia on 10/11/14.
 */
public class MainPagerActivity extends FragmentActivity
{
  private ViewPager mTabbedViewPager;
  TabPagerAdapter mTabPagerAdapter;
  private List<ListFragment> tabs = new ArrayList<ListFragment>(2);

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tabs);

    mTabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
    // Set up action bar.
    final ActionBar actionBar = getActionBar();

    // Specify that the Home button should show an "Up" caret, indicating that touching the
    // button will take the user one step up in the application's hierarchy.
    actionBar.setDisplayHomeAsUpEnabled(true);
    mTabbedViewPager = (ViewPager) findViewById(R.id.pager);
    mTabbedViewPager.setAdapter(mTabPagerAdapter);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        // This is called when the Home (Up) button is pressed in the action bar.
        // Create a simple intent that starts the hierarchical parent activity and
        // use NavUtils in the Support Package to ensure proper handling of Up.
        Intent upIntent = new Intent(this, BlackGirlsCode.class);
        if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
          // This activity is not part of the application's task, so create a new task
          // with a synthesized back stack.
          TaskStackBuilder.from(this)
              // If there are ancestor activities, they should be added here.
              .addNextIntent(upIntent)
              .startActivities();
          finish();
        } else {
          // This activity is part of the application's task, so simply
          // navigate up to the hierarchical parent activity.
          NavUtils.navigateUpTo(this, upIntent);
        }
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  /**
   * A {@link android.support.v4.app.FragmentStatePagerAdapter} that returns a fragment
   * representing an object in the collection.
   */
  public static class TabPagerAdapter extends FragmentStatePagerAdapter {

    public TabPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int i) {
      if (i == 0)
      {
        return EventListFragment.newInstance();
      }
      else
      {
        return ProfileListFragment.newInstance();
      }
    }

    @Override
    public int getCount() {
      // For this contrived example, we have a 100-object collection.
      return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      if (position == 0)
      {
        return "EVENTS";
      }
      else
      {
        return "PROFILES";
      }
    }
  }

}
