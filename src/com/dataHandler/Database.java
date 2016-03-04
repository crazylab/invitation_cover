package com.dataHandler;


import com.person.Person;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private HashMap<String, ArrayList<Person>> database = new HashMap<>();

    public boolean addToCountry(String country, Person person){
        country = country.toUpperCase();
        if(database.containsKey(country)) {
            ArrayList<Person> guests = database.get(country);
            guests.add(person);
        } else {
            ArrayList<Person> guests = new ArrayList<Person>();
            guests.add(person);
            database.put(country, guests);
        }
        return true;
    }

    public ArrayList<Person> getGuestsFrom(String country){
        return database.get(country.toUpperCase());
    }
}
