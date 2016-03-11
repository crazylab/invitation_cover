package com.invitation.label;

import com.guest.Guest;
import com.invitation.name.Caller;

import java.util.ArrayList;
import java.util.List;

public class LabelGenerator {
    private List<InvitationFormatter> formats = new ArrayList<>();
    private Caller caller;

    public LabelGenerator(Caller caller) {
        this.caller = caller;
    }

    public void addFormat(InvitationFormatter formatter) {
        formats.add(formatter);
    }

    public String genetateLabel(Guest guest) {
        String label = guest.generateName(caller);
        for (InvitationFormatter format : formats)
            label = guest.addLabel(label, format);
        return label;
    }
}
