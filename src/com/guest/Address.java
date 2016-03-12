package com.guest;

import com.invitation.label.Formatter;

public class Address {
    private String city;

    private String state;

    private String country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public boolean isFromCountry(String country){
        return this.country.equalsIgnoreCase(country);
    }

    public String represent(Formatter format){
        return format.generate(city, state, country);
    }
}
