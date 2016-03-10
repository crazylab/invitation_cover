package com.validation;

import com.guest.Guest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidationsTest {

    private Guest guest;

    @Before
    public void setUp() throws Exception {
        this.guest = Guest.createGuest("Ramu", "Kaka", "Male", "60", "Bhalghar", "UP", "India");
    }

    @Test
    public void test_isValid_gives_true_when_ValidateByCountry_Validator_is_added_into_Validations_and_given_a_guest_with_valid_country() throws Exception {
        Validations validations = new Validations();
        validations.addValidation(new ValidateByCountry("India"));

        assertTrue(validations.isValid(guest));
    }

    @Test
    public void test_isValid_gives_false_when_ValidateByCountry_Validator_is_added_into_Validations_and_given_a_guest_with_invalid_country() throws Exception {
        Validations validations = new Validations();
        validations.addValidation(new ValidateByCountry("Qatar"));

        assertFalse(validations.isValid(guest));
    }

    @Test
    public void test_isValid_gives_true_when_ValidateByAge_Validator_is_added_into_Validations_and_given_a_guest_with_valid_age() throws Exception {
        Validations validations = new Validations();
        validations.addValidation(new ValidateByAge(60));

        assertTrue(validations.isValid(guest));
    }

    @Test
    public void test_isValid_gives_false_when_ValidateByAge_Validator_is_added_into_Validations_and_given_a_guest_with_invalid_age() throws Exception {
        Validations validations = new Validations();
        validations.addValidation(new ValidateByAge(21));

        assertFalse(validations.isValid(guest));
    }

    @Test
    public void test_isValid_gives_true_when_all_Validator_into_Validations_are_satisfied() throws Exception {
        Validations validations = new Validations();
        validations.addValidation(new ValidateByAge(60));
        validations.addValidation(new ValidateByCountry("India"));

        assertTrue(validations.isValid(guest));
    }

    @Test
    public void test_isValid_gives_false_when_all_Validator_into_Validations_are_not_satisfied() throws Exception {
        Validations validations = new Validations();
        validations.addValidation(new ValidateByAge(21));
        validations.addValidation(new ValidateByCountry("India"));

        assertFalse(validations.isValid(guest));
    }
}