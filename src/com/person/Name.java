package com.person;

import invitation.name.NameRepresentation;

public class Name {
    private String first;

    private String last;

    private NameRepresentation nameRepresentation;

    public Name(String firstName, String lastName, NameRepresentation nameRepresentation) {
        this.first = firstName;
        this.last = lastName;
        this.nameRepresentation = nameRepresentation;
    }

    public String call(String honorific){
        return honorific + " "+nameRepresentation.call(first, last);
    }
}
