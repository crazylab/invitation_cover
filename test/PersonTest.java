import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PersonTest {
    @Test
    public void testRepresentInvitation_represents_person_with_his_name() throws Exception {
        Person brindaban = new Person("Brindaban", "Patra", "Male", 21, "Bangalore", "Karnataka", "India");
        assertEquals(brindaban.representInvitation(), "Mr Brindaban Patra");
    }

    @Test
    public void testRepresentInvitation_represents_person_with_her_name() throws Exception {
        Person brindaban = new Person("Jhinku", "Patra", "Female", 22, "Kolkata", "West Bengal", "India");
        assertEquals(brindaban.representInvitation(), "Ms Jhinku Patra");
    }
}