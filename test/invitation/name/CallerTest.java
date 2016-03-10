package invitation.name;

import com.invitation.name.Caller;
import com.invitation.name.FirstNameFirst;
import com.invitation.name.LastNameFirst;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CallerTest {

    @Test
    public void testCallWithTitle_gives_the_formal_name_with_title() throws Exception {
        Caller caller = new LastNameFirst();
        assertEquals("Mr Smith, John", caller.call("Mr", "John", "Smith"));
    }

    @Test
    public void testCallWithTitle_gives_the_casual_name_with_title() throws Exception {
        Caller caller = new FirstNameFirst();
        assertEquals("Mr John Smith", caller.call("Mr", "John", "Smith"));
    }
}