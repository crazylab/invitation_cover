package com.invitation.label;

import com.guest.Guest;
import com.invitation.name.NameFormat;

import java.util.ArrayList;
import java.util.List;

public class LabelGenerator {
    private List<InvitationFormatter> formats = new ArrayList<>();
    private NameFormat nameFormat;

    public LabelGenerator(NameFormat nameFormat) {
        this.nameFormat = nameFormat;
    }

    public void addFormat(InvitationFormatter formatter) {
        formats.add(formatter);
    }

    public String genetateLabel(Guest guest) {
        String label = guest.generateName(nameFormat);
        for (InvitationFormatter format : formats)
            label = guest.addLabel(label, format);
        return label;
    }
}
