package com.command;

import com.invitation.label.LabelGenerator;
import com.invitation.label.WithFullAddress;
import com.invitation.name.NameFormat;
import com.validation.Validations;
import com.validation.Validator;
import org.hamcrest.internal.ArrayIterator;

import java.util.ArrayList;

public class Command {
    private String[] command;

    public Command(String[] command) {
        this.command = command;
    }

    public String getFileName() {
        return command[command.length - 1];
    }

    private NameFormat getNameFormat() {
        String nameFormat = command[0].replace("--", "").toUpperCase();
        return NameFormat.valueOf(nameFormat);
    }

    public LabelGenerator getLabelGenerator() {
        return new LabelGenerator(getNameFormat(), new WithFullAddress());
    }

    private boolean isOption(String arg) {
        return arg.startsWith("--");
    }

    public Validations getValidator() {
        ArrayIterator iterator = new ArrayIterator(command);
        iterator.next();    //Skipping name format

        ArrayList<Validator> validators = new ArrayList<>();
        while (iterator.hasNext()) {
            String arguement = (String) iterator.next();
            if (isOption(arguement)) {
                arguement = arguement.replace("--", "").toUpperCase();
                String parameter = (String) iterator.next();
                Validator predicate = Options.valueOf(arguement).getValidator(parameter);
                validators.add(predicate);
            }
        }
        return new Validations(validators);
    }
}
