package com.validation.country;

public class FromCountry implements CountryPredicate{
    private String country;

    public FromCountry(String country) {
        this.country = country.toUpperCase();
    }

    public boolean checkValidity(String country){
        return this.country.equals(country.toUpperCase());
    };
}
