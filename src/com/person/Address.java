package com.person;

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

    public String addCountryAtEnd(String label){
        return label.concat(", "+country);
    }
}
