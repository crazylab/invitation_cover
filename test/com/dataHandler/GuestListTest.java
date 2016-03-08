//package com.dataHandler;
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//public class GuestListTest {
//
//    @Test
//    public void testGetFormalInvitation_gives_the_formal_invitation_for_a_specific_country() throws Exception {
//        List<String> guestListAsText = new ArrayList<String>();
//        guestListAsText.add("Human,Being,Female,45,New Delhi,Delhi,India");
//        guestListAsText.add("US,Guest,Male,4,Las Vegas,Texas,USA");
//        guestListAsText.add("Poor,guy,Male,25,Mumbai,Maharastra,India");
//        guestListAsText.add("Aaguner,gola,Female,20,Dhaka,Chittagaon,Bangladesh");
//
//        GuestList guestList = new GuestList(guestListAsText);
//        List<String> formalInvitation = guestList.getFormalInvitation("India");
//
//        assertEquals(formalInvitation.get(0),"Ms Being, Human, India");
//        assertEquals(formalInvitation.get(1),"Mr guy, Poor, India");
//    }
//
//    @Test
//    public void testGetCasualInvitation_gives_the_formal_invitation_for_a_specific_country() throws Exception {
//        List<String> guestListAsText = new ArrayList<String>();
//        guestListAsText.add("Human,Being,Female,45,New Delhi,Delhi,India");
//        guestListAsText.add("US,Guest,Male,4,Las Vegas,Texas,USA");
//        guestListAsText.add("Poor,guy,Male,25,Mumbai,Maharastra,India");
//        guestListAsText.add("Aaguner,gola,Female,20,Dhaka,Chittagaon,Bangladesh");
//
//        GuestList guestList = new GuestList(guestListAsText);
//
//        List<String> casualInvitation = guestList.getCasualInvitation("India");
//        assertEquals(casualInvitation.get(0), "Ms Human Being, India");
//        assertEquals(casualInvitation.get(1), "Mr Poor guy, India");
//    }
//}