package com.command;

import com.guest.Guest;
import com.validation.Validations;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CommandTest {

    private Command commandNameWithCountry;

    private Command commandNameWithAgeabove;

    @Before
    public void setUp() throws Exception {
        commandNameWithCountry = new Command("--firstNameFirst --country India file_path".split(" "));
        commandNameWithAgeabove = new Command("--firstNameFirst --ageabove age file_path".split(" "));
    }

    @Test
    public void test_getValidator_gives_the_needed_validations_for_a_command_consisting_of_country_filter() throws Exception {
        Guest indianGuest = Guest.createGuest("John", "Smith", "Male", "25", "Bangalore", "Karnataka", "India");
        Guest UKGuest = Guest.createGuest("John", "Smith", "Male", "25", "Bangalore", "Karnataka", "UK");
        Validations validator = commandNameWithCountry.getValidator();

        assertTrue(validator.isValid(indianGuest));
        assertFalse(validator.isValid(UKGuest));
    }
}