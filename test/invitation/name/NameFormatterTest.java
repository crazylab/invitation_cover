package invitation.name;

import com.invitation.name.NameFormatter;
import com.invitation.name.FirstNameFirst;
import com.invitation.name.LastNameFirst;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameFormatterTest {

    @Test
    public void testCallWithTitle_gives_the_formal_name_with_title() throws Exception {
        NameFormatter nameFormatter = new LastNameFirst();
        assertEquals("Mr Smith, John", nameFormatter.callByName("Mr", "John", "Smith"));
    }

    @Test
    public void testCallWithTitle_gives_the_casual_name_with_title() throws Exception {
        NameFormatter nameFormatter = new FirstNameFirst();
        assertEquals("Mr John Smith", nameFormatter.callByName("Mr", "John", "Smith"));
    }
}