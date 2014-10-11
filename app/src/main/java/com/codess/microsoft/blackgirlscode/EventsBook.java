package com.codess.microsoft.blackgirlscode;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Julia on 10/11/14.
 */
public class EventsBook
{
  private static EventsBook sEventsBook;
  private Context mAppContext;

  private ArrayList<Event> mEvents;

  private EventsBook(Context appContext)
  {
    mAppContext = appContext;
    mEvents = new ArrayList<Event>();
  }

  public static EventsBook get(Context context)
  {
    if (sEventsBook == null)
    {
      sEventsBook = new EventsBook(context.getApplicationContext());
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
