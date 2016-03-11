package com.command;

import com.invitation.label.LabelGenerator;
import com.invitation.label.WithAge;
import com.invitation.label.WithCountry;
import com.invitation.name.NameFormatter;
import com.validation.ValidateByAge;
import com.validation.ValidateByCountry;
import com.validation.Validations;

import java.util.Arrays;

public class Command {
    private String[] command;
    private Validations validations = new Validations();
    private LabelGenerator labelGenerator;

    public Command(String[] command) {
        this.command = command;
        parseCommand();
    }

    public String getFileName() {
        return command[command.length - 1];
    }

    private NameFormatter getCallingFormat() {
        String nameFormat = command[0].replace("--", "").toUpperCase();
        return NameFormatOptions.valueOf(nameFormat).getNameFormatter();
    }

    public LabelGenerator getLabelGenerator() {
        return labelGenerator;
    }

    private void parseCommand() {
        labelGenerator = new LabelGenerator(getCallingFormat());
        int ageLimitIndex = Arrays.asList(command).indexOf("--ageabove")+ 1;
        int countryIndex = Arrays.asList(command).indexOf("--country") + 1;

        if(countryIndex != 0) {
            labelGenerator.addFormat(new WithCountry());
            validations.addValidation(new ValidateByCountry(command[countryIndex]));
        }
        if(ageLimitIndex != 0){
            labelGenerator.addFormat(new WithAge());
            validations.addValidation(new ValidateByAge(Integer.parseInt(command[ageLimitIndex])));
        }
    }

    public Validations getValidator() {
        return validations;
    }
}
