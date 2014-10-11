package com.codess.microsoft.blackgirlscode;

import java.util.UUID;

/**
 * Created by Julia on 10/11/14.
 */
public class Profile
{
  private String joinDate;
  private String name;
  private String profile;
  private UUID mUUID;

  private final int shortLength = 100;

  public Profile(UUID uuid, String date, String title, String details)
  {

  }

  public String getJoinDate()
  {
    return joinDate;
  }

  public void getJoinDate(String joinDate)
  {
    this.joinDate = joinDate;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getProfile()
  {
    return profile;
  }

  public UUID getId()
  {
    return mUUID;
  }
}
