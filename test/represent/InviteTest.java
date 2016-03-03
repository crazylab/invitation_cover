package represent;

import com.person.Address;
import com.person.Gender;
import com.person.Name;
import com.person.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InviteTest {

    @Test
    public void testFormally_gives_the_casual_invitation_for_male() throws Exception {
        Name name = new Name("John", "Smith");
        Address address = new Address("Bangalore", "Karnataka", "India");
        Person john = new Person(name, Gender.Male, 21, address);

        assertEquals("Mr John Smith, India", new Invite(john).casully());
    }

    @Test
    public void testFormally_gives_the_casual_invitation_for_female() throws Exception {
        Name name = new Name("Maria", "Smith");
        Address address = new Address("Bangalore", "Karnataka", "India");
        Person maria = new Person(name, Gender.Female, 21, address);

        assertEquals("Ms Maria Smith, India", new Invite(maria).casully());
    }

    @Test
    public void testCasully_gives_the_formal_invitation_for_male() throws Exception {
        Name name = new Name("John", "Smith");
        Address address = new Address("Bangalore", "Karnataka", "India");
        Person john = new Person(name, Gender.Male, 21, address);

        assertEquals("Mr Smith, John, India", new Invite(john).formally());
    }

    @Test
    public void testCasually_gives_the_formal_invitation_for_female() throws Exception {
        Name name = new Name("Maria", "Smith");
        Address address = new Address("Bangalore", "Karnataka", "India");
        Person maria = new Person(name, Gender.Female, 21, address);

        assertEquals("Ms Smith, Maria, India", new Invite(maria).formally());
    }
}