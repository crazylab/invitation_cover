package com.command;

import com.guestList.GuestList;
import com.invitation.label.LabelGenerator;
import util.IO;
import com.validation.ListOfValidations;

import java.io.IOException;
import java.util.List;

public class CLI {
    private final IO io;

    public CLI(IO io) {
        this.io = io;
    }

    public void runCommand(String[] commandArgs) throws IOException {
        Command command = new Command(commandArgs);
        List<String[]> guestListAsArray = io.readCSV(command.getFileName());
        GuestList guestList = GuestList.createGuestList(guestListAsArray);
        LabelGenerator labelGenerator = command.getLabelGenerator();
        ListOfValidations validator = command.getValidator();
        List<String> labels = guestList.invite(labelGenerator, validator);
        io.print(labels);
    }
}
