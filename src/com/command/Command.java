package com.command;

import com.guest.address.represent.WithFullAddress;
import com.guest.name.represent.FirstNameFirst;
import com.guest.name.represent.LastNameFirst;
import com.guest.name.represent.NameFormatter;
import com.invitation.label.LabelFormatter;
import com.invitation.label.LabelWithNameAddress;
import com.validation.ListOfValidations;
import com.validation.Validator;

import java.util.ArrayList;

public class Command {
    private String[] commandArgs;

    public Command(String[] commandArgs) {
        this.commandArgs = commandArgs;
    }

    public String fileName() {
        return commandArgs[commandArgs.length - 1];
    }

    private NameFormatter getNameFormat() {
        if("--LastNameFirst".equalsIgnoreCase(commandArgs[0]))
            return new LastNameFirst();
        return new FirstNameFirst();
    }

    public LabelFormatter getLabelFormatter() {
        return new LabelWithNameAddress(getNameFormat(), new WithFullAddress());
    }

    private boolean isOption(String arg) {
        return arg.startsWith("--");
    }

    public ListOfValidations getValidator() {
        ArrayList<Validator> validators = new ArrayList<>();

        for(int index = 1; index < commandArgs.length - 1; index++) {
            String arguement = commandArgs[index];
            if (isOption(arguement)) {
                arguement = arguement.replace("--", "").toUpperCase();
                String parameter = commandArgs[++index];
                Validator predicate = Options.valueOf(arguement).getValidator(parameter);
                validators.add(predicate);
            }
        }

        return new ListOfValidations(validators);
    }
}
