package com.guest;

import com.invitation.label.InvitationPrinter;
import com.invitation.label.NameWithCountry;
import com.invitation.name.Caller;
import com.invitation.name.FirstNameFirst;
import com.invitation.name.LastNameFirst;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {
    @Test
    public void testInvite_gives_the_casual_invitation_for_male_when_invitation_is_informal() throws Exception {
        Name name = new Name("John", "Smith");
        Address address = new Address("Bangalore", "Karnataka", "India");
        Guest john = new Guest(name, Gender.MALE, new Age(21), address);

        Caller casualCaller = new FirstNameFirst();
        InvitationPrinter invitationPrinter = new NameWithCountry(casualCaller);
        assertEquals("Mr John Smith, India", john.invite(invitationPrinter));
    }

    @Test
    public void testInvite_gives_the_casual_invitation_for_female() throws Exception {
        Name name = new Name("Maria", "Smith");
        Address address = new Address("Bangalore", "Karnataka", "India");
        Guest maria = new Guest(name, Gender.FEMALE, new Age(21), address);

        Caller casualCaller = new FirstNameFirst();
        InvitationPrinter invitationPrinter = new NameWithCountry(casualCaller);
        assertEquals("Ms Maria Smith, India", maria.invite(invitationPrinter));
    }

    @Test
    public void testInvite_gives_the_formal_invitation_for_male() throws Exception {
        Name name = new Name("John", "Smith");
        Address address = new Address("Bangalore", "Karnataka", "India");
        Guest john = new Guest(name, Gender.MALE, new Age(21), address);

        Caller formalCaller = new LastNameFirst();
        InvitationPrinter invitationPrinter = new NameWithCountry(formalCaller);
        assertEquals("Mr Smith, John, India", john.invite(invitationPrinter));
    }

    @Test
    public void testInvite_gives_the_formal_invitation_for_female() throws Exception {
        Name name = new Name("Maria", "Smith");
        Address address = new Address("Bangalore", "Karnataka", "India");
        Guest maria = new Guest(name, Gender.FEMALE, new Age(21), address);

        Caller formalCaller = new LastNameFirst();
        InvitationPrinter invitationPrinter = new NameWithCountry(formalCaller);
        assertEquals("Ms Smith, Maria, India", maria.invite(invitationPrinter));
    }
}