package com.invitation.label;

import com.guest.Guest;
import com.invitation.name.NameFormat;
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
    public void test_genetateLabel_generates_label_with_address() throws Exception {
        LabelGenerator labelGenerator = new LabelGenerator(NameFormat.FIRSTNAMEFIRST, new WithFullAddress());

        assertEquals("+--------------+\n" +
                     "| Mr Ramu Kaka |\n" +
                     "|--------------|\n" +
                     "| Bhalghar, UP |\n" +
                     "| India        |\n" +
                     "+--------------+", labelGenerator.genetateLabel(guest));
    }
}