package com.person;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {
    @Test
    public void testFormally_gives_the_casual_invitation_for_male() throws Exception {
        Name name = new Name("John", "Smith");
        Address address = new Address("Bangalore", "Karnataka", "India");
        Guest john = new Guest(name, Gender.Male, 21, address);

        assertEquals("Mr John Smith, India", john.getCasualInvitation());
    }

    @Test
    public void testFormally_gives_the_casual_invitation_for_female() throws Exception {
        Name name = new Name("Maria", "Smith");
        Address address = new Address("Bangalore", "Karnataka", "India");
        Guest maria = new Guest(name, Gender.Female, 21, address);

        assertEquals("Ms Maria Smith, India", maria.getCasualInvitation());
    }

    @Test
    public void testCasully_gives_the_formal_invitation_for_male() throws Exception {
        Name name = new Name("John", "Smith");
        Address address = new Address("Bangalore", "Karnataka", "India");
        Guest john = new Guest(name, Gender.Male, 21, address);

        assertEquals("Mr Smith, John, India", john.getFormalInvitation());
    }

    @Test
    public void testCasually_gives_the_formal_invitation_for_female() throws Exception {
        Name name = new Name("Maria", "Smith");
        Address address = new Address("Bangalore", "Karnataka", "India");
        Guest maria = new Guest(name, Gender.Female, 21, address);

        assertEquals("Ms Smith, Maria, India", maria.getFormalInvitation());
    }
}