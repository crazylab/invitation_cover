import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PersonTest {
    @Test
    public void testRepresentInvitation_represents_person_with_his_name() throws Exception {
        Name name = new Name("Brindaban", "Patra");
        Address address = new Address("Bangalore", "Karnataka", "India");
        Person brindaban = new Person(name, new Male(), 21, address);
        assertEquals(brindaban.representInvitation(), "Mr Brindaban Patra");
    }

    @Test
    public void testRepresentInvitation_represents_person_with_her_name() throws Exception {
        Name name = new Name("Jhinku", "Patra");
        Address address = new Address("Kolkata", "West Bengal", "India");
        Person jhinku = new Person(name, new Female(), 22, address);
        assertEquals(jhinku.representInvitation(), "Ms Jhinku Patra");
    }
}