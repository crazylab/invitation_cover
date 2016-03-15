package com.guest.name.represent;

public class LastNameFirst implements NameFormatter {
    @Override
    public String representName(String title, String firstName, String lastName) {
        return String.format("%s %s, %s", title, lastName, firstName);
    }
}
