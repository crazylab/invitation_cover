package com.guest;

import invitation.name.CasualName;
import invitation.name.FormalName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameTest {

    @Test
    public void testCall_gives_the_formal_name_with_honorific_when_formal_caller_is_given_to_it() throws Exception {
        Name name = new Name("John", "Smith");
        name.setCaller(new FormalName());
        assertEquals("Mr Smith, John", name.call("Mr"));
    }

    @Test
    public void testCall_gives_the_informal_name_with_honorific_when_casual_caller_is_given_to_it() throws Exception {
        Name name = new Name("John", "Smith");
        name.setCaller(new CasualName());
        assertEquals("Mr John Smith", name.call("Mr"));
    }
}