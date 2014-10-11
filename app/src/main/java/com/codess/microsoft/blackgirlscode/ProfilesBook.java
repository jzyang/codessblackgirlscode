package com.codess.microsoft.blackgirlscode;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Julia on 10/11/14.
 */
public class ProfilesBook
{
  private static ProfilesBook sProfilesBook;
  private Context mAppContext;

  private ArrayList<Profile> mProfiles;

  private ProfilesBook(Context appContext)
  {
    mAppContext = appContext;
    mProfiles = new ArrayList<Profile>();
  }

  public static ProfilesBook get(Context context)
  {
    if (sProfilesBook == null)
    {
      sProfilesBook = new ProfilesBook(context.getApplicationContext());
    }

    return sProfilesBook;
  }

  public ArrayList<Profile> getCrimes()
  {
    return mProfiles;
  }

  public Profile getCrime(UUID id)
  {
    for (Profile profile : mProfiles)
    {
      if (profile.getId().equals(id))
      {
        return profile;
      }
    }

    return null;
  }

  public void addProfile(Profile profile)
  {
    mProfiles.add(profile);
  }
}
