package com.command;

import com.invitation.label.LabelGenerator;
import com.invitation.label.WithFullAddress;
import com.invitation.name.NameFormat;
import com.validation.Validator;
import com.validation.age.OlderThan;
import com.validation.age.ValidateByAge;
import com.validation.country.FromCountry;
import com.validation.country.ValidateByCountry;
import com.validation.Validations;

import java.util.ArrayList;
import java.util.Arrays;

public class Command {
    private String[] command;
    private Validations validations;
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

        ArrayList<Validator> validators = new ArrayList<>();
        if(countryIndex != 0)
            validators.add(new ValidateByCountry(new FromCountry(command[countryIndex])));
        if(ageLimitIndex != 0){
            validators.add(new ValidateByAge(new OlderThan(Integer.parseInt(command[ageLimitIndex]))));
        }
        validations = new Validations(validators);
    }

    public Validations getValidator() {
        return validations;
    }
}
