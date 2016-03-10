package com.guestList;

import com.validation.Validations;
import com.guest.Guest;
import com.invitation.label.InvitationPrinter;

import java.util.ArrayList;
import java.util.List;

public class GuestList {
    private List<Guest> guestList;

    public static GuestList createGuestList(List<String[]> guests) {
        List<Guest> guestList = new ArrayList<>();
        for (String[] guest : guests)
            guestList.add(Guest.createGuest(guest[0], guest[1], guest[2], guest[3], guest[4], guest[5], guest[6]));
        return new GuestList(guestList);
    }

    public GuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    public List<String> invite(InvitationPrinter invitationPrinter, Validations filter){
        List<String> invitationLabels = new ArrayList<>();
        for (Guest guest : guestList)
            if(filter.isValid(guest))
                invitationLabels.add(guest.invite(invitationPrinter));
        return invitationLabels;
    }
//    public void addGuest(Guest guest){
//        guestList.add(guest);
//    }

//    private List<Guest> getGuestsFrom(String country) {
//        List<Guest> guestFromRequestedCountry = new ArrayList<>();
//        for (Guest guest : guestList) {
//            if (guest.isFromCountry(country)) {
//                guestFromRequestedCountry.add(guest);
//            }
//        }
//
//        return guestFromRequestedCountry;
//    }
//
//    public List<String> inviteFrom(InvitationPrinter invitationPrinter) {
//        List<Guest> guestFromRequestedCountry = getGuestsFrom(country);
//        List<String> invitationLabels = new ArrayList<>();
//
//        for (Guest guest : guestFromRequestedCountry) {
//            invitationLabels.add(guest.invite(invitationPrinter));
//        }
//        return invitationLabels;
//    }
}
