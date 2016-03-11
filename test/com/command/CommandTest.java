package com.command;

import com.invitation.label.LabelGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CommandTest {

    private Command commandNameWithCountry;
    private Command commandNameWithCountryAndAge;

    @Before
    public void setUp() throws Exception {
        commandNameWithCountry = new Command("--firstNameFirst --country country_name file_path".split(" "));
        commandNameWithCountryAndAge = new Command("--firstNameFirst --country country_name --age age file_path".split(" "));
    }

    @Test
    public void test_getFileName_gives_the_file_name_that_has_been_given_to_the_command() throws Exception {

    }

    @Test
    public void test_getPrinter_gives_the_printer_that_is_needed_to_print_the_label_with_name_and_country() throws Exception {
        assertTrue(commandNameWithCountry.getLabelGenerator() instanceof LabelGenerator);
    }

    @Test
    public void test_getPrinter_gives_the_printer_that_is_needed_to_print_the_label_with_name_country_and_age() throws Exception {
    }

    @Test
    public void test_getValidator_gives_the_validations_that_has_been_asked_in_the_command() throws Exception {

    }
}