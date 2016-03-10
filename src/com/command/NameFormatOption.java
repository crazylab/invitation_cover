package com.command;

import com.invitation.name.Caller;
import com.invitation.name.FirstNameFirst;
import com.invitation.name.LastNameFirst;

public enum NameFormatOption {
    firstNameFirst(new FirstNameFirst()),
    lastNameFirst(new LastNameFirst());

    private Caller caller;

    NameFormatOption(Caller caller) {
        this.caller = caller;
    }

    public Caller getCaller(){
        return caller;
    }
}
