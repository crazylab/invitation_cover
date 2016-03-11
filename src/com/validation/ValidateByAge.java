package com.validation;

import com.guest.Guest;

public class ValidateByAge implements Validator {
    int age;

    public ValidateByAge(int age) {
        this.age = age;
    }

    public boolean isAllowed(Guest guest) {
        return guest.isOlderThan(age);
    }
}
