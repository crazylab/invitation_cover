package com.command;

import com.invitation.name.Caller;
import com.invitation.name.FirstNameFirst;
import com.invitation.name.LastNameFirst;

public enum NameFormatOption {
    FIRSTNAMEFIRST(new FirstNameFirst()),
    LASTNAMEFIRST(new LastNameFirst());

    private Caller caller;

    NameFormatOption(Caller caller) {
        this.caller = caller;
    }

    public Caller getCaller() {
        return caller;
    }
}
