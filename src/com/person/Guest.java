package com.person;

import invitation.Invitation;

public class Guest {
    private Name name;

    private Gender gender;

    private int age;

    private Address address;

    private Invitation invitation;

    public Guest(Name name, Gender gender, int age, Address address, Invitation invitation) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.invitation = invitation;
    }

//    private String getTitle(){
//        return gender.getTitle();
//    }

//    public boolean isFromCountry(String countryName){
//        return address.isFromCountry(countryName);
//    }

    public String invite(){
        String title = gender.getTitle();
        return invitation.invite(title, name, address);
    }

//    public String getCountry(){
//        return address.getCountry();
//    }
}
