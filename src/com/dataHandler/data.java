package com.dataHandler;

import com.person.Address;
import com.person.Gender;
import com.person.Name;
import com.person.Person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Data {
    private String fileName;

    private Database database;

    public Data(String fileName, Database database) {
        this.fileName = fileName;
        this.database = database;
    }

    public Database addToDatabase() throws IOException {
        File file = new File(fileName);
        String line = "";
        BufferedReader reader = new BufferedReader(new FileReader(file));

        while (reader.readLine() != null) {
            line = reader.readLine();
            String[] personDetails = line.split(",");
            Person person = createPerson(personDetails);
            database.addToCountry(person.getCountry(), person);
        }
        return database;
    }

    private Person createPerson(String[] details) {
        Name name = new Name(details[0], details[1]);
        Gender gender = details[2].equals("Male") ? Gender.Male : Gender.Female;
        int age = Integer.parseInt(details[3]);
        Address address = new Address(details[4], details[5], details[6]);

        return new Person(name, gender, age, address);
    }
}
