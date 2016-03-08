package com.person;

import invitation.NameWithCountry;
import invitation.name.CasualName;
import invitation.name.FormalName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {
    @Test
    public void testInvite_gives_the_casual_invitation_for_male_when_invitation_is_informal() throws Exception {
        Name name = new Name("John", "Smith", new CasualName());
        Address address = new Address("Bangalore", "Karnataka", "India");
        Guest john = new Guest(name, Gender.Male, 21, address, new NameWithCountry());

        assertEquals("Mr John Smith, India", john.invite());
    }

    @Test
    public void testInvite_gives_the_casual_invitation_for_female() throws Exception {
        Name name = new Name("Maria", "Smith", new CasualName());
        Address address = new Address("Bangalore", "Karnataka", "India");
        Guest maria = new Guest(name, Gender.Female, 21, address, new NameWithCountry());

        assertEquals("Ms Maria Smith, India", maria.invite());
    }

    @Test
    public void testInvite_gives_the_formal_invitation_for_male() throws Exception {
        Name name = new Name("John", "Smith", new FormalName());
        Address address = new Address("Bangalore", "Karnataka", "India");
        Guest john = new Guest(name, Gender.Male, 21, address, new NameWithCountry());

        assertEquals("Mr Smith, John, India", john.invite());
    }

    @Test
    public void testInvite_gives_the_formal_invitation_for_female() throws Exception {
        Name name = new Name("Maria", "Smith", new FormalName());
        Address address = new Address("Bangalore", "Karnataka", "India");
        Guest maria = new Guest(name, Gender.Female, 21, address, new NameWithCountry());

        assertEquals("Ms Smith, Maria, India", maria.invite());
    }
}