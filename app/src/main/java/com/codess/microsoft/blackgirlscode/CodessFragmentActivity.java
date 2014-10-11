package com.codess.microsoft.blackgirlscode;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by Julia on 5/8/14.
 */
public abstract class CodessFragmentActivity extends FragmentActivity
{
  protected abstract Fragment createFragment();

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    // Set the activity's view to be inflated from activity_fragment.xml
    setContentView(R.layout.activity_fragment);

    // Look for the fragment
    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);

    if (fragment == null)
    {
      // Create the fragment, if it does not already exist
      fragment = createFragment();
      fragmentManager.beginTransaction()
          .add(R.id.fragmentContainer, fragment)
          .commit();
    }
  }
}
