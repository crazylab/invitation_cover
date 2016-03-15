package com.validation;

import com.guest.Guest;

import java.util.ArrayList;
import java.util.List;

public class ListOfValidations {
    private List<Validator> validators = new ArrayList<>();

    public ListOfValidations(List<Validator> validators) {
        this.validators = validators;
    }

    public boolean isValid(Guest guest){
        for (Validator validator : validators)
            if(!guest.isAllowed(validator))
                return false;
        return true;
    }
}
