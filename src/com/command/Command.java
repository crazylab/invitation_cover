package com.command;

import com.invitation.label.InvitationGenerator;
import com.invitation.label.NameWithCountry;
import com.invitation.name.Caller;
import com.validation.ValidateByCountry;
import com.validation.Validations;

public class Command {
    private String[] command;
    private InvitationGenerator printer;
    private Validations validator = new Validations();

    public Command(String[] command) {
        this.command = command;
    }

    public String getFileName() {
        return command[command.length - 1];
    }

    public InvitationGenerator getPrinter() {
        String nameFormat = command[0].toUpperCase().replace("--","");
        Caller caller = NameFormatOptions.valueOf(nameFormat).getCaller();
        return new NameWithCountry(caller);
    }

    public Validations getValidator() {
        Validations validations = new Validations();
        validations.addValidation(new ValidateByCountry(command[2]));

        return validations;
    }
}
