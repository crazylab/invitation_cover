package com.guest;

import com.invitation.label.Formatter;
import com.validation.country.CountryPredicate;

public class Address {
    private String city;

    private String state;

    private String country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String represent(Formatter format){
        return format.generate(city, state, country);
    }

    public boolean isAllowed(CountryPredicate countryPredicate) {
        return countryPredicate.checkValidity(country);
    }
}
