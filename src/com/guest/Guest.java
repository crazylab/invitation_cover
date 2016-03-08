package com.guest;

import invitation.Invitation;

public class Guest {
    private Name name;

    private Gender gender;

    private int age;

    private Address address;

    public Guest(Name name, Gender gender, int age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public String invite(Invitation invitation){
        String title = gender.getTitle();
        return invitation.invite(title, name, address);
    }
}
