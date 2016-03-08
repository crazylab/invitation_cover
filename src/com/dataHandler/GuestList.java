//package com.dataHandler;
//
//import com.guest.Address;
//import com.guest.Gender;
//import com.guest.Guest;
//import com.guest.Name;
//import invitation.name.CasualName;
//import invitation.name.FormalName;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GuestList {
//    private List<Guest> guestList = new ArrayList<Guest>();
//
//    public GuestList(List<String> listAsText) {
//        createGuestList(listAsText);
//    }
//
//    private void createGuestList(List<String> listAsText) {
//        for (String guestDetails : listAsText)
//            addGuest(guestDetails);
//    }
//
//    private boolean addGuest(String guestData) {
//        return guestList.add(createGuest(guestData));
//    }
//
//    private Guest createGuest(String guestDetails) {
//        String details[] = guestDetails.split(",");
//
//        Name name = new Name(details[0], details[1]);
//        Gender gender = Gender.valueOf(details[2].trim());
//        int age = Integer.parseInt(details[3].trim());
//        Address address = new Address(details[4], details[5], details[6]);
//
//        return new Guest(name, gender, age, address);
//    }
//
//    private List<Guest> getGuestsFrom(String country) {
//        List<Guest> guestFromRequestedCountry = new ArrayList<Guest>();
//        for (Guest guest : guestList) {
//            if (guest.isFromCountry(country)) {
//                guestFromRequestedCountry.add(guest);
//            }
//        }
//
//        return guestFromRequestedCountry;
//    }
//
//    public List<String> getFormalInvitation(String country) {
//        List<Guest> guestFromRequestedCountry = getGuestsFrom(country);
//        List<String> formalInvitation = new ArrayList<String>();
//
//        for (Guest guest : guestFromRequestedCountry)
//            formalInvitation.add(guest.invite(new CasualName()));
//
//        return formalInvitation;
//    }
//
//    public List<String> getCasualInvitation(String country) {
//        List<Guest> guestFromRequestedCountry = getGuestsFrom(country);
//        List<String> casualInvitation = new ArrayList<String>();
//
//        for (Guest guest : guestFromRequestedCountry)
//            casualInvitation.add(guest.invite(new FormalName()));
//
//        return casualInvitation;
//    }
//
//}
