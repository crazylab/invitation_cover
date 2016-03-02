package com.person;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PersonTest {
    @Test
    public void testRepresentCasually_represents_person_with_his_name() throws Exception {
        Name name = new Name("Brindaban", "Patra");
        Address address = new Address("Bangalore", "Karnataka", "India");
        Person brindaban = new Person(name, Gender.Male, 21, address);
        assertEquals(brindaban.representCasually(), "Mr Brindaban Patra");
    }

    @Test
    public void testRepresentCasually_represents_person_with_her_name() throws Exception {
        Name name = new Name("Jhinku", "Patra");
        Address address = new Address("Kolkata", "West Bengal", "India");
        Person jhinku = new Person(name, Gender.Female, 22, address);
        assertEquals(jhinku.representCasually(), "Ms Jhinku Patra");
    }

    @Test
    public void testRepresentFormally_represents_person_with_his_name() throws Exception {
        Name name = new Name("Brindaban", "Patra");
        Address address = new Address("Bangalore", "Karnataka", "India");
        Person brindaban = new Person(name, Gender.Male, 21, address);
        assertEquals(brindaban.representFormally(), "Mr Patra, Brindaban");
    }

    @Test
    public void testRepresentFormally_represents_person_with_her_name() throws Exception {
        Name name = new Name("Jhinku", "Patra");
        Address address = new Address("Kolkata", "West Bengal", "India");
        Person jhinku = new Person(name, Gender.Female, 22, address);
        assertEquals(jhinku.representFormally(), "Ms Patra, Jhinku");
    }
}