package com.codess.microsoft.blackgirlscode;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Julia on 10/11/14.
 */
public class Event
{
    private Date eventDate;
    private String eventLocation;
    private String eventTitle;
    private String eventDetails;
    private UUID mUUID;

    private final int shortLength = 100;

    public Event(UUID uuid, String date, String title, String details)
    {

    }

    public Date getEventDate()
    {
        return eventDate;
    }

    public void setEventDate(Date eventDate)
    {
        this.eventDate = eventDate;
    }

    public String getEventLocation()
    {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation)
    {
        this.eventLocation = eventLocation;
    }

    public String getEventTitle()
    {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle)
    {
        this.eventTitle = eventTitle;
    }

    public String getEventDetails() { return eventDetails; }

    public void setEventDetails(String eventDetails)
    {
        this.eventDetails = eventDetails;
    }

    public UUID getId()
    {
        return mUUID;
    }

    public String getShortEVentDetails()
    {
        return eventDetails.subSequence(0, shortLength).toString();
    }
}
