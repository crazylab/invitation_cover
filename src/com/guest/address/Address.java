package com.guest.address;

import com.invitation.label.Formatter;
import com.validation.country.CountryPredicate;

public class Address {
    private City city;

    private State state;

    private Country country;

    public static Address createAddress(String city, String state, String country) {
        return new Address(new City(city), new State(state), new Country(country));
    }

    private Address(City city, State state, Country country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String represent(Formatter format) {
        return format.generate(city.name(), state.name(), country.name());
    }

    public boolean isAllowed(CountryPredicate countryPredicate) {
        return country.isValid(countryPredicate);
    }
}
