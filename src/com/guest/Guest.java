package com.guest;

import invitation.label.InvitationPrinter;

public class Guest {
    private Name name;

    private Gender gender;

    private Age age;

    private Address address;

    public String invite(InvitationPrinter invitationPrinter){
        return  invitationPrinter.invite(name, gender, age, address);
    }

    public Guest(Name name, Gender gender, Age age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public boolean isFromCountry(String country){
        return address.isFromCountry(country);
    }
}
