package com.validation.country;

public class FromCountry implements CountryPredicate{
    private String country;

    public FromCountry(String country) {
        this.country = country;
    }

    public boolean checkValidity(String country){
        return this.country.equalsIgnoreCase(country);
    }
}
