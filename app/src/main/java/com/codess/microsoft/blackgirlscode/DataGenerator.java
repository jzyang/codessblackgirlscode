package com.codess.microsoft.blackgirlscode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class DataGenerator {

  private static ArrayList<Person> peopleList = new ArrayList<Person>();
  private static HashMap<UUID, Person> people = new HashMap<UUID, Person>();

  public static HashMap<UUID, Person> makePeople()
  {
    if (!people.isEmpty())
    {
      return people;
    }

    if (peopleList.isEmpty())
    {
      createPeopleList();
    }

    for(int i = 0; i < peopleList.size(); i++)
    {
      Person person = peopleList.get(i);
      people.put(person.getId(), person);
    }

    return people;
  }

  public static ArrayList<Person> createPeopleList()
  {
    ArrayList<Person> peopleList = new ArrayList<Person>();

    String[] names = {"Mary Lou","Holly Hack", "Molly Moo", "Betty Bop", "Marissa Mayer"};
    int[] ages = {10, 18, 24, 13, 33};
    String[] languages = {"Java, C", "Ruby, Python", "Java, Android", "Python", "ASP.NET, C#"};
    String[] hobbies = {"swimming, running", "camping, hunting", "skiing, snowboarding", "sleeping, eating", "traveling, dancing"};
    String[] goals = {"Build an Android app", "Build a web app", "Build something to help the Red Cross", "Learn backend development", "Learn data science"};

    for (int i = 0; i < 5; i++) {
      Person person = new Person();
      person.setAge((int)(Math.random() * 50 + 1));
      person.setName(names[i]);
      person.setAge(ages[i]);
      person.setLanguages(languages[i]);
      person.setHobbies(hobbies[i]);
      person.setGoals(goals[i]);

      peopleList.add(person);
    }

    return peopleList;
  }
}