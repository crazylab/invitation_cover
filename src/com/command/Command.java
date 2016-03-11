package com.command;

import com.invitation.label.InvitationFormatter;
import com.invitation.label.WithCountry;
import com.invitation.name.Caller;
import com.validation.ValidateByCountry;
import com.validation.Validations;

public class Command {
    private String[] command;
//    private InvitationFormatter printer;
    private Validations validator = new Validations();

    public Command(String[] command) {
        this.command = command;
    }

    public String getFileName() {
        return command[command.length - 1];
    }

    private Caller getCallingFormat() {
        String nameFormat = command[0].toUpperCase().replace("--", "");
        return NameFormatOptions.valueOf(nameFormat).getCaller();
    }

    public InvitationFormatter getPrinter() {
        return new WithCountry(getCallingFormat());
    }

    public Validations getValidator() {
        Validations validations = new Validations();
        validations.addValidation(new ValidateByCountry(command[2]));

        return validations;
    }
}
