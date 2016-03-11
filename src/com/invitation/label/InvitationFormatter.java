package com.invitation.label;

import com.guest.Address;
import com.guest.Age;
import com.guest.Gender;

public interface InvitationFormatter {
    String addLabel(String currentLabel, Gender gender, Age age, Address address);
}
