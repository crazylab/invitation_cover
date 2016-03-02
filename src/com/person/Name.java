package com.person;

public class Name {
    private String first;

    private String last;

    public Name(String firstName, String lastName) {
        this.first = firstName;
        this.last = lastName;
    }

    String representCasually() {
        return first + " " + last;
    }

    String representFormally() {
        return last + ", " + first;
    }
}
