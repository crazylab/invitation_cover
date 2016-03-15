package com.guest.address;

public class City {
    private String city;

    public static City createCity(java.lang.String city){
        return new City(city);
    }
    public City(java.lang.String city) {
        this.city = city;
    }

    public String name() {
        return city;
    }
}
