package main;

import com.dataHandler.Data;
import com.dataHandler.Database;
import com.person.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static String getRequestedCountry(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("From Which Country You Want Guest List : ");
        return scanner.next();
    }

    private static String getRequestedRepresentationFormat(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Formal/Casual : ");
        return scanner.next().toUpperCase();
    }
    public static void main(String[] args) throws IOException {
        Database database = new Database();
        Data data = new Data("data/records", database);

        data.addToDatabase();

        String requestedCountry = getRequestedCountry();
        ArrayList<Person> guests = database.getGuestsFrom(requestedCountry);

        switch (getRequestedRepresentationFormat()){
            case "FORMAL" : for (Person person : guests)
                                System.out.println(person.getFormalInvitation());
                            break;
            default:        for (Person person : guests)
                                System.out.println(person.getCasualInvitation());
        }
    }
}