package main;

import com.person.Person;
import fileIO.CSVReader;
import represent.Invitation;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader("data/records");
        List<Person> entries = reader.getGuestList();

        for (Person person:entries) {
            Invitation invitation = new Invitation(person);
            System.out.println(invitation.casully());
            System.out.println(invitation.formally());
        }
    }
}
