package com.invitation.label;

import com.guest.Address;
import com.guest.Age;
import com.guest.Gender;

public class WithCountry implements InvitationFormatter {

    @Override
    public String addLabel(String currentLabel, Gender gender, Age age, Address address) {
        return address.addCountryAtTheEnd(currentLabel);
    }
}
