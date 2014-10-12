package com.codess.microsoft.blackgirlscode;


import java.util.Date;
import java.util.UUID;

public class Person {
  private Date joinDate;
  private String name;
  private Integer age;
  private String image;
  private String languages;
  private String hobbies;
  private String goals;

  private UUID mUUID;

  private final int shortLength = 100;

  public Person()
  {
    this.mUUID = UUID.randomUUID();
  }

  public Date getJoinDate()
  {
    return joinDate;
  }

  public void setJoinDate(Date joinDate)
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

  public Integer getAge() { return age; }

  public void setAge(Integer age)
  {
    this.age = age;
  }

  public String getLanguages() { return languages; }

  public void setLanguages(String languages)
  {
    this.languages = languages;
  }

  public String getImage() { return image; }

  public void setImage(String image)
  {
    this.image = image;
  }

  public String getHobbies() { return hobbies; }

  public void setHobbies(String hobbies) { this.hobbies = hobbies; }

  public String getGoals() { return goals; }

  public void setGoals(String hobbies) { this.goals = hobbies; }

  public UUID getId() { return mUUID; }
}