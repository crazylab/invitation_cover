package app;

import com.dataHandler.Data;
import com.dataHandler.Database;
import com.person.Person;

import java.io.IOException;
import java.util.ArrayList;

public class InvitationCover {

    public static void main(String[] args) throws IOException {
        String filePath = args[0],
                countryRequested = args[1],
                representationFormat = args[2].toUpperCase();

        System.out.println();
        Database database = new Database();
        Data data = new Data(filePath, database);

        data.addToDatabase();

        ArrayList<Person> guests = database.getGuestsFrom(countryRequested);

        switch (representationFormat){
            case "FORMAL" : for (Person person : guests)
                                System.out.println(person.getFormalInvitation());
                            break;
            default:        for (Person person : guests)
                                System.out.println(person.getCasualInvitation());
        }
    }
}