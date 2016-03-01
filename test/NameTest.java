import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rahulna on 01/03/16.
 */
public class NameTest {
    @Test
    public void testFirstNameFirst_gives_string_representation_having_first_name_first_when_male_name() throws Exception {
        Name brindaban = new Name("Brindaban", "Patra", "Male");
        assertEquals("Mr Brindaban Patra", brindaban.firstNameFirst());
    }

    @Test
    public void testLastNameFirst_gives_string_representation_having_last_name_first_when_male_name() throws Exception {
        Name brindaban = new Name("Brindaban", "Patra", "Male");
        assertEquals("Mr Patra, Brindaban", brindaban.lastNameFirst());
    }

    @Test
    public void testFirstNameFirst_gives_string_representation_having_first_name_first_when_female_name() throws Exception {
        Name brindaban = new Name("Smith", "Jane", "Female");
        assertEquals("Ms Smith Jane", brindaban.firstNameFirst());
    }

    @Test
    public void testLastNameFirst_gives_string_representation_having_last_name_first_when_female_name() throws Exception {
        Name brindaban = new Name("Smith", "Jane", "Female");
        assertEquals("Ms Jane, Smith", brindaban.lastNameFirst());
    }
}