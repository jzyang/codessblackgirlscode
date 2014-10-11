package com.codess.microsoft.blackgirlscode;

import android.content.Context;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Julia on 10/11/14.
 */
public class ProfilesBook
{
  private static ProfilesBook sProfilesBook;
  private Context mAppContext;

  private ArrayList<Person> mPersons;
  private Map<UUID, Person> mPeopleMap;

  private ProfilesBook(Context appContext)
  {
    mAppContext = appContext;
    mPersons = DataGenerator.createPeopleList();
    mPeopleMap = DataGenerator.makePeople();
  }

  public static ProfilesBook get(Context context)
  {
    if (sProfilesBook == null)
    {
      sProfilesBook = new ProfilesBook(context.getApplicationContext());
    }

    return sProfilesBook;
  }

  public ArrayList<Person> getProfiles()
  {
    return mPersons;
  }

  public Person getProfile(UUID id)
  {
    return mPeopleMap.get(id);
  }

  public void addProfile(Person person)
  {
    mPersons.add(person);
  }
}
