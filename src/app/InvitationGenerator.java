package app;

import com.dataHandler.FileIO;
import com.guestList.GuestList;
import invitation.label.InvitationPrinter;
import invitation.label.NameWithCountry;
import invitation.name.Caller;
import invitation.name.CasualName;
import invitation.name.FormalName;

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

        ArrayList<String> guestListAsText = (ArrayList<String>) FileIO.readLines(filePath);

        GuestList guestList = new GuestList(guestListAsText);

        List<String> guests;
        Caller caller;
        InvitationPrinter invitation;

        switch (representationFormat) {
            case "FORMAL":
                caller = new FormalName();
                invitation = new NameWithCountry(caller);

                guests = guestList.inviteFrom(countryRequested, invitation);
                for (String guest : guests)
                    System.out.println(guest);
                break;
            default:
                caller = new CasualName();
                invitation = new NameWithCountry(caller);

                guests = guestList.inviteFrom(countryRequested, invitation);
                for (String guest : guests)
                    System.out.println(guest);
        }
    }
}