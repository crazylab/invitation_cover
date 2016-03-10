package app;

import com.validation.ValidateByCountry;
import com.validation.Validations;
import com.guestList.GuestList;
import com.invitation.label.InvitationPrinter;
import com.invitation.label.NameWithCountry;
import com.invitation.name.Caller;
import com.invitation.name.FirstNameFirst;
import com.invitation.name.LastNameFirst;
import com.util.FileIO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InvitationGenerator {

    static boolean isValidInput(String[] args) {
        return args[1].toUpperCase().matches("FORMAL|CASUAL");
    }

    static void showHelp() {
        System.out.println("Valid Input Format");
        System.out.println("InvitationGenerator <country_name> <formal/casual> <file_path>");
        System.exit(1);
    }

    public static void main(String[] args) throws IOException {
        if (!isValidInput(args) || args[0].equals("--help"))
            showHelp();

        String countryRequested = args[0],
                representationFormat = args[1].toUpperCase(),
                filePath = args[2];

        ArrayList<String[]> guestDetailsList = FileIO.readCSVLine(filePath);

        GuestList guestList = GuestList.createGuestList(guestDetailsList);

        List<String> guests;
        Caller caller;
        InvitationPrinter invitationPrinter;

        Validations validations = new Validations();
        validations.addValidation(new ValidateByCountry(countryRequested));
        switch (representationFormat) {
            case "FORMAL":
                caller = new LastNameFirst();
                break;
            default:
                caller = new FirstNameFirst();
        }
        invitationPrinter = new NameWithCountry(caller);
        guests = guestList.invite(invitationPrinter, validations);
        for (String guest : guests)
            System.out.println(guest);

    }
}