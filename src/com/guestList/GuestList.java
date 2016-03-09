package com.guestList;

import com.guest.*;
import invitation.label.InvitationPrinter;

import java.util.ArrayList;
import java.util.List;

public class GuestList {
    private List<Guest> guestList = new ArrayList<Guest>();

    public GuestList(List<String> listAsText) {
        createGuestList(listAsText);
    }

    private void createGuestList(List<String> listAsText) {
        for (String guestDetails : listAsText)
            addGuest(guestDetails);
    }

    private boolean addGuest(String guestData) {
        return guestList.add(createGuest(guestData));
    }

    private Guest createGuest(String guestDetails) {
        String details[] = guestDetails.split(",");

        Name name = new Name(details[0], details[1]);
        Gender gender = Gender.valueOf(details[2].toUpperCase());
        Age age = new Age(Integer.parseInt(details[3]));
        Address address = new Address(details[4], details[5], details[6]);

        return new Guest(name, gender, age, address);
    }

    private List<Guest> getGuestsFrom(String country) {
        List<Guest> guestFromRequestedCountry = new ArrayList<Guest>();
        for (Guest guest : guestList) {
            if (guest.isFromCountry(country)) {
                guestFromRequestedCountry.add(guest);
            }
        }

        return guestFromRequestedCountry;
    }

    public List<String> inviteFrom(String country, InvitationPrinter invitationPrinter) {
        List<Guest> guestFromRequestedCountry = getGuestsFrom(country);
        List<String> invitationLabels = new ArrayList<String>();

        for (Guest guest : guestFromRequestedCountry) {
            invitationLabels.add(guest.invite(invitationPrinter));
        }
        return invitationLabels;
    }
}