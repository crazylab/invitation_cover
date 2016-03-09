package com.guest;

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
    public void testAddCountryAtTheEnd_adds_country_at_the_end_of_the_given_label() throws Exception {
        Address kolkata = new Address("Kolkata", "WB", "India");

        assertEquals("John Smith, India", kolkata.addCountryAtTheEnd("John Smith"));
    }
}