package com.guest;

import com.guest.address.represent.AddressFormatter;
import com.guest.address.represent.WithFullAddress;
import com.guest.name.represent.FirstNameFirst;
import com.guest.name.represent.LastNameFirst;
import com.guest.name.represent.NameFormatter;
import com.invitation.label.LabelFormatter;
import com.invitation.label.LabelWithNameAddress;
import com.validation.age.OlderThan;
import com.validation.age.ValidateByAge;
import com.validation.country.FromCountry;
import com.validation.country.ValidateByCountry;
import org.junit.Test;

import static org.junit.Assert.*;

public class GuestTest {

    @Test
    public void test_generateLabel_generates_the_required_label_by_using_the_given_formatter_consisting_first_name_first_and_full_address() throws Exception {
        Guest john = Guest.createGuest("John", "Smith", "Male", "25", "Kolkata", "West Bengal", "India");
        String expected =
            "+----------------------+\n" +
            "| Mr John Smith        |\n" +
            "|----------------------|\n" +
            "| Kolkata, West Bengal |\n" +
            "| India                |\n" +
            "+----------------------+";

        NameFormatter nameFormatter = new FirstNameFirst();
        AddressFormatter addressFormatter = new WithFullAddress();
        LabelFormatter labelFormatter = new LabelWithNameAddress(nameFormatter, addressFormatter);

        assertEquals(expected, john.generateLabel(labelFormatter));
    }

    @Test
    public void test_generateLabel_generates_the_required_label_by_using_the_given_formatter_consisting_last_name_first_and_full_address_for_male() throws Exception {
        Guest john = Guest.createGuest("John", "Smith", "Male", "25", "Kolkata", "West Bengal", "India");
        String expected =
            "+----------------------+\n" +
            "| Mr Smith, John       |\n" +
            "|----------------------|\n" +
            "| Kolkata, West Bengal |\n" +
            "| India                |\n" +
            "+----------------------+";

        NameFormatter nameFormatter = new LastNameFirst();
        AddressFormatter addressFormatter = new WithFullAddress();
        LabelFormatter labelFormatter = new LabelWithNameAddress(nameFormatter, addressFormatter);

        assertEquals(expected, john.generateLabel(labelFormatter));
    }

    @Test
    public void test_isAllowed_gives_result_based_on_the_country_validator_given_to_it() throws Exception {
        Guest john = Guest.createGuest("John", "Smith", "Male", "25", "Bangalore", "Karnataka", "India");
        assertTrue(john.isAllowed(new ValidateByCountry(new FromCountry("India"))));
        assertFalse(john.isAllowed(new ValidateByCountry(new FromCountry("USA"))));
    }

    @Test
    public void test_isAllowed_gives_result_based_on_the_age_validator_given_to_it() throws Exception {
        Guest john = Guest.createGuest("John", "Smith", "Female", "25", "Bangalore", "Karnataka", "India");
        assertTrue(john.isAllowed(new ValidateByAge(new OlderThan(24))));
        assertFalse(john.isAllowed(new ValidateByAge(new OlderThan(60))));
    }
}