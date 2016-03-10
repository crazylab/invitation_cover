package com.validation;

import com.guest.Guest;

public class ValidateByCountry implements Validator {
    String country;

    public ValidateByCountry(String country) {
        this.country = country;
    }

    public boolean isAllowed(Guest guest) {
        return guest.isFromCountry(country);
    }
}
