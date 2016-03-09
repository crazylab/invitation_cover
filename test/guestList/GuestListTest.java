package guestList;

import com.guestList.GuestList;
import invitation.label.InvitationPrinter;
import invitation.label.NameWithCountry;
import invitation.name.Caller;
import invitation.name.CasualName;
import invitation.name.FormalName;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GuestListTest {
    private List<String> guestListAsText;
    private GuestList guestList;

    @Before
    public void setUp() throws Exception {
        guestListAsText = new ArrayList<String>();
        guestListAsText.add("Human,Being,Female,45,New Delhi,Delhi,India");
        guestListAsText.add("US,Guest,Male,4,Las Vegas,Texas,USA");
        guestListAsText.add("Poor,guy,Male,25,Mumbai,Maharastra,India");
        guestListAsText.add("Aaguner,gola,Female,20,Dhaka,Chittagaon,Bangladesh");
        guestList = new GuestList(guestListAsText);
    }

    @Test
    public void testInviteFrom_gives_the_formal_invitation_for_all_the_guests_from_a_specific_country() throws Exception {
        Caller caller = new FormalName();
        InvitationPrinter invitationPrinter = new NameWithCountry(caller);

        List<String> formalInvitation = guestList.inviteFrom("India", invitationPrinter);

        assertEquals(formalInvitation.get(0),"Ms Being, Human, India");
        assertEquals(formalInvitation.get(1),"Mr guy, Poor, India");
    }

    @Test
    public void testInviteFrom_gives_the_casual_invitation_for_all_the_guests_from_a_specific_country() throws Exception {
        Caller caller = new CasualName();
        InvitationPrinter invitationPrinter = new NameWithCountry(caller);

        List<String> casualInvitation = guestList.inviteFrom("India", invitationPrinter);

        assertEquals(casualInvitation.get(0), "Ms Human Being, India");
        assertEquals(casualInvitation.get(1), "Mr Poor guy, India");
    }
}