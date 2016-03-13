package com.guest;

import com.invitation.label.WithFullAddress;
import com.invitation.name.NameFormat;
import com.validation.age.ValidateByAge;
import com.validation.country.ValidateByCountry;
import org.junit.Test;

import static org.junit.Assert.*;

public class GuestTest {
    @Test
    public void test_generateName_generates_the_name_with_the_FirstNameFirst_format() throws Exception {
        Guest john = Guest.createGuest("John", "Smith", "Male", "25", "Bangalore", "Karnataka", "India");
        assertEquals("Mr John Smith", john.generateName(NameFormat.FIRSTNAMEFIRST));
    }

    @Test
    public void test_generateName_generates_the_name_with_the_LastNameFirst_format() throws Exception {
        Guest john = Guest.createGuest("John", "Smith", "Female", "25", "Bangalore", "Karnataka", "India");
        assertEquals("Ms Smith, John", john.generateName(NameFormat.LASTNAMEFIRST));
    }

    @Test
    public void test_generateAddress_generates_the_address_with_city_state_and_country() throws Exception {
        Guest john = Guest.createGuest("John", "Smith", "Female", "25", "Bangalore", "Karnataka", "India");
        assertEquals("Bangalore, Karnataka\nIndia", john.generateAddress(new WithFullAddress()));
    }

    @Test
    public void test_isAllowed_gives_result_based_on_the_country_validator_given_to_it() throws Exception {
        Guest john = Guest.createGuest("John", "Smith", "Male", "25", "Bangalore", "Karnataka", "India");
        assertTrue(john.isAllowed(new ValidateByCountry("India")));
        assertFalse(john.isAllowed(new ValidateByCountry("USA")));
    }

    @Test
    public void test_isAllowed_gives_result_based_on_the_age_validator_given_to_it() throws Exception {
        Guest john = Guest.createGuest("John", "Smith", "Female", "25", "Bangalore", "Karnataka", "India");
        assertTrue(john.isAllowed(new ValidateByAge(24)));
        assertFalse(john.isAllowed(new ValidateByAge(60)));
    }
}