package com.guest.address;

import com.invitation.label.Formatter;
import com.validation.country.AddressPredicate;

public class Address {
    private City city;

    private State state;

    private Country country;

    public static Address createAddress(java.lang.String city, java.lang.String state, java.lang.String country) {
        return new Address(new City(city), new State(state), new Country(country));
    }

    private Address(City city, State state, Country country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public java.lang.String represent(Formatter format) {
        return format.generate(city.getName(), state.getName(), country.getName());
    }

    public boolean isAllowed(AddressPredicate addressPredicate) {
        return addressPredicate.checkValidity(city, state, country);
    }
}
