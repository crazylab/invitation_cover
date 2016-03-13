package com.validation.country;

import com.guest.Address;
import com.guest.Age;
import com.validation.Validator;

public class ValidateByCountry implements Validator {

    private CountryPredicate countryPredicate;

    public ValidateByCountry(CountryPredicate countryPredicate) {
        this.countryPredicate = countryPredicate;
    }

    @Override
    public boolean isAllowed(Age age, Address address) {
        return address.isAllowed(countryPredicate);
    }
}
