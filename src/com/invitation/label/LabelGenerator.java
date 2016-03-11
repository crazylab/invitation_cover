package com.invitation.label;

import com.guest.Guest;
import com.invitation.name.NameFormatter;

import java.util.ArrayList;
import java.util.List;

public class LabelGenerator {
    private List<InvitationFormatter> formats = new ArrayList<>();
    private NameFormatter nameFormatter;

    public LabelGenerator(NameFormatter nameFormatter) {
        this.nameFormatter = nameFormatter;
    }

    public void addFormat(InvitationFormatter formatter) {
        formats.add(formatter);
    }

    public String genetateLabel(Guest guest) {
        String label = guest.generateName(nameFormatter);
        for (InvitationFormatter format : formats)
            label = guest.addLabel(label, format);
        return label;
    }
}
