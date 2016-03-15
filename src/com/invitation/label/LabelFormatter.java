package com.invitation.label;

import com.guest.Gender;
import com.guest.name.Name;
import com.guest.address.Address;

public interface LabelFormatter {
    String generateLabel(Name name, Gender gender, Address address);
}
