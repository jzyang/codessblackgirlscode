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
    if (sEventsBook == null)
    {
      sEventsBook = new ProfilesBook(context.getApplicationContext());
    }

    return sEventsBook;
  }

  public ArrayList<Event> getCrimes()
  {
    return mEvents;
  }

  public Event getCrime(UUID id)
  {
    for (Event event : mEvents)
    {
      if (event.getId().equals(id))
      {
        return event;
      }
    }

    return null;
  }

  public void addEvent(Event event)
  {
    mEvents.add(event);
  }
}
