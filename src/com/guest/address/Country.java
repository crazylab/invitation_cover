package com.guest.address;

public class Country {
    private String country;

    public Country(String country) {
        this.country = country;
    }

    public boolean equals(String country) {
        return this.country.equalsIgnoreCase(country);
    }

    public String getName() {
        return country;
    }
}
