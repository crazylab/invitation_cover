package com.validation.age;

import com.guest.Address;
import com.guest.Age;
import com.validation.Validator;

public class ValidateByAge implements Validator {
//    int age;

    AgePredicate agePredicate;

    public ValidateByAge(AgePredicate agePredicate) {
//        this.age = age;
        this.agePredicate = agePredicate;
    }

    @Override
    public boolean isAllowed(Age age, Address address) {
        return age.isAllowed(agePredicate);
    }
}
