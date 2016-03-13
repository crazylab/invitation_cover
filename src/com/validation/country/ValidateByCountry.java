package com.validation.country;

import com.guest.Address;
import com.guest.Age;
import com.validation.Validator;

public class ValidateByCountry implements Validator {
    String country;

    public ValidateByCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean isAllowed(Age age, Address address) {
        return address.isAllowed(new FromCountry(this.country));
    }
}
