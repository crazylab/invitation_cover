package com.validation;

import com.guest.Guest;

import java.util.ArrayList;
import java.util.List;

public class Validations {
    private List<Validator> validators = new ArrayList<>();

    public void addValidation(Validator validator){
        validators.add(validator);
    }

    public boolean isValid(Guest guest){
        for (Validator validator : validators)
            if(!validator.isAllowed(guest))
                return false;
        return true;
    }
}
