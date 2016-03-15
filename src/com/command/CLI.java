package com.command;

import com.guestList.GuestList;
import com.invitation.label.LabelFormatter;
import com.validation.ListOfValidations;
import util.IO;

import java.io.IOException;
import java.util.List;

public class CLI {
    private final IO io;

    public CLI(IO io) {
        this.io = io;
    }

    public void runCommand(String[] commandArgs) throws IOException {
        Command command = new Command(commandArgs);
        List<String[]> guestListAsArray = io.readCSVFile(command.fileName());
        GuestList guestList = GuestList.createGuestList(guestListAsArray);
        LabelFormatter labelFormatter = command.getLabelFormatter();
        ListOfValidations validator = command.getValidator();
        List<String> labels = guestList.generateLabel(labelFormatter, validator);
        io.print(labels);
    }
}
