package com.person;

public class Name {
    private String first;

    private String last;

    public Name(String firstName, String lastName) {
        this.first = firstName;
        this.last = lastName;
    }

    public String representCasually() {
        return first + " " + last;
    }

    public String representFormally() {
        return last + ", " + first;
    }
}
