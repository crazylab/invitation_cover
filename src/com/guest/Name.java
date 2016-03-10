package com.guest;

import com.invitation.name.Caller;

public class Name {
    private String first;

    private String last;

    public Name(String firstName, String lastName) {
        this.first = firstName;
        this.last = lastName;
    }

    public String call(String prefix, Caller caller){
        return caller.call(prefix, first, last);
    }
}
