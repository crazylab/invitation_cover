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

    public String getCountry(){
        return country;
    }
    public String getState(){
        return state;
    }

    public String getCity() {
        return city;
    }
}
