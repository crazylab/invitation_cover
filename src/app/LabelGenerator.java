package app;

import com.command.CLI;
import com.util.IO;

import java.io.IOException;

public class LabelGenerator {

//    static boolean isValidInput(String[] args) {
//        return args[1].toUpperCase().matches("FORMAL|CASUAL");
//    }
//
//    static void showHelp() {
//        System.out.println("Valid Input Format");
//        System.out.println("LabelGenerator <country_name> <formal/casual> <file_path>");
//        System.exit(1);
//    }

//    public static void main(String[] args) throws IOException {
//        if (!isValidInput(args) || args[0].equals("--help"))
//            showHelp();
//
//        String countryRequested = args[0],
//                representationFormat = args[1].toUpperCase(),
//                filePath = args[2];
//
//        ArrayList<String[]> guestDetailsList = FileIO.readCSVLine(filePath);
//
//        GuestList guestList = GuestList.createGuestList(guestDetailsList);
//
//        List<String> guests;
//        Caller caller;
//        LabelGenerator invitationPrinter;
//
//        Validations validations = new Validations();
//        validations.addValidation(new ValidateByCountry(countryRequested));
//        switch (representationFormat) {
//            case "FORMAL":
//                caller = new LastNameFirst();
//                break;
//            default:
//                caller = new FirstNameFirst();
//        }
//        invitationPrinter = new NameWithCountry(caller);
//        guests = guestList.invite(invitationPrinter, validations);
//        for (String guest : guests)
//            System.out.println(guest);
//
//    }

    public static void main(String[] command) throws IOException {
        IO io = new IO();
        CLI cli = new CLI(io);
        cli.runCommand(command);
    }
}