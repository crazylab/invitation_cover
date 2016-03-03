package com.person;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rahulna on 03/03/16.
 */
public class AddressTest {

    @Test
    public void testGetCountry_returns_the_country() throws Exception {
        Address address = new Address("Bangalore", "Karnataka", "India");
        assertEquals("India", address.getCountry());
    }

    @Test
    public void testGetState_returns_the_country() throws Exception {
        Address address = new Address("Bangalore", "Karnataka", "India");
        assertEquals("Karnataka", address.getState());
    }

    @Test
    public void testGetCity_returns_the_country() throws Exception {
        Address address = new Address("Bangalore", "Karnataka", "India");
        assertEquals("Bangalore", address.getCity());
    }
}