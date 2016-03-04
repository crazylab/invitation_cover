package com.dataHandler;

import com.person.Address;
import com.person.Gender;
import com.person.Name;
import com.person.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    @Test
    public void testGetGuestsFrom_gives_guest_list_for_a_specific_country() throws Exception {
        Database database = new Database();

        Person human = new Person(new Name("Human", "Being"), Gender.Female, 45, new Address("New Delhi", "Delhi", "India"));
        database.addToCountry("India", human);

        Person usaBoy = new Person(new Name("US", "Person"), Gender.Male, 4, new Address("Las Vagus", "Texas", "USA"));
        database.addToCountry("USA", usaBoy);

        Person poor = new Person(new Name("Poor", "guy"), Gender.Female, 25, new Address("Mumbai", "Maharastra", "India"));
        database.addToCountry("India", poor);

        Person bangal = new Person(new Name("Aaguner", "gola"), Gender.Female, 20, new Address("Dhaka", "Chittagaon", "Bangladesh"));
        database.addToCountry("Bangladesh", bangal);

        assertEquals(human, database.getGuestsFrom("India").get(0));
        assertEquals(poor, database.getGuestsFrom("India").get(1));

        assertEquals(usaBoy, database.getGuestsFrom("USA").get(0));
        assertEquals(bangal, database.getGuestsFrom("Bangladesh").get(0));


    }
}