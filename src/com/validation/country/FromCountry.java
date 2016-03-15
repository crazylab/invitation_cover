package com.validation.country;

public class FromCountry implements CountryPredicate {
    private String givenCountry;

    public FromCountry(String givenCountry) {
        this.givenCountry = givenCountry;
    }

    @Override
    public boolean checkValidity(String country) {
        return country.equals(givenCountry);
    }
}
