package com.validation.age;

import com.guest.Address;
import com.guest.Age;
import com.validation.Validator;

public class ValidateByAge implements Validator {
    int age;

    public ValidateByAge(int age) {
        this.age = age;
    }

    @Override
    public boolean isAllowed(Age age, Address address) {
        return age.isAllowed(new OlderThan(this.age));
    }
}
