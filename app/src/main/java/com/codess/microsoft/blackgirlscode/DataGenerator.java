package com.codess.microsoft.blackgirlscode;

import java.util.HashMap;
import java.util.UUID;

public class DataGenerator {

    public static HashMap<UUID, Person> makePeople() {
        HashMap<UUID, Person> people = new HashMap<UUID, Person>();
        String[] names = {"Mary Lou","Holly Hack", "Molly Moo", "Betty Bop", "Marissa Mayer"};
        int[] ages = {10, 18, 24, 13, 33};
        String[] languages = {"Java, C", "Ruby, Python", "Java, Android", "Python", "ASP.NET, C#"};
        String[] hobbies = {"swimming, running", "camping, hunting", "skiing, snowboarding", "sleeping, eating", "traveling, dancing"};
        String[] goals = {"Build an Android app", "Build a web app", "Build something to help the Red Cross", "Learn backend development", "Learn data science"};

        for (int i = 0; i <= 10; i++) {
            Person person = new Person(UUID.randomUUID());
            person.setAge((int)(Math.random() * 50 + 1));
            person.setName(names[i]);
            person.setAge(ages[i]);
            person.setLanguages(languages[i]);
            person.setHobbies(hobbies[i]);
            person.setGoals(goals[i]);
            people.put(person.getId(), person);
        }
        return people;
    }
}