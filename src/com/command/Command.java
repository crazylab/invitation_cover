package com.command;

import com.invitation.label.LabelGenerator;
import com.invitation.label.WithFullAddress;
import com.invitation.name.NameFormat;
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

    private NameFormat getNameFormat() {
        String nameFormat = command[0].replace("--", "").toUpperCase();
        return NameFormat.valueOf(nameFormat);
    }

    public LabelGenerator getLabelGenerator() {
        return labelGenerator;
    }

    private void parseCommand() {
        labelGenerator = new LabelGenerator(getNameFormat(), new WithFullAddress());
        int ageLimitIndex = Arrays.asList(command).indexOf("--ageabove")+ 1;
        int countryIndex = Arrays.asList(command).indexOf("--country") + 1;

        if(countryIndex != 0)
            validations.addValidation(new ValidateByCountry(command[countryIndex]));
        if(ageLimitIndex != 0){
            validations.addValidation(new ValidateByAge(Integer.parseInt(command[ageLimitIndex])));
        }
    }

    public Validations getValidator() {
        return validations;
    }
}
