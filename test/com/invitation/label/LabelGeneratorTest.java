package com.invitation.label;

import com.guest.Guest;
import com.invitation.name.FirstNameFirst;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LabelGeneratorTest {

    private Guest guest;

    @Before
    public void setUp() throws Exception {
        this.guest = Guest.createGuest("Ramu", "Kaka", "Male", "60", "Bhalghar", "UP", "India");
    }

    @Test
    public void test_genetateLabel_generates_label_with_country() throws Exception {
        LabelGenerator labelGenerator = new LabelGenerator(new FirstNameFirst());
        labelGenerator.addFormat(new WithCountry());

        assertEquals("Mr Ramu Kaka, India", labelGenerator.genetateLabel(guest));
    }

    @Test
    public void test_genetateLabel_generates_label_with_age() throws Exception {
        LabelGenerator labelGenerator = new LabelGenerator(new FirstNameFirst());
        labelGenerator.addFormat(new WithAge());

        assertEquals("Mr Ramu Kaka, 60", labelGenerator.genetateLabel(guest));
    }

    @Test
    public void test_genetateLabel_generates_label_with_country_and_age() throws Exception {
        LabelGenerator labelGenerator = new LabelGenerator(new FirstNameFirst());
        labelGenerator.addFormat(new WithCountry());
        labelGenerator.addFormat(new WithAge());

        assertEquals("Mr Ramu Kaka, India, 60", labelGenerator.genetateLabel(guest));
    }
}