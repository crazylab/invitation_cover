package com.person;

public class Person {
    private Name name;

    private Gender gender;

    private int age;

    private Address address;

    public Person(Name name, Gender gender, int age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public String getCountry(){
        return address.getCountry();
    }

    private String createInvitation(String fullname) {
        String invitationTemplate = "title fullname, country";
        return invitationTemplate
                .replace("title", gender.getTitle())
                .replace("fullname", fullname)
                .replace("country", address.getCountry());
    }

    public String getFormalInvitation() {
        return createInvitation(name.representFormally());
    }

    public String getCasualInvitation() {
        return createInvitation(name.representCasually());
    }
}
