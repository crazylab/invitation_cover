//package guestList;
//
//import com.guestList.GuestList;
//import com.invitation.label.LabelGenerator;
//import com.invitation.name.NameFormat;
//import com.validation.ValidateByAge;
//import com.validation.ValidateByCountry;
//import com.validation.Validations;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//public class GuestListTest {
//    private GuestList guestList;
//
//    @Before
//    public void setUp() throws Exception {
//        List<String[]> guestDetailsList = new ArrayList<>();
//        guestDetailsList.add("Human,Being,Female,45,New Delhi,Delhi,India".split(","));
//        guestDetailsList.add("US,Guest,Male,4,Las Vegas,Texas,USA".split(","));
//        guestDetailsList.add("Poor,Guy,Male,25,Mumbai,Maharastra,India".split(","));
//        guestDetailsList.add("Aaguner,gola,Female,20,Dhaka,Chittagaon,Bangladesh".split(","));
//        guestList = GuestList.createGuestList(guestDetailsList);
//    }
//
//    @Test
//    public void testInviteFrom_gives_the_formal_invitation_for_all_the_guests_from_a_specific_country() throws Exception {
//        LabelGenerator labelGenerator = new LabelGenerator(NameFormat.LASTNAMEFIRST);
//        labelGenerator.addFormat(new WithCountry());
//
//        Validations validations = new Validations();
//        validations.addValidation(new ValidateByCountry("India"));
//
//        List<String> formalInvitation = guestList.invite(labelGenerator, validations);
//
//        assertEquals("Ms Being, Human, India", formalInvitation.get(0));
//        assertEquals("Mr Guy, Poor, India", formalInvitation.get(1));
//    }
//
//    @Test
//    public void testInviteFrom_gives_the_casual_invitation_for_all_the_guests_from_a_specific_country() throws Exception {
//        LabelGenerator labelGenerator = new LabelGenerator(NameFormat.FIRSTNAMEFIRST);
//        labelGenerator.addFormat(new WithCountry());
//
//        Validations validations = new Validations();
//        validations.addValidation(new ValidateByCountry("USA"));
//
//        List<String> casualInvitation = guestList.invite(labelGenerator, validations);
//
//        assertEquals("Mr US Guest, USA", casualInvitation.get(0));
//    }
//
//    @Test
//    public void testInviteFrom_gives_the_casual_invitation_with_country_and_age_for_all_the_guests_from_a_specific_country_and_having_certain_age() throws Exception {
//        LabelGenerator labelGenerator = new LabelGenerator(NameFormat.FIRSTNAMEFIRST);
//        labelGenerator.addFormat(new WithCountry());
//        labelGenerator.addFormat(new WithAge());
//
//        Validations validations = new Validations();
//        validations.addValidation(new ValidateByCountry("India"));
//        validations.addValidation(new ValidateByAge(40));
//
//        List<String> casualInvitation = guestList.invite(labelGenerator, validations);
//
//        assertEquals("Ms Human Being, India, 45", casualInvitation.get(0));
//    }
//}