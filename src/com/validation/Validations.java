package com.validation;

import com.guest.Guest;

import java.util.ArrayList;
import java.util.List;

public class Validations {
    private List<Validator> validators = new ArrayList<>();

    public Validations(List<Validator> validators) {
        this.validators = validators;
    }

    public boolean isValid(Guest guest){
        for (Validator validator : validators)
            if(!guest.isAllowed(validator))
                return false;
        return true;
    }
}
