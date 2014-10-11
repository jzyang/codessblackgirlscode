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

  private ArrayList<Person> mPersons;

  private ProfilesBook(Context appContext)
  {
    mAppContext = appContext;
    mPersons = new ArrayList<Person>();

    for(int i = 0; i < 100; i++)
    {
      Person person = new Person();
      person.setName("Jane #" + i);
      mPersons.add(person);
    }
  }

  public static ProfilesBook get(Context context)
  {
    if (sProfilesBook == null)
    {
      sProfilesBook = new ProfilesBook(context.getApplicationContext());
    }

    return sProfilesBook;
  }

  public ArrayList<Person> getCrimes()
  {
    return mPersons;
  }

  public Person getCrime(UUID id)
  {
    for (Person person : mPersons)
    {
      if (person.getId().equals(id))
      {
        return person;
      }
    }

    return null;
  }

  public void addProfile(Person person)
  {
    mPersons.add(person);
  }
}
