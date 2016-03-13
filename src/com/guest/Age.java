package com.guest;

import com.validation.age.AgePredicate;

public class Age{
    private int age;

    public Age(int age) {
        this.age = age;
    }

    public boolean isAllowed(AgePredicate agePredicate) {
        return agePredicate.checkValidity(age);
    }
}
