package com.command;

import com.invitation.label.InvitationFormatter;
import com.invitation.label.LabelGenerator;
import com.invitation.label.WithAge;
import com.invitation.label.WithCountry;
import com.invitation.name.Caller;
import com.validation.ValidateByAge;
import com.validation.ValidateByCountry;
import com.validation.Validations;
import com.validation.Validator;

public class Command {
    private String[] command;
    private Validations validations = new Validations();

    public Command(String[] command) {
        this.command = command;
    }

    public String getFileName() {
        return command[command.length - 1];
    }

    private Caller getCallingFormat() {
        String nameFormat = command[0].replace("--", "").toUpperCase();
        return NameFormatOptions.valueOf(nameFormat).getCaller();
    }

    private InvitationFormatter getFormatter(String option){
        switch (option.toUpperCase()){
            case "--AGE" : return new WithAge();
            case "--COUNTRY" : return new WithCountry();
        }
        return null;
    }

    private Validator getValidator(String option, String condition){
        switch (option.toUpperCase()){
            case "--AGE" : return new ValidateByAge(Integer.parseInt(condition));
            case "--COUNTRY" : return new ValidateByCountry(condition);
        }
        return null;
    }

    public LabelGenerator getLabelGenerator() {
        LabelGenerator labelGenerator = new LabelGenerator(getCallingFormat());
        for (int i = 1; i < command.length - 2; i++) {
            if(isOption(command[i])){
                labelGenerator.addFormat(getFormatter(command[i]));
                validations.addValidation(getValidator(command[i],command[i+1]));
            }
        }
        return labelGenerator;
    }

    private boolean isOption(String arg) {
        return arg.startsWith("--");
    }

    public Validations getValidator() {
        return validations;
    }
}
