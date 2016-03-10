package com.invitation.label;

import com.guest.Address;
import com.guest.Age;
import com.guest.Gender;
import com.guest.Name;

public interface InvitationGenerator {
    String invite(Name name, Gender gender, Age age, Address address);
}
