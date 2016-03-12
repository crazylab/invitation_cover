//package com.guest;
//
//import com.invitation.name.NameFormat;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class GuestTest {
//    @Test
//    public void test_generateName_generates_the_name_with_the_FirstNameFirst_format() throws Exception {
//        Guest john = Guest.createGuest("John", "Smith", "Male", "25", "Bangalore", "Karnataka", "India");
//        assertEquals("Mr John Smith", john.generateName(NameFormat.FIRSTNAMEFIRST));
//    }
//
//    @Test
//    public void test_generateName_generates_the_name_with_the_LastNameFirst_format() throws Exception {
//        Guest john = Guest.createGuest("John", "Smith", "Female", "25", "Bangalore", "Karnataka", "India");
//        assertEquals("Ms Smith, John", john.generateName(NameFormat.LASTNAMEFIRST));
//    }
//
//    @Test
//    public void test_addLabel_adds_the_Country_at_the_end_of_the_given_label() throws Exception {
//        Guest john = Guest.createGuest("John", "Smith", "Female", "25", "Bangalore", "Karnataka", "India");
//        assertEquals("Ms Smith, John, India", john.addLabel("Ms Smith, John", new WithCountry()));
//    }
//
//    @Test
//    public void test_addLabel_adds_the_Age_at_the_end_of_the_given_label() throws Exception {
//        Guest john = Guest.createGuest("John", "Smith", "Female", "25", "Bangalore", "Karnataka", "India");
//        assertEquals("Ms Smith, John, 25", john.addLabel("Ms Smith, John", new WithAge()));
//    }
//
//    @Test
//    public void test_isFromCountry_gives_true_when_the_given_country_is_equals_to_the_guest_country() throws Exception {
//        Guest john = Guest.createGuest("John", "Smith", "Male", "25", "Bangalore", "Karnataka", "India");
//        assertTrue(john.isFromCountry("India"));
//        assertFalse(john.isFromCountry("USA"));
//    }
//
//    @Test
//    public void test_isAgeOf_gives_true_when_the_given_age_is_equals_to_the_guest_age() throws Exception {
//        Guest john = Guest.createGuest("John", "Smith", "Female", "25", "Bangalore", "Karnataka", "India");
//        assertTrue(john.isOlderThan(24));
//        assertFalse(john.isOlderThan(60));
//    }
//}