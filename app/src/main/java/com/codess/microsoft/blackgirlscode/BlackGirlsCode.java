package com.codess.microsoft.blackgirlscode;

import android.support.v4.app.Fragment;

public class BlackGirlsCode extends CodessFragmentActivity
{
  @Override
  protected Fragment createFragment()
  {
    return new ProfileListFragment();
  }
}
