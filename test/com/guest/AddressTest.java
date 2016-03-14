package com.guest;

import com.guest.address.Address;
import com.invitation.label.WithFullAddress;
import com.validation.country.FromCountry;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddressTest {

    @Test
    public void test_represent_represents_address_with_city_state_and_country() throws Exception {
        Address kolkata = Address.createAddress("Kolkata", "WB", "India");

        assertEquals("Kolkata, WB\nIndia", kolkata.represent(new WithFullAddress()));
    }

    @Test
    public void test_isAllowed_gives_boolean_reasult_upon_given_some_predivate_to_it() throws Exception {
        Address kolkata = Address.createAddress("Kolkata", "WB", "India");

        assertTrue(kolkata.isAllowed(new FromCountry("India")));
        assertFalse(kolkata.isAllowed(new FromCountry("USA")));
    }
}