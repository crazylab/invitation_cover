package com.validation.country;

import com.guest.address.City;
import com.guest.address.Country;
import com.guest.address.State;

public class FromCountry implements AddressPredicate {
    private java.lang.String country;

    public FromCountry(java.lang.String country) {
        this.country = country;
    }

    @Override
    public boolean checkValidity(City city, State state, Country country) {
        return country.equals(this.country);
    }
}
