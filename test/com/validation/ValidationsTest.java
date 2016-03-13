package com.validation;

import com.guest.Guest;
import com.validation.age.ValidateByAge;
import com.validation.country.ValidateByCountry;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        ArrayList<Validator> validators = new ArrayList<>();
        validators.add(new ValidateByCountry("India"));

        Validations validations = new Validations(validators);
        assertTrue(validations.isValid(guest));
    }

    @Test
    public void test_isValid_gives_false_when_ValidateByCountry_Validator_is_added_into_Validations_and_given_a_guest_with_invalid_country() throws Exception {
        ArrayList<Validator> validators = new ArrayList<>();
        validators.add(new ValidateByCountry("Qatar"));

        Validations validations = new Validations(validators);
        assertFalse(validations.isValid(guest));
    }

    @Test
    public void test_isValid_gives_true_when_ValidateByAge_Validator_is_added_into_Validations_and_given_a_guest_with_valid_age() throws Exception {
        ArrayList<Validator> validators = new ArrayList<>();
        validators.add(new ValidateByAge(59));

        Validations validations = new Validations(validators);
        assertTrue(validations.isValid(guest));
    }

    @Test
    public void test_isValid_gives_false_when_ValidateByAge_Validator_is_added_into_Validations_and_given_a_guest_with_invalid_age() throws Exception {
        ArrayList<Validator> validators = new ArrayList<>();
        validators.add(new ValidateByAge(60));

        Validations validations = new Validations(validators);
        assertFalse(validations.isValid(guest));
    }

    @Test
    public void test_isValid_gives_true_when_all_Validator_into_Validations_are_satisfied() throws Exception {
        ArrayList<Validator> validators = new ArrayList<>();
        validators.add(new ValidateByAge(59));
        validators.add(new ValidateByCountry("India"));

        Validations validations = new Validations(validators);
        assertTrue(validations.isValid(guest));
    }

    @Test
    public void test_isValid_gives_false_when_all_Validator_into_Validations_are_not_satisfied() throws Exception {
        ArrayList<Validator> validators = new ArrayList<>();
        validators.add(new ValidateByAge(61));
        validators.add(new ValidateByCountry("India"));

        Validations validations = new Validations(validators);
        assertFalse(validations.isValid(guest));
    }
}