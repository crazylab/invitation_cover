package fileIO;

import com.person.Address;
import com.person.Gender;
import com.person.Name;
import com.person.Person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private String fileName;

    List<Person> entries = new ArrayList<Person>();

    public CSVReader(String fileName) {
        this.fileName = fileName;
    }

    public List<Person> getGuestList() throws IOException {
        File file = new File(fileName);
        long fileSize = file.length();

        String line = "";
        BufferedReader reader = new BufferedReader(new FileReader(file));

        while (reader.readLine() != null) {
            line = reader.readLine();
            String[] personDetails = line.split(",");
            entries.add(createPerson(personDetails));
        }
        return entries;
    }

    private Person createPerson(String[] details) {
        Name name = new Name(details[0], details[1]);
        Gender gender = details[2].equals("Male") ? Gender.Male : Gender.Female;
        int age = Integer.parseInt(details[3]);
        Address address = new Address(details[4], details[5], details[6]);

        return new Person(name, gender, age, address);
    }
}
