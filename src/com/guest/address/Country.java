package com.guest.address;

import com.validation.country.CountryPredicate;

public class Country {
    private String country;

    public Country(String country) {
        this.country = country;
    }

    public String name() {
        return country;
    }

    public boolean isValid(CountryPredicate countryPredicate) {
        return countryPredicate.checkValidity(country);
    }
}
