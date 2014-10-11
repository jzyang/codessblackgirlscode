package com.codess.microsoft.blackgirlscode;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Julia on 10/11/14.
 */
public class Event
{
  private Date eventDate;
  private String eventTitle;
  private String eventDetails;
  private UUID mUUID;

  private final int shortLength = 100;

  public Event()
  {
    mUUID = UUID.randomUUID();
    eventTitle = "New Profile";
    eventDetails = "Come to our event";
  }

  public Date getEventDate()
  {
    return eventDate;
  }

  public void setEventDate(Date eventDate)
  {
    this.eventDate = eventDate;
  }

  public String getTitle()
  {
    return eventTitle;
  }

  public void setTitle(String eventTitle)
  {
    this.eventTitle = eventTitle;
  }

  public String getDetails()
  {
    return eventDetails;
  }

  public UUID getId()
  {
    return mUUID;
  }

  public void setDetails(String eventDetails)
  {
    this.eventDetails = eventDetails;
  }

  public String getShortEventDetails()
  {
    return eventDetails.subSequence(0, shortLength).toString();
  }
}
