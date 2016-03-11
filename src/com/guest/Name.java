package com.guest;

import com.invitation.name.NameFormatter;

public class Name {
    private String first;

    private String last;

    public Name(String firstName, String lastName) {
        this.first = firstName;
        this.last = lastName;
    }

    public String call(String prefix, NameFormatter nameFormatter){
        return nameFormatter.callByName(prefix, first, last);
    }
}
