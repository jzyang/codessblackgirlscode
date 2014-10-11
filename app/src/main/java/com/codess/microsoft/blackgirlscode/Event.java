package com.codess.microsoft.blackgirlscode;

import java.util.UUID;

/**
 * Created by Julia on 10/11/14.
 */
public class Event
{
  private String eventDate;
  private String eventTitle;
  private String eventDetails;
  private UUID mUUID;

  private final int shortLength = 100;

  public Event(UUID uuid, String date, String title, String details)
  {

  }

  public String getEventDate()
  {
    return eventDate;
  }

  public void setEventDate(String eventDate)
  {
    this.eventDate = eventDate;
  }

  public String getEventTitle()
  {
    return eventTitle;
  }

  public void setEventTitle(String eventTitle)
  {
    this.eventTitle = eventTitle;
  }

  public String getEventDetails()
  {
    return eventDetails;
  }

  public UUID getId()
  {
    return mUUID;
  }

  public void setEventDetails(String eventDetails)
  {
    this.eventDetails = eventDetails;
  }

  public String getShortEVentDetails()
  {
    return eventDetails.subSequence(0, shortLength).toString();
  }
}
