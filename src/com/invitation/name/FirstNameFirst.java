package com.invitation.name;

public class FirstNameFirst implements NameFormatter {

    @Override
    public String callByName(String title, String firstName, String lastName) {
        return String.format("%s %s %s", title, firstName, lastName);
    }
}
