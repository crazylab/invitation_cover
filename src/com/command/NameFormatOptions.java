package com.command;

import com.invitation.name.Caller;
import com.invitation.name.FirstNameFirst;
import com.invitation.name.LastNameFirst;

public enum NameFormatOptions {
    FIRSTNAMEFIRST(new FirstNameFirst()),
    LASTNAMEFIRST(new LastNameFirst());

    private Caller caller;

    NameFormatOptions(Caller caller) {
        this.caller = caller;
    }

    public Caller getCaller() {
        return caller;
    }
}
