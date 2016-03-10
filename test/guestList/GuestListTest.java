package guestList;

import com.validation.ValidateByCountry;
import com.validation.Validations;
import com.guestList.GuestList;
import com.invitation.label.InvitationPrinter;
import com.invitation.label.NameWithCountry;
import com.invitation.name.Caller;
import com.invitation.name.FirstNameFirst;
import com.invitation.name.LastNameFirst;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GuestListTest {
    private GuestList guestList;

    @Before
    public void setUp() throws Exception {
        List<String[]> guestDetailsList = new ArrayList<>();
        guestDetailsList.add("Human,Being,Female,45,New Delhi,Delhi,India".split(","));
        guestDetailsList.add("US,Guest,Male,4,Las Vegas,Texas,USA".split(","));
        guestDetailsList.add("Poor,guy,Male,25,Mumbai,Maharastra,India".split(","));
        guestDetailsList.add("Aaguner,gola,Female,20,Dhaka,Chittagaon,Bangladesh".split(","));
        guestList = GuestList.createGuestList(guestDetailsList);
    }

    @Test
    public void testInviteFrom_gives_the_formal_invitation_for_all_the_guests_from_a_specific_country() throws Exception {
        Caller caller = new LastNameFirst();
        InvitationPrinter invitationPrinter = new NameWithCountry(caller);

        Validations validations = new Validations();
        validations.addValidation(new ValidateByCountry("India"));

        List<String> formalInvitation = guestList.invite(invitationPrinter, validations);

        assertEquals(formalInvitation.get(0), "Ms Being, Human, India");
        assertEquals(formalInvitation.get(1), "Mr guy, Poor, India");
    }

    @Test
    public void testInviteFrom_gives_the_casual_invitation_for_all_the_guests_from_a_specific_country() throws Exception {
        Caller caller = new FirstNameFirst();
        InvitationPrinter invitationPrinter = new NameWithCountry(caller);

        Validations validations = new Validations();
        validations.addValidation(new ValidateByCountry("USA"));

        List<String> casualInvitation = guestList.invite(invitationPrinter, validations);

        assertEquals(casualInvitation.get(0), "Mr US Guest, USA");
    }
}