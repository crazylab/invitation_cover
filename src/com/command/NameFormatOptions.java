package com.command;

import com.invitation.name.NameFormatter;
import com.invitation.name.FirstNameFirst;
import com.invitation.name.LastNameFirst;

public enum NameFormatOptions {
    FIRSTNAMEFIRST(new FirstNameFirst()),
    LASTNAMEFIRST(new LastNameFirst());

    private NameFormatter nameFormatter;

    NameFormatOptions(NameFormatter nameFormatter) {
        this.nameFormatter = nameFormatter;
    }

    public NameFormatter getNameFormatter() {
        return nameFormatter;
    }
}
