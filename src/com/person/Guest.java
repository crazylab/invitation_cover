package com.person;

import com.invite.Invitation;

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

    private String getTitle(){
        return gender.getTitle();
    }

    private String getFormalName(){
        return name.representFormally();
    }

    private String getCasualName(){
        return name.representCasually();
    }

    public boolean isFromCountry(String countryName){
        return address.isFromCountry(countryName);
    }

    public String getFormalInvitation() {
        return new Invitation().getLabelWithCountry(getTitle(), getFormalName(), address.getCountry());
    }

    public String getCasualInvitation() {
        return new Invitation().getLabelWithCountry(getTitle(), getCasualName(), address.getCountry());
    }

    public String getCountry(){
        return address.getCountry();
    }
}
