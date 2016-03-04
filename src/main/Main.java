package main;

import com.dataHandler.Data;
import com.dataHandler.Database;
import com.person.Person;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Database database = new Database();
        Data data = new Data("data/records", database);

        data.addToDatabase();

        ArrayList<Person> guests = database.getGuestsFrom("Bangladesh");
        for (Person person : guests)
            System.out.println(person.getCasulaName());

    }
}
