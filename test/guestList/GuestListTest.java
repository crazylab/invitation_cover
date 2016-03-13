package guestList;

import com.guestList.GuestList;
import com.invitation.label.LabelGenerator;
import com.invitation.label.WithFullAddress;
import com.invitation.name.NameFormat;
import com.validation.Validator;
import com.validation.age.OlderThan;
import com.validation.age.ValidateByAge;
import com.validation.country.FromCountry;
import com.validation.country.ValidateByCountry;
import com.validation.Validations;
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
        guestDetailsList.add("Poor,Guy,Male,25,Mumbai,Maharastra,India".split(","));
        guestDetailsList.add("Aaguner,gola,Female,20,Dhaka,Chittagaon,Bangladesh".split(","));
        guestList = GuestList.createGuestList(guestDetailsList);
    }

    @Test
    public void testInviteFrom_gives_the_formal_invitation_for_all_the_guests_from_a_specific_country() throws Exception {
        LabelGenerator labelGenerator = new LabelGenerator(NameFormat.LASTNAMEFIRST, new WithFullAddress());

        ArrayList<Validator> validators = new ArrayList<>();
        validators.add(new ValidateByCountry(new FromCountry("India")));
        Validations validations = new Validations(validators);

        List<String> formalInvitation = guestList.invite(labelGenerator, validations);

        assertEquals("+------------------+\n" +
                     "| Ms Being, Human  |\n" +
                     "|------------------|\n" +
                     "| New Delhi, Delhi |\n" +
                     "| India            |\n" +
                     "+------------------+", formalInvitation.get(0));
        assertEquals("+--------------------+\n" +
                     "| Mr Guy, Poor       |\n" +
                     "|--------------------|\n" +
                     "| Mumbai, Maharastra |\n" +
                     "| India              |\n" +
                     "+--------------------+", formalInvitation.get(1));
    }

    @Test
    public void testInviteFrom_gives_the_casual_invitation_for_all_the_guests_from_a_specific_country() throws Exception {
        LabelGenerator labelGenerator = new LabelGenerator(NameFormat.FIRSTNAMEFIRST, new WithFullAddress());

        ArrayList<Validator> validators = new ArrayList<>();
        validators.add(new ValidateByCountry(new FromCountry("USA")));

        Validations validations = new Validations(validators);

        List<String> casualInvitation = guestList.invite(labelGenerator, validations);

        assertEquals("+------------------+\n" +
                     "| Mr US Guest      |\n" +
                     "|------------------|\n" +
                     "| Las Vegas, Texas |\n" +
                     "| USA              |\n" +
                     "+------------------+", casualInvitation.get(0));
    }

    @Test
    public void testInviteFrom_gives_the_casual_invitation_for_all_the_guests_from_a_specific_country_and_having_age_greater_than_the_given() throws Exception {
        LabelGenerator labelGenerator = new LabelGenerator(NameFormat.FIRSTNAMEFIRST, new WithFullAddress());

        ArrayList<Validator> validators = new ArrayList<>();
        validators.add(new ValidateByCountry(new FromCountry("India")));
        validators.add(new ValidateByAge(new OlderThan(40)));

        Validations validations = new Validations(validators);

        List<String> casualInvitation = guestList.invite(labelGenerator, validations);

        assertEquals("+------------------+\n" +
                     "| Ms Human Being   |\n" +
                     "|------------------|\n" +
                     "| New Delhi, Delhi |\n" +
                     "| India            |\n" +
                     "+------------------+", casualInvitation.get(0));
    }
}