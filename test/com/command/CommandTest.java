package com.command;

import com.guest.Guest;
import com.validation.Validations;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CommandTest {

    @Test
    public void test_getValidator_gives_the_needed_validations_for_a_command_consisting_of_country_filter() throws Exception {
        Command commandNameWithCountry = new Command("--firstNameFirst --country India file_path".split(" "));
        Guest indianGuest = Guest.createGuest("John", "Smith", "Male", "25", "Bangalore", "Karnataka", "India");
        Guest UKGuest = Guest.createGuest("John", "Smith", "Male", "25", "Bangalore", "Karnataka", "UK");
        Validations validator = commandNameWithCountry.getValidator();

        assertTrue(validator.isValid(indianGuest));
        assertFalse(validator.isValid(UKGuest));
    }

    @Test
    public void test_getValidator_gives_the_needed_validations_for_a_command_consisting_of_ageabove_filter() throws Exception {
        Command commandNameWithAgeabove = new Command("--firstNameFirst --ageabove 30 file_path".split(" "));
        Guest age25Guest = Guest.createGuest("John", "Smith", "Male", "25", "Bangalore", "Karnataka", "India");
        Guest age60Guest = Guest.createGuest("John", "Smith", "Male", "60", "Bangalore", "Karnataka", "UK");
        Validations validator = commandNameWithAgeabove.getValidator();

        assertTrue(validator.isValid(age60Guest));
        assertFalse(validator.isValid(age25Guest));
    }

    @Test
    public void test_getValidator_gives_the_needed_validations_for_a_command_consisting_of_ageabove_and_country_filter() throws Exception {
        Command commandNameWithAgeabove = new Command("--firstNameFirst --country India --ageabove 20 file_path".split(" "));
        Guest indianAge25 = Guest.createGuest("John", "Smith", "Male", "25", "Bangalore", "Karnataka", "India");
        Guest ukAge60 = Guest.createGuest("John", "Smith", "Male", "60", "Bangalore", "Karnataka", "UK");
        Validations validator = commandNameWithAgeabove.getValidator();

        assertTrue(validator.isValid(indianAge25));
        assertFalse(validator.isValid(ukAge60));
    }
}