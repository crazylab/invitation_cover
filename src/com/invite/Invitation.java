package com.invite;

public class Invitation {
    public String getLabelWithCountry(String title, String fullname, String country) {
        return title + " " +fullname+ ", "+country;
    }
}
