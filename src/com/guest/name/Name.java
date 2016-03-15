package com.guest.name;

import com.guest.name.represent.NameFormatter;

public class Name {
    private String first;

    private String last;

    public Name(String firstName, String lastName) {
        this.first = firstName;
        this.last = lastName;
    }

    public String callWithTitle(String prefix, NameFormatter nameFormat){
        return nameFormat.representName(prefix, first, last);
    }
}
