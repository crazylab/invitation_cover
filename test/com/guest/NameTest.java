package com.guest;

import com.guest.name.represent.FirstNameFirst;
import com.guest.name.represent.LastNameFirst;
import com.guest.name.Name;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameTest {

    @Test
    public void testCall_gives_last_name_first_with_honorific_when_LastNameFirst_caller_is_given_to_it() throws Exception {
        Name name = new Name("John", "Smith");
        assertEquals("Mr Smith, John", name.callWithTitle("Mr", new LastNameFirst()));
    }

    @Test
    public void testCall_gives_the_first_name_first_with_honorific_when_FirstNameFirst_caller_is_given_to_it() throws Exception {
        Name name = new Name("John", "Smith");
        assertEquals("Mr John Smith", name.callWithTitle("Mr", new FirstNameFirst()));
    }
}