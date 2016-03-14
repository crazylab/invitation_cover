package com.validation.country;

import com.guest.address.Address;
import com.guest.Age;
import com.validation.Validator;

public class ValidateByCountry implements Validator {

    private AddressPredicate addressPredicate;

    public ValidateByCountry(AddressPredicate addressPredicate) {
        this.addressPredicate = addressPredicate;
    }

    @Override
    public boolean isAllowed(Age age, Address address) {
        return address.isAllowed(addressPredicate);
    }
}
