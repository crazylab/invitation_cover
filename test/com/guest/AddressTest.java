package com.guest;

import com.invitation.label.WithFullAddress;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddressTest {

    @Test
    public void testIsFromCountry_returns_true_when_country_is_same() throws Exception {
        Address kolkata = new Address("Kolkata", "WB", "India");

        assertTrue(kolkata.isFromCountry("India"));
        assertFalse(kolkata.isFromCountry("USA"));
    }

    @Test
    public void testIsFromCountry_does_not_depends_on_the_case_of_provided_country() throws Exception {
        Address kolkata = new Address("Kolkata", "WB", "India");

        assertTrue(kolkata.isFromCountry("indiA"));
        assertFalse(kolkata.isFromCountry("UsA"));
    }

    @Test
    public void test_represent_represents_address_with_city_state_and_country() throws Exception {
        Address kolkata = new Address("Kolkata", "WB", "India");

        assertEquals("Kolkata, WB\nIndia", kolkata.represent(new WithFullAddress()));
    }
}