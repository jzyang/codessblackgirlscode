package com.codess.microsoft.blackgirlscode;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

public class PersonsBook {
    private static PersonsBook sPersonsBook;
    private Context mAppContext;

    private ArrayList<Person> mPersons;

    private PersonsBook(Context appContext)
    {
        mAppContext = appContext;
        mPersons = new ArrayList<Person>();
    }

    public static PersonsBook get(Context context)
    {
        if (sPersonsBook == null)
        {
            sPersonsBook = new PersonsBook(context.getApplicationContext());
        }

        return sPersonsBook;
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

    public void addPerson(Person person)
    {
        mPersons.add(person);
    }
}
