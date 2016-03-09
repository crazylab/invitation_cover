package com.guest;

import invitation.name.Caller;
import invitation.name.CasualName;

public class Name {
    private String first;

    private String last;

    private Caller caller;

    public Name(String firstName, String lastName) {
        this.first = firstName;
        this.last = lastName;
        this.caller = new CasualName();
    }

    public void setCaller(Caller formatter){
        this.caller = formatter;
    }

    public String call(String prefix){
        return caller.call(prefix, first, last);
    }
}
