package com.invitation.name;

public class LastNameFirst implements Caller {

    @Override
    public String call(String title, String firstName, String lastName) {
        return String.format("%s %s, %s", title, lastName, firstName);
    }
}
