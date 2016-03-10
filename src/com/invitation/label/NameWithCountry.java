package com.invitation.label;

import com.guest.Address;
import com.guest.Age;
import com.guest.Gender;
import com.guest.Name;
import com.invitation.name.Caller;

public class NameWithCountry implements InvitationGenerator {
    private Caller caller;

    public NameWithCountry(Caller caller) {
        this.caller = caller;
    }

    @Override
    public String invite(Name name, Gender gender, Age age, Address address) {
        String nameWithHonorific = name.call(gender.getHonorific(), caller);
        return address.addCountryAtTheEnd(nameWithHonorific);
    }
}
