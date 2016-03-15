package com.invitation.label;

import com.guest.Gender;
import com.guest.address.Address;
import com.guest.address.represent.WithFullAddress;
import com.guest.name.Name;
import com.guest.name.represent.FirstNameFirst;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LabelWithNameAddressTest {

    private Name name;
    private Address address;
    private Gender gender;

    @Before
    public void setUp() throws Exception {
        name = new Name("Ramu", "Kaka");
        gender = Gender.MALE;
        address = Address.createAddress("Bhalghar", "UP", "India");
    }

    @Test
    public void test_generateLabel_generates_the_label_with_the_given_name_and_address_format() throws Exception {
        LabelWithNameAddress labelGenerator = new LabelWithNameAddress(new FirstNameFirst(), new WithFullAddress());

        assertEquals(
                "+--------------+\n" +
                "| Mr Ramu Kaka |\n" +
                "|--------------|\n" +
                "| Bhalghar, UP |\n" +
                "| India        |\n" +
                "+--------------+", labelGenerator.generateLabel(name, gender, address));
    }
}