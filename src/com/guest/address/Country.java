package com.guest.address;

import com.validation.country.CountryPredicate;

public class Country {
    private String country;

    public Country(String country) {
        this.country = country;
    }

//    public boolean equals(String country) {
//        return this.country.equalsIgnoreCase(country);
//    }
    public String name() {
        return country;
    }

    public boolean isValid(CountryPredicate countryPredicate){
        return countryPredicate.checkValidity(country);
    }
}
